package com.xl.kffta.net.taskmanager

import com.google.gson.Gson
import com.xl.kffta.model.TaskInfoBean
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.util.ApplicationParams

/**
 * @author created by zhanghaochen
 * @date 2020-05-20 10:33
 * 描述：
 */
object TaskNetManager {
    /**
     * 根据id查询事件清单详情
     */
    fun queryCheckListById(id: String, callback: ResponseCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/QueryObjectByID?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.CheckList"
        paramsMap["IsIncludeBlockDefintion"] = "false"
        paramsMap["ReferenceLevel"] = "1"
        paramsMap["ID"] = id
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = callback
        NetManager.manager.sendRequest(requestBuilder)
    }

    /**
     * 领取或者退回任务
     */
    fun getOrCancelTask(id: String, get: Boolean, callback: ResponseCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/QueryObjectByID?format=json"
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
        requestBuilder.callback = callback
        NetManager.manager.sendRequest(requestBuilder)
    }

    /**
     * 查询执行任务的列表
     */
    fun queryExecuteTaskList(pageCode: Int, pageSize: Int, searchStr: String, callback: ResponseCallback?) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/QueryObjects?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentEnforcementTask"
        paramsMap["PageCode"] = pageCode.toString()
        paramsMap["Skip"] = "0"
        paramsMap["Take"] = pageSize.toString()
        paramsMap["CommonSearchKey"] = searchStr
        // 查询执行任务，应是已领取的
        paramsMap["SearchParam"] = "Claimed=true"
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = callback
        NetManager.manager.sendRequest(requestBuilder)
    }

    /**
     * 更新任务状态，主要是变成执行任务
     */
    fun updateTaskState(taskInfoBean: TaskInfoBean, callback: ResponseCallback) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/AddOrUpdateObject?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentEnforcementTask"
        paramsMap["PageCode"] = "0"
        paramsMap["IsUpdateReference"] = "false"
        paramsMap["Data"] = Gson().toJson(taskInfoBean)
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = callback
        NetManager.manager.sendRequest(requestBuilder)
    }
}