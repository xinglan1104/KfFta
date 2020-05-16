package com.xl.kffta.ui.activity

import android.os.Message
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.presenter.impl.LoginPresenterImpl
import com.xl.kffta.view.ILoginView
import kotlinx.android.synthetic.main.activity_login.*

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
            //            startActivity<MainActivity>()
            mPresenter?.LoginRequest("admin", "111111", "kaifeng")
        }
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
