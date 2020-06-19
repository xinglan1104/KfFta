package com.xl.kffta.widget

import android.content.Context
import android.os.CountDownTimer
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import java.util.concurrent.TimeUnit

/**
 * @author created by zhanghaochen
 * @date 2020-06-19 10:33
 * 描述：自定义倒计时控件
 */
class CountDownTextView : AppCompatTextView, LifecycleObserver {
    interface OnCountDownTextListener {
        fun onStart()
        /**
         * 每秒自己刷新textView
         *
         * @param untilFinished 剩余的时间
         * @param showTime      可以直接使用的显示时间
         * @param tv            控件
         */
        fun onTick(untilFinished: Long, showTime: String, tv: CountDownTextView)

        fun onFinish(tv: CountDownTextView)
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    var normalText: String = ""
    var countDownText: String = ""

    var clickEnable: Boolean = false
    var isFormatTime: Boolean = false

    private var countDownTimer: CountDownTimer? = null
    var countDownListener: OnCountDownTextListener? = null

    init {
        autoBindLifecycle(context)
    }

    /**
     * 控件自动绑定生命周期,宿主可以是activity或者fragment
     */
    private fun autoBindLifecycle(context: Context) {
        if (context is AppCompatActivity) {
            // 宿主是activity
            val activity = context as AppCompatActivity
            val fm = activity.getSupportFragmentManager()
            val fragments = fm.getFragments()
            if (!fragments.isNullOrEmpty()) {
                fragments.forEach {
                    val parent = it.getView()
                    parent?.let { parent ->
                        val find = parent.findViewById<View>(id)
                        if (find === this) {
                            it.getLifecycle().addObserver(this)
                            return@forEach
                        }
                    }

                }
            }
        }
        // 宿主是fragment
        if (context is LifecycleOwner) {
            (context as LifecycleOwner).getLifecycle().addObserver(this)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestory() {
        countDownTimer?.cancel()
        countDownTimer = null

        countDownListener = null
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        onDestory()
    }

    /**
     * 非倒计时状态的文本
     */
    fun setNormalText(normalStr: String): CountDownTextView {
        normalText = normalStr
        text = normalText
        countDownTimer?.cancel()
        countDownTimer = null

        countDownListener = null
        return this
    }

    fun startCountDown(time: Long, timeUnit: TimeUnit = TimeUnit.SECONDS) {
        count(time, timeUnit, true)
    }

    private fun count(time: Long, tiemUint: TimeUnit = TimeUnit.SECONDS, isCountDown: Boolean = true) {
        countDownTimer?.cancel()
        countDownTimer = null

        isEnabled = clickEnable
        // 换算成毫秒
        val millisInFuture = tiemUint.toMillis(time) + 500
        // 时间间隔为1s
        val interval: Long = TimeUnit.MILLISECONDS.convert(1, tiemUint)

        countDownListener?.onStart()

        countDownTimer = object : CountDownTimer(millisInFuture, interval) {
            override fun onFinish() {
                isEnabled = true
                countDownTimer = null
                text = normalText
                countDownListener?.onFinish(this@CountDownTextView)
            }

            override fun onTick(millisUntilFinished: Long) {
                val count: Long = if (isCountDown) {
                    millisUntilFinished
                } else {
                    millisInFuture - millisUntilFinished
                }

                val l = tiemUint.convert(count, TimeUnit.MILLISECONDS)

                val showTime = "${l}s"

                countDownListener?.onTick(l, showTime, this@CountDownTextView)
            }

        }
        countDownTimer?.start()
    }
}