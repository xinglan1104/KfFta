package com.xl.kffta.ui.activity

import android.os.Message
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import kotlinx.android.synthetic.main.activity_login.*

/**
 * @author created by zhanghaochen
 * @date 2020-05-15 16:08
 * 描述：
 */
class LoginActivity : BaseActivity() {
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
            NetManager.manager.sendRequest(RequestBuilder(this))
        }
    }
}
