package com.xl.kffta.ui.activity

import android.os.Message
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

/**
 * @author created by zhanghaochen
 * @date 2020-03-27 14:33
 * 描述：
 */
class SplashActivity : BaseActivity(), ViewPropertyAnimatorListener {
    override fun handleMessage(message: Message) {

    }


    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initViews() {
        val animate = ViewCompat.animate(splash_iv).scaleX(1.0f).scaleY(1.0f).setListener(this)

        animate.duration = 2000
    }

    override fun onAnimationCancel(view: View?) {
    }

    override fun onAnimationStart(view: View?) {
    }

    override fun onAnimationEnd(view: View?) {
        startActivity<LoginActivity>()
        finish()
    }
}
