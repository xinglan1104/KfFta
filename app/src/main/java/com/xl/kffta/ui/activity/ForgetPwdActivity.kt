package com.xl.kffta.ui.activity

import android.os.Message
import android.text.TextUtils
import androidx.core.widget.doOnTextChanged
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author zhanghaochen
 * date 2020-05-17
 * 描述：忘记密码界面
 */
class ForgetPwdActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_forget_pwd
    }

    override fun handleMessage(message: Message) {

    }

    override fun initViews() {
        title_name.text = "忘记密码"
    }

    override fun initListener() {
        title_left.setOnClickListener {
            finish()
        }

        pwd_name_et.doOnTextChanged { text, start, before, count ->
            if (!TextUtils.isEmpty(pwd_comcode_et.text.toString().trim()) && !TextUtils.isEmpty(pwd_email_et.text.toString().trim())) {
                pwd_submit_btn.isEnabled = !TextUtils.isEmpty(text)
            } else {
                pwd_submit_btn.isEnabled = false
            }
        }
        pwd_comcode_et.doOnTextChanged { text, start, before, count ->
            if (!TextUtils.isEmpty(pwd_name_et.text.toString().trim()) && !TextUtils.isEmpty(pwd_email_et.text.toString().trim())) {
                pwd_submit_btn.isEnabled = !TextUtils.isEmpty(text)
            } else {
                pwd_submit_btn.isEnabled = false
            }
        }
        pwd_email_et.doOnTextChanged { text, start, before, count ->
            if (!TextUtils.isEmpty(pwd_name_et.text.toString().trim()) && !TextUtils.isEmpty(pwd_comcode_et.text.toString().trim())) {
                pwd_submit_btn.isEnabled = !TextUtils.isEmpty(text)
            } else {
                pwd_submit_btn.isEnabled = false
            }
        }
    }
}