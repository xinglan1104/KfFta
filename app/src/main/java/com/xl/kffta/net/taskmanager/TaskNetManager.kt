package com.xl.kffta.net.taskmanager

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
}