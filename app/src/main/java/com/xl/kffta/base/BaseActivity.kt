package com.xl.kffta.base

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast
import java.lang.ref.WeakReference

/**
 * @author created by zhanghaochen
 * @date 2020-05-15 14:05
 * 描述：所有activity的基类
 */
abstract class BaseActivity : AppCompatActivity(), AnkoLogger {
    protected val mHandler: MyHandler = MyHandler(this)

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
        setContentView(getLayoutId())
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

    open protected fun myToast(msg: String) {
        runOnUiThread {
            toast(msg)
        }
    }


}
