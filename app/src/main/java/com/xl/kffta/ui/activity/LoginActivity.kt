package com.xl.kffta.ui.activity

import android.os.Message
import android.text.TextUtils
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.presenter.impl.LoginPresenterImpl
import com.xl.kffta.view.ILoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

/**
 * @author created by zhanghaochen
 * @date 2020-05-15 16:08
 * 描述：
 */
class LoginActivity : BaseActivity(), ILoginView {

    private var mPresenter: LoginPresenterImpl? = LoginPresenterImpl()

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun handleMessage(message: Message) {
    }

    override fun initViews() {
        super.initViews()
    }

    override fun initListener() {
        login_btn.setOnClickListener {
            when {
                TextUtils.isEmpty(user_name_et.text.toString().trim()) -> {
                    myToast("请输入用户名")
                }
                TextUtils.isEmpty(user_pwd_et.text.toString().trim()) -> {
                    myToast("请输入密码")
                }
                else -> {
                    mPresenter?.LoginRequest(user_name_et.text.toString().trim(), user_pwd_et.text.toString().trim(), "kaifeng")
                }
            }
        }
    }

    override fun loginSuccess() {
        runOnUiThread {
            // 登录成功
            startActivity<MainActivity>()
        }
    }

    override fun loginFail(errMsg: String) {
        myToast(errMsg)
    }

    override fun onResume() {
        super.onResume()
        mPresenter?.bindView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.unBindView()
        mPresenter = null
    }
}
