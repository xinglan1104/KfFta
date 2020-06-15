package com.xl.kffta.net.taskmanager

import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import com.xl.kffta.model.*
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.util.ApplicationParams

/**
 * @author created by zhanghaochen
 * @date 2020-05-20 10:33
 * 描述：普通执法任务的管理类
 */
object TaskNetManager {
    const val TAG = "TaskNetManager"
    const val TASK_EXCUTIONSTATUS_PENDING = 0
    const val TASK_EXCUTIONSTATUS_APPROVED = 1

    /**
     * 根据id查询事件清单详情
     */
    fun queryCheckListById(id: String, callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/QueryObjectByID?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.CheckList"
        paramsMap["IsIncludeBlockDefintion"] = "false"
        paramsMap["ReferenceLevel"] = "1"
        paramsMap["ID"] = id
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
                        val checkListBean: CheckListBean? = Gson().fromJson(jsonString, CheckListBean::class.java)
                        if (checkListBean == null) {
                            callback.onError("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (checkListBean.errorCode < 0) {
                                callback.onError(checkListBean.error ?: "解析错误")
                            } else {
                                // success
                                callback.onSuccess(checkListBean)
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
    fun getOrCancelTask(id: String, get: Boolean, callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/ClaimOrUnClaim?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentEnforcementTask"
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
     * 查询执行任务的列表
     */
    fun queryExecuteTaskList(pageCode: Int, pageSize: Int, searchStr: String, claimed: String = "true", excutionStatus: String = "0", callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/QueryObjects?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentEnforcementTask"
        paramsMap["PageCode"] = pageCode.toString()
        paramsMap["Skip"] = "0"
        paramsMap["Take"] = pageSize.toString()
        paramsMap["CommonSearchKey"] = searchStr
        // 默认查询已领取未执行的任务
        paramsMap["SearchParam"] = "Claimed=${claimed}&ExcutionStatus=${excutionStatus}"
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                callback.onError(msg ?: "请求错误")
            }

            override fun onSuccess(jsonString: String) {
                Log.d("ExecuteListActivity", "callback获取：$jsonString")
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val exeTaskListBean: TakeOrderBean? = Gson().fromJson(jsonString, TakeOrderBean::class.java)
                        if (exeTaskListBean == null) {
                            callback.onError("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (exeTaskListBean.errorCode < 0) {
                                callback.onError(exeTaskListBean.error ?: "解析错误")
                            } else {
                                // success
                                callback.onSuccess(exeTaskListBean)
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
    fun updateTaskState(taskInfoBean: TaskInfoBean, callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/AddOrUpdateObject?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentEnforcementTask"
        paramsMap["PageCode"] = "0"
        paramsMap["IsUpdateReference"] = "false"
        paramsMap["Data"] = Gson().toJson(taskInfoBean.data)
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

    /**
     * 发送首页的数量的请求
     */
    fun getMainCount(callback: ResponseObjectCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/QueryTaskCount?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                callback.onError(msg ?: "执行出错")
            }

            override fun onSuccess(jsonString: String) {
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val countBean: QueryTaskCountBean? = Gson().fromJson(jsonString, QueryTaskCountBean::class.java)
                        if (countBean == null) {
                            callback.onError("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (countBean.errorCode < 0) {
                                callback.onError(countBean.error ?: "解析错误")
                            } else {
                                // success
                                callback.onSuccess(countBean)
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
     * 调用登陆接口，更新数据
     */
    fun loginRequestInBg(name: String, pwd: String, ComCode: String) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/AccountSignIn?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["CompanyCode"] = ComCode
        paramsMap["Username"] = name
        paramsMap["Password"] = pwd
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                Log.e(TAG, "请求失败")
            }

            override fun onSuccess(jsonString: String) {
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val userInfoBean: UserInfoBean? = Gson().fromJson(jsonString, UserInfoBean::class.java)
                        if (userInfoBean == null) {
                            Log.e(TAG, "请求失败")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (userInfoBean.errorCode < 0) {
                                Log.e(TAG, "请求失败")
                            } else {
                                // 请求成功，把token保存下来
                                ApplicationParams.TOKEN = userInfoBean.token
                                ApplicationParams.USER_ID = userInfoBean.user?.id ?: 0L
                                ApplicationParams.USER_NAME = userInfoBean.user?.userName ?: ""
                                ApplicationParams.USER_PWD = pwd
                                ApplicationParams.USER_PHONE = userInfoBean.user?.mobilePhone ?: ""
                                ApplicationParams.USER_ADDRESS = userInfoBean.user?.additionInfo
                                        ?: ""
                                ApplicationParams.USER_INFO_BEAN = userInfoBean
                                // 获取用户属于的部门
                                val departments = userInfoBean.user?.department
                                if (!departments.isNullOrEmpty()) {
                                    val sb = StringBuilder("")
                                    departments.forEachIndexed { index, departmentBean ->
                                        if (index != departments.size - 1) {
                                            sb.append(departmentBean.name).append("|")
                                        } else {
                                            sb.append(departmentBean.name)
                                        }
                                    }
                                    ApplicationParams.USER_DEPARTMENTS = sb.toString()
                                }
                                ApplicationParams.USER_DEPARTMENTS
                                Log.d("net", "TOKEN:${ApplicationParams.TOKEN}")
                            }
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "请求失败")
                    }
                } else {
                    Log.e(TAG, "请求失败")
                }
            }

        }
        NetManager.manager.sendRequest(requestBuilder)
    }
}