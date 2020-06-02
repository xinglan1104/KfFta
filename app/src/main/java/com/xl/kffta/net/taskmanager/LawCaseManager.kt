package com.xl.kffta.net.taskmanager

import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import com.xl.kffta.model.lawcase.LawCaseObjectsBean
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.util.ApplicationParams

/**
 * @author created by zhanghaochen
 * @date 2020-06-02 17:15
 * 描述：案件相关的所有请求类
 */
object LawCaseManager {
    const val TAG = "LawCaseManager"

    /**
     * 查询所有的案件们
     */
    fun queryLawCaseObjects(pageCode: String, pageSize: Int, callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/QueryObjects?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentLegalCase"
        paramsMap["PageCode"] = pageCode
        paramsMap["Skip"] = "0"
        paramsMap["Take"] = pageSize.toString()
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                callback.onError(msg ?: "请求错误")
            }

            override fun onSuccess(jsonString: String) {
                Log.d(TAG, "callback获取：$jsonString")
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val lawCaseObjectsBean: LawCaseObjectsBean? = Gson().fromJson(jsonString, LawCaseObjectsBean::class.java)
                        if (lawCaseObjectsBean == null) {
                            callback.onError("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (lawCaseObjectsBean.errorCode < 0) {
                                callback.onError(lawCaseObjectsBean.error ?: "解析错误")
                            } else {
                                // success
                                callback.onSuccess(lawCaseObjectsBean)
                            }
                        }
                    } catch (e: Exception) {
                        callback.onError(e.message ?: "解析错误")
                    }
                } else {
                    callback.onError("请求返回为空")
                }
            }
        }
        NetManager.manager.sendRequest(requestBuilder)
    }
}