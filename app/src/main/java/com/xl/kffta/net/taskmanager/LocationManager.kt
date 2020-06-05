package com.xl.kffta.net.taskmanager

import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import com.xl.kffta.model.LocationUploadBean
import com.xl.kffta.model.SimpleResponseBean
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.util.ApplicationParams

/**
 * @author created by zhanghaochen
 * @date 2020-06-05 14:55
 * 描述：地图相关的请求和工具类
 */
object LocationManager {
    const val TAG = "LocationManager"

    fun uploadLocationInfo(uploadLacation: LocationUploadBean) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/AddOrUpdateObject?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Common.ObjectPosition"
        paramsMap["PageCode"] = "0"
        paramsMap["IsUpdateReference"] = "false"
        paramsMap["Data"] = Gson().toJson(uploadLacation)
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                Log.e(TAG, msg ?: "执行出错")
            }

            override fun onSuccess(jsonString: String) {
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val simpleResponse: SimpleResponseBean? = Gson().fromJson(jsonString, SimpleResponseBean::class.java)
                        if (simpleResponse == null) {
                            Log.e(TAG, "解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (simpleResponse.errorCode < 0) {
                                Log.e(TAG, "解析错误")
                            } else {
                                // success
                                Log.e(TAG, "Success")
                            }
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "解析错误")
                    }
                } else {
                    Log.e(TAG, "解析错误")
                }
            }
        }
        NetManager.manager.sendRequest(requestBuilder)
    }
}