package com.xl.kffta.net.taskmanager

import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import com.xl.kffta.model.CommonFileBean
import com.xl.kffta.model.GetFilepathBean
import com.xl.kffta.model.SimpleResponseBean
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.util.ApplicationParams
import com.xl.kffta.viewholder.AddPictureFileViewHolder

/**
 * @author created by zhanghaochen
 * @date 2020-06-05 16:50
 * 描述：附件相关的请求管理类
 */
object FilesNetManager {
    const val TAG = "FilesNetManager"

    const val LAWCASE_CODENAME = "CloudEasy.ERP.BL.Model.Government.GovermentLegalCase"
    const val TASK_CODENAME = "CloudEasy.ERP.BL.Model.Government.GovermentEnforcementTask"

    /**
     * 上传单个文件，
     */
    fun uploadSingleFile(filePath: String, file: String, callback: AddPictureFileViewHolder.UploadFileCallback) {
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
                            Log.e(TAG, "解析错误 simpleResponse == null")
                            callback.uploadSuccss(false)
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (simpleResponse.errorCode < 0) {
                                Log.e(LocationManager.TAG, "解析错误 获取ErrorCode<0")
                                callback.uploadSuccss(false)
                            } else {
                                // success
                                Log.e(TAG, "Success")
                                callback.uploadSuccss(true)
                            }
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "Gson解析错误")
                        callback.uploadSuccss(false)
                    }
                } else {
                    Log.e(TAG, "解析错误 返回string isEmpty")
                    callback.uploadSuccss(false)
                }
            }
        }
        NetManager.manager.sendRequest(requestBuilder)
    }

    /**
     * 清除对应path的
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

    /**
     * 没有files字段时，发送这个请求搞一下
     */
    fun getUploadFilePath(codeName: String, callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/GetFileUnic?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["CodeName"] = codeName
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Field"] = "Files"
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                callback.onError(msg ?: "执行出错")
            }

            override fun onSuccess(jsonString: String) {
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val simpleResponse: GetFilepathBean? = Gson().fromJson(jsonString, GetFilepathBean::class.java)
                        if (simpleResponse == null) {
                            callback.onError("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (simpleResponse.errorCode < 0) {
                                callback.onError("解析错误")
                            } else {
                                // success
                                callback.onSuccess(simpleResponse)
                            }
                        }
                    } catch (e: Exception) {
                        callback.onError("解析错误")
                    }
                } else {
                    callback.onError("解析错误")
                }
            }
        }
        NetManager.manager.sendRequest(requestBuilder)
    }

    /**
     * 通过id获取对应的附件信息
     */
    fun getFiles(ids: ArrayList<Long>, callback: ResponseObjectCallback) {
        if (ids.isNullOrEmpty()) {
            callback.onError("没有选择ids")
            return
        }
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/QueryFile?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["FileIDs"] = Gson().toJson(ids)
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                callback.onError(msg ?: "执行出错")
            }

            override fun onSuccess(jsonString: String) {
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val simpleResponse: CommonFileBean? = Gson().fromJson(jsonString, CommonFileBean::class.java)
                        if (simpleResponse == null) {
                            callback.onError("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (simpleResponse.errorCode < 0) {
                                callback.onError("解析错误")
                            } else {
                                // success
                                callback.onSuccess(simpleResponse)
                            }
                        }
                    } catch (e: Exception) {
                        callback.onError("解析错误")
                    }
                } else {
                    callback.onError("解析错误")
                }
            }
        }
        NetManager.manager.sendRequest(requestBuilder)
    }
}