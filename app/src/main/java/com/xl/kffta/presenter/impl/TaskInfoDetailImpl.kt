package com.xl.kffta.presenter.impl

import com.google.gson.Gson
import com.xl.kffta.model.TaskInfoBean
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.util.ApplicationParams
import com.xl.kffta.view.ITaskInfoDetailView

/**
 * @author created by zhanghaochen
 * @date 2020-05-19 16:48
 * 描述：
 */
class TaskInfoDetailImpl {
    private var taskInfoDetailView: ITaskInfoDetailView? = null
    fun unBindView() {
        if (taskInfoDetailView != null) {
            taskInfoDetailView = null
        }
    }

    fun bindView(taskInfoDetailView: ITaskInfoDetailView) {
        if (this.taskInfoDetailView == null) {
            this.taskInfoDetailView = taskInfoDetailView
        }
    }

    /**
     * 查询任务信息
     */
    fun queryTaskById(id: String) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/QueryObjectByID?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentEnforcementTask"
        paramsMap["IsIncludeBlockDefintion"] = "false"
        paramsMap["ReferenceLevel"] = "1"
        paramsMap["ID"] = id
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                taskInfoDetailView?.loadViewFail(msg ?: "请求失败")
            }

            override fun onSuccess(jsonString: String) {
                try {
                    val taskInfo = Gson().fromJson(jsonString, TaskInfoBean::class.java)
                    taskInfo?.let {
                        if (it.errorCode < 0) {
                            taskInfoDetailView?.loadViewFail(it.error ?: "code<0")
                        } else {
                            taskInfoDetailView?.loadViewSuccess(it)
                        }
                    }
                    if (taskInfo == null) {
                        taskInfoDetailView?.loadViewFail("返回为空")
                    }
                } catch (e: Exception) {
                    taskInfoDetailView?.loadViewFail(e.message ?: "解析错误")
                }
            }

        }
        NetManager.manager.sendRequest(requestBuilder)
    }
}