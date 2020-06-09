package com.xl.kffta.base

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import com.xl.kffta.R
import com.xl.kffta.util.ApplicationParams
import com.xl.kffta.widget.LoadingView
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import java.lang.ref.WeakReference

/**
 * @author created by zhanghaochen
 * @date 2020-05-15 14:05
 * 描述：所有activity的基类
 */
abstract class BaseActivity : AppCompatActivity(), AnkoLogger {
    @JvmField
    protected val mHandler: MyHandler = MyHandler(this)
    protected val mLoadingView by lazy {
        find<LoadingView>(R.id.main_loading)
    }

    companion object {
        /**
         * 用于判读activity context是否已经被销毁
         *
         * @param context
         * @return
         */
        fun isValidContext(context: Context?): Boolean {
            if (context == null) {
                return false
            }
            if (context is Activity) {
                val activity = context as Activity?
                val isDestroyed = Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN && activity!!.isDestroyed
                return !(isDestroyed || activity!!.isFinishing)
            }
            return true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initStateBar()
        setContentView(R.layout.activity_main_root)
        val mainView = find<FrameLayout>(R.id.main_view)
        val contentView = LayoutInflater.from(this).inflate(getLayoutId(), null)
        contentView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        mainView.addView(contentView)

        // 在请求之前，先把全局的filepath重置
        ApplicationParams.TEMP_FILE_PATH = ""

        initParams()
        initViews()
        initListener()
        initData()
    }

    open protected fun initStateBar() {

    }

    protected class MyHandler(activity: BaseActivity) : Handler() {

        private val mActivity: WeakReference<BaseActivity> = WeakReference(activity)

        override fun handleMessage(msg: Message) {
            val activity = mActivity.get()
            if (activity != null && isValidContext(activity)) {
                activity.handleMessage(msg)
            }
            super.handleMessage(msg)
        }
    }

    /**
     * activity的布局Id
     */
    abstract fun getLayoutId(): Int

    protected abstract fun handleMessage(message: Message)

    /**
     * 初始化adapter以及listener
     */
    open protected fun initListener() {

    }

    /**
     * 初始化数据
     */
    open protected fun initData() {

    }

    open protected fun initViews() {

    }

    open protected fun initParams() {

    }

    open protected fun myToast(msg: String) {
        runOnUiThread {
            toast(msg)
        }
    }

    fun showProgress(showText: Boolean = false, @ColorRes colorRes: Int = R.color.btn_common_color) {
        runOnUiThread {
            try {
                mLoadingView?.let {
                    mLoadingView.showLoading(showText, colorRes)
                    // 为了防止出现这个loading界面，无法操作别的部分，16s后自动小时
//                    mHandler.postDelayed({
//                        hideProgress()
//                    }, 16000)
                }
            } catch (e: Exception) {
            }
        }
    }

    fun hideProgress() {
        runOnUiThread {
            try {
                mLoadingView?.hide()
            } catch (e: Exception) {
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ApplicationParams.TEMP_FILE_PATH = ""
    }
}
