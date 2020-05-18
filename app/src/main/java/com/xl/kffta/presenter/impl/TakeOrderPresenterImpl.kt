package com.xl.kffta.presenter.impl

import com.google.gson.Gson
import com.xl.kffta.model.TakeOrderBean
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.presenter.interf.ITakeOrderPresenter
import com.xl.kffta.util.ApplicationParams
import com.xl.kffta.view.ITakeOrderView

/**
 * @author zhanghaochen
 * Date: 2020/5/18
 * 描述：领取任务的接口实现类
 */
class TakeOrderPresenterImpl : ITakeOrderPresenter {
    private var takeOrderView: ITakeOrderView? = null
    fun unBindView() {
        if (takeOrderView != null) {
            takeOrderView = null
        }
    }

    fun bindView(takeOrderView: ITakeOrderView) {
        if (this.takeOrderView == null) {
            this.takeOrderView = takeOrderView
        }
    }

    /**
     * 查询领取的任务
     */
    override fun queryTask(pageCode: String, skip: String, take: String) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/QueryObjects?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["PageCode"] = pageCode
        paramsMap["Skip"] = skip
        paramsMap["Take"] = take
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Government.GovermentEnforcementTask"
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                takeOrderView?.refreshAllFail(msg ?: "请求失败")
            }

            override fun onSuccess(jsonString: String) {
                try {
                    val takeOrderBean = Gson().fromJson(jsonString, TakeOrderBean::class.java)
                    takeOrderBean?.let {
                        if (it.errorCode < 0) {
                            takeOrderView?.refreshAllFail(it.error ?: "code<0")
                        } else {
                            takeOrderView?.refreshAllSuccess(it)
                        }
                    }
                    if (takeOrderBean == null) {
                        takeOrderView?.refreshAllFail("返回为空")
                    }
                } catch (e: Exception) {
                    takeOrderView?.refreshAllFail(e.message ?: "解析错误")
                }

            }
        }
        NetManager.manager.sendRequest(requestBuilder)
    }
}