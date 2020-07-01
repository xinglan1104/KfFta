package com.xl.kffta.net.taskmanager

import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import com.xl.kffta.model.SimpleResponseBean
import com.xl.kffta.model.upload.WarnUploadBean
import com.xl.kffta.model.warn.WarnByIdBean
import com.xl.kffta.model.warn.WarnObjectsBean
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.util.ApplicationParams

/**
 * @author created by zhanghaochen
 * @date 2020-06-12 16:35
 * 描述：预警相关的帮助类
 */
object WarnManager {
    const val TAG = "WarnManager"

    /**
     * 查询所有的预警信息
     */
    fun queryWarnObjects(pageCode: String, pageSize: Int, searchStr: String, callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://221.176.156.138/Services/serviceapi/web/QueryObjects?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentWarning"
        paramsMap["PageCode"] = pageCode
        paramsMap["Skip"] = "0"
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
                        val warnObjectsBean: WarnObjectsBean? = Gson().fromJson(jsonString, WarnObjectsBean::class.java)
                        if (warnObjectsBean == null) {
                            callback.onError("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (warnObjectsBean.errorCode < 0) {
                                callback.onError(warnObjectsBean.error ?: "解析错误")
                            } else {
                                // success
                                callback.onSuccess(warnObjectsBean)
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

    /**
     * 根据id查询项目检查详情
     */
    fun queryWarnById(id: Int, callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://221.176.156.138/Services/serviceapi/web/QueryObjectByID?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentWarning"
        paramsMap["ID"] = id.toString()
        paramsMap["IsIncludeBlockDefintion"] = "false"
        paramsMap["ReferenceLevel"] = "2"
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
                        val warnIdBean: WarnByIdBean? = Gson().fromJson(jsonString, WarnByIdBean::class.java)
                        if (warnIdBean == null) {
                            callback.onError("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (warnIdBean.errorCode < 0) {
                                callback.onError(warnIdBean.error ?: "解析错误")
                            } else {
                                // success
                                callback.onSuccess(warnIdBean)
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

    /**
     * 新增预警
     */
    fun addNewWarning(warnByIdBean: WarnUploadBean, callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://221.176.156.138/Services/serviceapi/web/AddOrUpdateObject?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentWarning"
        paramsMap["PageCode"] = "0"
        paramsMap["IsUpdateReference"] = "false"
        paramsMap["Data"] = Gson().toJson(warnByIdBean)
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                callback.onError(msg ?: "执行出错")
            }

            override fun onSuccess(jsonString: String) {
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val simpleResponse: SimpleResponseBean? = Gson().fromJson(jsonString, SimpleResponseBean::class.java)
                        if (simpleResponse == null) {
                            callback.onError("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (simpleResponse.errorCode < 0) {
                                callback.onError(simpleResponse.error ?: "解析错误")
                            } else {
                                // success
                                callback.onSuccess("success")
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
