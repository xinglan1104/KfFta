package com.xl.kffta.ui.activity

import android.os.Message
import androidx.core.content.ContextCompat
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.widget.CountDownTextView
import kotlinx.android.synthetic.main.activity_mobile_login.*
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
        mobile_get.setOnClickListener {
            it as CountDownTextView
            it.startCountDown(60)
        }
    }
}