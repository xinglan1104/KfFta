package com.xl.kffta.presenter.impl

import android.text.TextUtils
import android.util.Log
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.presenter.interf.ILoginPresenter
import com.xl.kffta.util.ApplicationParams
import com.xl.kffta.view.ILoginView
import org.json.JSONObject

class LoginPresenterImpl : ILoginPresenter {
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

    override fun loginRequest(name: String, pwd: String, ComCode: String) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/AccountSignIn?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["CompanyCode"] = ComCode
        paramsMap["Username"] = name
        paramsMap["Password"] = pwd
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                loginView?.loginFail(msg ?: "请求失败")
            }

            override fun onSuccess(jsonString: String) {
                Log.d("LoginPresenterImpl", "callback获取：$jsonString")
                if (!TextUtils.isEmpty(jsonString)) {
                    val jsonObject = JSONObject(jsonString)
                    try {
                        // 获取ErrorCode,<0时错误
                        val errorCode = jsonObject.optInt("ErrorCode", -1)
                        if (errorCode < 0) {
                            loginView?.loginFail(jsonObject.optString("Error", "fail"))
                        } else {
                            // 请求成功，把token保存下来
                            ApplicationParams.TOKEN = jsonObject.optString("Token", "")
                            Log.d("net", "TOKEN:${ApplicationParams.TOKEN}")
                            loginView?.loginSuccess()
                        }
                    } catch (e: Exception) {
                        loginView?.loginFail(e.message ?: "解析错误")
                    }
                } else {
                    loginView?.loginFail("请求返回为空")
                }
            }

        }
        NetManager.manager.sendRequest(requestBuilder)
    }
}