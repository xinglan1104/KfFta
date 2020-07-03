package com.xl.kffta.net.taskmanager

import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import com.xl.kffta.model.JointTaskBean
import com.xl.kffta.model.JointTaskInfoBean
import com.xl.kffta.model.SimpleResponseBean
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.util.ApplicationParams
import com.xl.kffta.util.ApplicationParams.HTTP_URL_HEAD

/**
 * @author zhanghaochen
 * Date: 2020/5/20
 * 描述：项目检查任务的管理类
 */
object JointTaskManager {
    const val TAG = "TaskNetManager"

    // 接受状态
    const val AcceptStatusApproved = 3
    const val AcceptStatusPending = 1

    // 执行状态，已完成和等待
    const val ExcutionStatus_Complete = 1
    const val ExcutionStatus_Pending = 0

    /**
     * 查询待领取的项目检查任务
     */
    fun queryJointTask(pageCode: Int, pageSize: Int, callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "${HTTP_URL_HEAD}/web/QueryObjects?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentJointSupervisionTask"
        paramsMap["PageCode"] = pageCode.toString()
        paramsMap["Skip"] = "0"
        paramsMap["Take"] = pageSize.toString()
        // 仅查询没有领取的
        paramsMap["SearchParam"] = "Claimed=false"
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
                        val jointTaskBean: JointTaskBean? = Gson().fromJson(jsonString, JointTaskBean::class.java)
                        if (jointTaskBean == null) {
                            callback.onError("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (jointTaskBean.errorCode < 0) {
                                callback.onError(jointTaskBean.error ?: "解析错误")
                            } else {
                                // success
                                callback.onSuccess(jointTaskBean)
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
     * 领取或者退回任务
     */
    fun getOrCancelJointTask(id: String, get: Boolean, callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "${HTTP_URL_HEAD}/web/ClaimOrUnClaim?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentJointSupervisionTask"
        paramsMap["Claim"] = if (get) {
            "true"
        } else {
            "false"
        }
        paramsMap["ID"] = id
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                callback.onError(msg ?: "操作出错")
            }

            override fun onSuccess(jsonString: String) {
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val taskGetOrCancel: SimpleResponseBean? = Gson().fromJson(jsonString, SimpleResponseBean::class.java)
                        if (taskGetOrCancel == null) {
                            callback.onError("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (taskGetOrCancel.errorCode < 0) {
                                callback.onError(taskGetOrCancel.error ?: "解析错误")
                            } else {
                                // success
                                callback.onSuccess("领取成功")
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
    fun queryJointTaskById(id: String, callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "${HTTP_URL_HEAD}/web/QueryObjectByID?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentJointSupervisionTask"
        paramsMap["ID"] = id
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
                        val jointTaskInfoBean: JointTaskInfoBean? = Gson().fromJson(jsonString, JointTaskInfoBean::class.java)
                        if (jointTaskInfoBean == null) {
                            callback.onError("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (jointTaskInfoBean.errorCode < 0) {
                                callback.onError(jointTaskInfoBean.error ?: "解析错误")
                            } else {
                                // success
                                callback.onSuccess(jointTaskInfoBean)
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
     * 查询执行项目检查任务的列表
     */
    fun queryExecuteJointTaskList(pageCode: Int, pageSize: Int, searchStr: String, excutionStatus: String, callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "${HTTP_URL_HEAD}/web/QueryObjects?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentJointSupervisionTask"
        paramsMap["PageCode"] = pageCode.toString()
        paramsMap["Skip"] = "0"
        paramsMap["Take"] = pageSize.toString()
        paramsMap["CommonSearchKey"] = searchStr
        // 查询执行项目检查任务，应是已领取的
        paramsMap["SearchParam"] = "Claimed=true&ExcutionStatus=${excutionStatus}"
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
                        val jointTaskBean: JointTaskBean? = Gson().fromJson(jsonString, JointTaskBean::class.java)
                        if (jointTaskBean == null) {
                            callback.onError("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (jointTaskBean.errorCode < 0) {
                                callback.onError(jointTaskBean.error ?: "解析错误")
                            } else {
                                // success
                                callback.onSuccess(jointTaskBean)
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
     * 更新任务状态，主要是变成执行任务
     */
    fun updateJointTaskState(jointTaskBean: JointTaskInfoBean, callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "${HTTP_URL_HEAD}/web/AddOrUpdateObject?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentJointSupervisionTask"
        paramsMap["PageCode"] = "0"
        paramsMap["IsUpdateReference"] = "false"
        paramsMap["Data"] = Gson().toJson(jointTaskBean.data)
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