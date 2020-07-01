package com.xl.kffta.net.taskmanager

import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import com.xl.kffta.model.legalprovision.LegalProvisionBean
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.util.ApplicationParams

/**
 * @author created by zhanghaochen
 * @date 2020-06-01 15:14
 * 描述：法律条文管理类
 */
object LegalLawManager {
    const val TAG = "LegalLawManager"

    /**
     * 根据pagecode查询不同类型的法律条文
     */
    fun queryLegalProvision(pageCode: String, searchStr: String, pageSize: Int, callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://221.176.156.138/Services/serviceapi/web/QueryObjects?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.LegalProvision"
        paramsMap["PageCode"] = pageCode
        paramsMap["Take"] = pageSize.toString()
        paramsMap["CommonSearchKey"] = searchStr
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
                        val legalObject: LegalProvisionBean? = Gson().fromJson(jsonString, LegalProvisionBean::class.java)
                        if (legalObject == null) {
                            callback.onError("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (legalObject.errorCode < 0) {
                                callback.onError(legalObject.error ?: "解析错误")
                            } else {
                                // success
                                callback.onSuccess(legalObject)
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
