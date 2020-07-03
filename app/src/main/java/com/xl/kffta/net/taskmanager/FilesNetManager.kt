package com.xl.kffta.net.taskmanager

import android.net.Uri
import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import com.xl.kffta.model.CommonFileBean
import com.xl.kffta.model.GetFilepathBean
import com.xl.kffta.model.SimpleResponseBean
import com.xl.kffta.model.UploadedFileBean
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.util.ApplicationParams
import com.xl.kffta.util.ApplicationParams.HTTP_URL_HEAD
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
    const val JOINT_TASK_CODENAME = "CloudEasy.ERP.BL.Model.Government.GovermentJointSupervisionTask"
    const val WARN_CODENAME = "CloudEasy.ERP.BL.Model.Government.GovermentWarning"

    /**
     * 上传单个文件，
     * @param filePath 文件路径，不是上传路径
     */
    fun uploadSingleFile(filePath: String, callback: AddPictureFileViewHolder.UploadFileWithPathCallback) {
        if (ApplicationParams.TEMP_FILE_PATH.isEmpty()) {
            callback.uploadSuccss(false, "")
            return
        }
        val requestBuilder = RequestBuilder()
        val paramsMap = hashMapOf<String, String>()
        requestBuilder.url = "${HTTP_URL_HEAD}/web/AddFile?format=json"
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["FilePath"] = ApplicationParams.TEMP_FILE_PATH
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                Log.e(TAG, "onError " + (msg ?: "执行出错"))
            }

            override fun onSuccess(jsonString: String) {
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val simpleResponse: UploadedFileBean? = Gson().fromJson(jsonString, UploadedFileBean::class.java)
                        if (simpleResponse == null) {
                            Log.e(TAG, "解析错误 simpleResponse == null")
                            callback.uploadSuccss(false, "")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (simpleResponse.errorCode < 0) {
                                Log.e(LocationManager.TAG, "解析错误 获取ErrorCode<0")
                                callback.uploadSuccss(false, "")
                            } else {
                                // success
                                Log.e(TAG, "Success")
                                callback.uploadSuccss(true, simpleResponse.fileNames[0])
                            }
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "Gson解析错误")
                        callback.uploadSuccss(false, "")
                    }
                } else {
                    Log.e(TAG, "解析错误 返回string isEmpty")
                    callback.uploadSuccss(false, "")
                }
            }
        }
        NetManager.manager.sendRequestWithHeader(requestBuilder, filePath)
    }

    fun deleteUploadSingleFile(filePath: String, fileName: String, callback: AddPictureFileViewHolder.DeleteUploadFileCallback) {
        if (filePath.isEmpty()) {
            callback.deleteSuccss(false)
            return
        }
        val requestBuilder = RequestBuilder()
        val paramsMap = hashMapOf<String, String>()
        requestBuilder.url = "${HTTP_URL_HEAD}/web/DeleteTempFile?format=json"
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["FileName"] = filePath
        paramsMap["FilePath"] = fileName
        Log.e(TAG, "deleteUploadSingleFile FilePath = " + fileName)
        Log.e(TAG, "deleteUploadSingleFile FileName = " + filePath)
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                Log.e(TAG, "onError " + (msg ?: "执行出错"))
            }

            override fun onSuccess(jsonString: String) {
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val simpleResponse: SimpleResponseBean? = Gson().fromJson(jsonString, SimpleResponseBean::class.java)
                        if (simpleResponse == null) {
                            Log.e(TAG, "解析错误 simpleResponse == null")
                            callback.deleteSuccss(false)
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (simpleResponse.errorCode < 0) {
                                Log.e(LocationManager.TAG, "解析错误 获取ErrorCode<0")
                                callback.deleteSuccss(false)
                            } else {
                                // success
                                Log.e(TAG, "Success")
                                callback.deleteSuccss(true)
                            }
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "Gson解析错误")
                        callback.deleteSuccss(false)
                    }
                } else {
                    Log.e(TAG, "解析错误 返回string isEmpty")
                    callback.deleteSuccss(false)
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
        requestBuilder.url = "${HTTP_URL_HEAD}/web/EmptyTempFolder?format=json"
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
        requestBuilder.url = "${HTTP_URL_HEAD}/web/GetFileUnic?format=json"
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
        requestBuilder.url = "${HTTP_URL_HEAD}/web/QueryFile?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["RequiredVideoThumbnail"] = "true"
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
                                // 手动添加url字段
                                if (!simpleResponse.files.isNullOrEmpty()) {
                                    val tokenString = Uri.encode(ApplicationParams.TOKEN)
                                    simpleResponse.files.forEach { fileBean ->
                                        fileBean.downloadUrl = "${HTTP_URL_HEAD}/web/DownloadFile?Token=${tokenString}&id=${fileBean.id}"
                                    }
                                }
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