package com.xl.kffta.ui.activity.warn

import android.content.Context
import android.os.Bundle
import android.os.Message
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.TaskInfoBean
import com.xl.kffta.ui.fragment.warn.WarnAddNormalFragment
import com.xl.kffta.ui.fragment.warn.WarnDetailFragment
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author zhanghaochen
 * Date: 2020/6/13
 * 描述：预警详情页
 */
class WarnInfoDetailActivity : BaseActivity() {
    companion object {
        /**
         * 预警的详情信息的来源
         */
        const val WARN_SOURCE = "warnSource"

        const val WARN_ID = "warnCaseId"

        const val TASK_INFO_BEAN = "taskInfoBean"

        /**
         * 预警详情界面
         */
        const val WARN_FROM_WARN_LIST = 10

        /**
         * 新增预警
         */
        const val WARN_FROM_ADD_COMMON = 13
        const val WARN_FROM_ADD_NORMAL_TASK = 11
        const val WARN_FROM_ADD_JOINT_TASK = 12
    }

    private var mWarnSource: Int = WARN_FROM_WARN_LIST

    private var mId = 0

    private var mTaskInfoBean: TaskInfoBean? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_lawcase_detail
    }

    override fun initParams() {
        mWarnSource = intent.getIntExtra(WARN_SOURCE, 0)
        mId = intent.getIntExtra(WARN_ID, 0)
        // 执法的新增案件
        mTaskInfoBean = intent.getSerializableExtra(TASK_INFO_BEAN) as TaskInfoBean?
    }

    override fun handleMessage(message: Message) {

    }

    override fun initViews() {
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        when (mWarnSource) {
            WARN_FROM_WARN_LIST -> {
                title_name.text = "预警"
                val warnDetailFragment = WarnDetailFragment()
                val bundle = Bundle()
                bundle.putInt("id", mId)
                bundle.putBoolean("fileOnlyShow", true)
                warnDetailFragment.arguments = bundle
                fragmentTransition.replace(R.id.common_case_content, warnDetailFragment)
            }
            WARN_FROM_ADD_COMMON -> {
                // 普通的新增预警
                title_name.text = "预警"
                val warnDetailFragment = WarnAddNormalFragment()
                val bundle = Bundle()
                bundle.putBoolean("showUserInfo", true)
                bundle.putBoolean("fileOnlyShow", false)
                warnDetailFragment.arguments = bundle
                fragmentTransition.replace(R.id.common_case_content, warnDetailFragment)
            }
            WARN_FROM_ADD_NORMAL_TASK -> {
                // 执法的新增预警
                title_name.text = "预警"
                val warnDetailFragment = WarnAddNormalFragment()
                val bundle = Bundle()
                bundle.putBoolean("showUserInfo", true)
                bundle.putSerializable(TASK_INFO_BEAN, mTaskInfoBean)
                bundle.putBoolean("fileOnlyShow", false)
                warnDetailFragment.arguments = bundle
                fragmentTransition.replace(R.id.common_case_content, warnDetailFragment)
            }
            WARN_FROM_ADD_JOINT_TASK -> {
                // 普通的新增预警
                title_name.text = "预警"
                val warnDetailFragment = WarnAddNormalFragment()
                val bundle = Bundle()
                bundle.putBoolean("showUserInfo", true)
                bundle.putBoolean("fileOnlyShow", false)
                warnDetailFragment.arguments = bundle
                fragmentTransition.replace(R.id.common_case_content, warnDetailFragment)
            }
            else -> {
                title_name.text = "新增案件"
            }
        }
        fragmentTransition.commit()
    }

    override fun initListener() {
        title_left.setOnClickListener {
            finish()
        }
    }

    // 点击其他地方隐藏键盘和光标
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val view = currentFocus
            if (isShouldHideInput(view, ev)) {
                val Object = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                Object?.hideSoftInputFromWindow(view?.getWindowToken(), 0)
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    //判断是否隐藏键盘
    fun isShouldHideInput(v: View?, event: MotionEvent): Boolean {
        if (v != null && v is EditText) {
            val leftTop = intArrayOf(0, 0)
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop)
            val left = leftTop[0]
            val top = leftTop[1]
            val bottom = top + v.height
            val right = left + v.width
            return if (event.x > left && event.x < right
                    && event.y > top && event.y < bottom) {
                false
            } else {
                true
            }
        }
        return false
    }
}