package com.xl.kffta.presenter.impl

import android.util.Log
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.presenter.interf.ILoginPresenter
import com.xl.kffta.view.ILoginView

class LoginPresenterImpl() : ILoginPresenter {
    private var loginView: ILoginView? = null
    fun unBindView() {
        if (loginView != null) {
            loginView = null
        }
    }

    fun bindView(loginView: ILoginView) {
        if (this.loginView == null) {
            this.loginView = loginView
        }
    }

    override fun LoginRequest(name: String, pwd: String, ComCode: String) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/AccountSignIn?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["CompanyCode"] = "kaifeng"
        paramsMap["Username"] = "admin"
        paramsMap["Password"] = "111111"
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                TODO("Not yet implemented")
            }

            override fun onSuccess(result: Any?) {
                val r = result as String
                Log.d("LoginPresenterImpl", "callback获取：$r")
            }

        }
        NetManager.manager.sendRequest(requestBuilder)
    }
}