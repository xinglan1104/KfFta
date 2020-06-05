package com.xl.kffta.net.taskmanager

import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import com.xl.kffta.model.SimpleResponseBean
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.util.ApplicationParams

/**
 * @author created by zhanghaochen
 * @date 2020-06-05 16:50
 * 描述：附件相关的请求管理类
 */
object FilesNetManager {

    /**
     * 上传单个文件，
     */
    fun uploadSingleFile(filePath: String, file: String) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/AddFile?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        val testPath = "4578|CloudEasy.ERP.BL.Model.Government.GovermentEnforcementTask|CloudEasy.ERP.BL.Model.Government.GovermentEnforcementTask_20200601_0a17e88ab5214e51b4e607cfebb090ec"
        // todo 测试上传功能
        paramsMap["FilePath"] = testPath
        paramsMap["file"] = file
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                Log.e(LocationManager.TAG, msg ?: "执行出错")
            }

            override fun onSuccess(jsonString: String) {
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val simpleResponse: SimpleResponseBean? = Gson().fromJson(jsonString, SimpleResponseBean::class.java)
                        if (simpleResponse == null) {
                            Log.e(LocationManager.TAG, "解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (simpleResponse.errorCode < 0) {
                                Log.e(LocationManager.TAG, "解析错误")
                            } else {
                                // success
                                Log.e(LocationManager.TAG, "Success")
                            }
                        }
                    } catch (e: Exception) {
                        Log.e(LocationManager.TAG, "解析错误")
                    }
                } else {
                    Log.e(LocationManager.TAG, "解析错误")
                }
            }
        }
        NetManager.manager.sendRequest(requestBuilder)
    }

    /**
     * 清楚对应path的
     */
    fun emptyTempFolder(filePath: String) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/EmptyTempFolder?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["FilePath"] = filePath
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                Log.e(LocationManager.TAG, msg ?: "执行出错")
            }

            override fun onSuccess(jsonString: String) {
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val simpleResponse: SimpleResponseBean? = Gson().fromJson(jsonString, SimpleResponseBean::class.java)
                        if (simpleResponse == null) {
                            Log.e(LocationManager.TAG, "解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (simpleResponse.errorCode < 0) {
                                Log.e(LocationManager.TAG, "解析错误")
                            } else {
                                // success
                                Log.e(LocationManager.TAG, "Success")
                            }
                        }
                    } catch (e: Exception) {
                        Log.e(LocationManager.TAG, "解析错误")
                    }
                } else {
                    Log.e(LocationManager.TAG, "解析错误")
                }
            }
        }
        NetManager.manager.sendRequest(requestBuilder)
    }
}