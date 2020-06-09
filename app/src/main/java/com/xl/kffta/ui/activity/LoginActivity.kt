package com.xl.kffta.ui.activity

import android.graphics.Color
import android.os.Build
import android.os.Message
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.presenter.impl.LoginPresenterImpl
import com.xl.kffta.util.ApplicationParams
import com.xl.kffta.view.ILoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity


/**
 * @author created by zhanghaochen
 * @date 2020-05-15 16:08
 * 描述：登录界面
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

        // 如果有token，就直接进入主界面
        login_main.visibility = if (ApplicationParams.TOKEN.isNullOrEmpty()) {
            View.VISIBLE
        } else {
            View.GONE
        }

        if (!ApplicationParams.TOKEN.isNullOrEmpty()) {
            mHandler.postDelayed({
                // 直接登陆
                startActivity<MainActivity>()
                finish()
            }, 1000)
        }
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
                    showProgress(showText = false, colorRes = R.color.login_bg_enable)
                    mPresenter?.loginRequest(user_name_et.text.toString().trim(), user_pwd_et.text.toString().trim(), "kaifeng")
                }
            }
        }
        // 忘记密码的按钮
        login_forget_pwd_tv.setOnClickListener {
            startActivity<ForgetPwdActivity>()
        }

//        addLayoutListener(login_main, login_btn)
    }

    override fun initStateBar() {
        setStatusBarTransparent()
    }

    /**
     * 设置透明状态栏
     */
    private fun setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }

//    /**
//     * 保持登录按钮始终不会被覆盖
//     *
//     * @param root
//     * @param subView
//     */
//    fun addLayoutListener(root: View, subView: View) {
//        root.viewTreeObserver.addOnGlobalLayoutListener {
//            val rect = Rect()
//            // 获取root在窗体的可视区域
//            root.getWindowVisibleDisplayFrame(rect)
//            // 获取root在窗体的不可视区域高度(被其他View遮挡的区域高度)
//            val rootInvisibleHeight = root.rootView.height - rect.bottom
//            // 若不可视区域高度大于200，则键盘显示,其实相当于键盘的高度
//            if (rootInvisibleHeight > 200) {
//                // 显示键盘时
//                val srollHeight = rootInvisibleHeight - (root.bottom - subView.bottom)
//                if (srollHeight > 0) {//当键盘高度覆盖按钮时
//                    subView.scrollTo(0, srollHeight)
//                }
//            } else {
//                // 隐藏键盘时
//                subView.scrollTo(0, 0)
//            }
//        }
//
//    }

    override fun loginSuccess() {
        runOnUiThread {
            hideProgress()
            // 登录成功
            startActivity<MainActivity>()
            finish()
        }
    }

    override fun loginFail(errMsg: String) {
        hideProgress()
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
