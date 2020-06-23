package com.xl.kffta.ui.activity

import android.os.Message
import androidx.core.content.ContextCompat
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.TaskNetManager
import com.xl.kffta.util.DialogUtil
import com.xl.kffta.util.SysUtils
import com.xl.kffta.widget.CountDownTextView
import kotlinx.android.synthetic.main.activity_mobile_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.textColor

/**
 * @author created by zhanghaochen
 * @date 2020-06-18 16:45
 * 描述：手机登陆界面
 */
class MobileLoginActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_mobile_login
    }

    override fun handleMessage(message: Message) {

    }

    override fun initListener() {
        mobile_get.setNormalText("获取验证码").countDownListener = object : CountDownTextView.OnCountDownTextListener {
            override fun onStart() {

            }

            override fun onTick(untilFinished: Long, showTime: String, tv: CountDownTextView) {
                tv.textColor = ContextCompat.getColor(this@MobileLoginActivity, R.color.text_value)
                tv.text = showTime
            }

            override fun onFinish(tv: CountDownTextView) {
                tv.textColor = ContextCompat.getColor(this@MobileLoginActivity, R.color.btn_common_color)
            }

        }

        mobile_login_mobile.setOnClickListener {
            startActivity<LoginActivity>()
            finish()
        }

        // 获取验证码按钮
        mobile_get.setOnClickListener {
            it as CountDownTextView
            // 校验手机号
            val innerText = user_mobile_et.text.toString()
            if (SysUtils.validateMobilePhone(innerText)) {
                // 是手机号，发送请求
                sendVerifyCode(innerText)
                it.startCountDown(60)
            } else {
                DialogUtil.showSingleCommonDialog(context = this, msg = "请输入正确的手机号")
            }
        }

        mobile_login_btn.setOnClickListener {
            // 登陆按钮
            if (user_mobile_et.text.toString().isEmpty()) {
                DialogUtil.showSingleCommonDialog(context = this, msg = "请输入手机号")
            } else if (user_pwd_et.text.toString().isEmpty()) {
                DialogUtil.showSingleCommonDialog(context = this, msg = "请输入验证码")
            } else {
                // 都输入了，首先校验手机号格式
                val innerText = user_mobile_et.text.toString()
                if (SysUtils.validateMobilePhone(innerText)) {
                    requestLogin(innerText, user_pwd_et.text.toString())
                } else {
                    DialogUtil.showSingleCommonDialog(context = this, msg = "请输入正确的手机号")
                }
            }
        }
    }

    override fun initStateBar() {
        setStatusBarTransparent()
    }

    private fun sendVerifyCode(phoneNumber: String) {
        showProgress()
        TaskNetManager.requestVerifyCode(phoneNumber, "kaifeng", object : ResponseObjectCallback {
            override fun onError(msg: String) {
                hideProgress()
                myToast(msg)
            }

            override fun onSuccess(obj: Any) {
                hideProgress()
                myToast("验证码已发送")
            }

        })
    }

    private fun requestLogin(phoneNumber: String, verifyCode: String) {
        showProgress()
        TaskNetManager.loginRequestByMobile(phoneNumber, verifyCode, "kaifeng", object : ResponseObjectCallback {
            override fun onError(msg: String) {
                hideProgress()
                myToast(msg)
            }

            override fun onSuccess(obj: Any) {
                runOnUiThread {
                    hideProgress()
                    // 登陆成功
                    startActivity<MainActivity>()
                    finish()
                }
            }

        })
    }
}