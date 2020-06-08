package com.xl.kffta.ui.activity.lawcase

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
import com.xl.kffta.ui.fragment.lawcase.LawCaseAddNormalFragment
import com.xl.kffta.ui.fragment.lawcase.LawCaseAddTaskFragment
import com.xl.kffta.ui.fragment.lawcase.LawCaseDetailFragment
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author zhanghaochen
 * Date: 2020/5/30
 * 描述：新增案件和案件详情界面
 */
class LawCaseInfoDetailActivity : BaseActivity() {
    companion object {
        /**
         * 立案的详情信息的来源
         */
        const val LAW_CASE_SOURCE = "lawCaseSource"

        const val LAW_CASE_ID = "lawCaseId"

        const val ADD_TASK_LAW = "addTaskLaw"

        /**
         * 详情界面
         */
        const val LAW_CASE_FROM_CASE_INFO = 10

        /**
         * 新增案件
         */
        const val LAW_CASE_FROM_ADD_CASE = 13
        const val LAW_CASE_FROM_ADD_NORMAL_TASK = 11
        const val LAW_CASE_FROM_ADD_JOINT_TASK = 12
    }

    private var mLawCaseSource: Int = LAW_CASE_FROM_CASE_INFO

    private var mId = 0

    private var mTaskInfoBean: TaskInfoBean? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_lawcase_detail
    }

    override fun initParams() {
        mLawCaseSource = intent.getIntExtra(LAW_CASE_SOURCE, 0)
        mId = intent.getIntExtra(LAW_CASE_ID, 0)
        // 执法的新增案件
        mTaskInfoBean = intent.getSerializableExtra(ADD_TASK_LAW) as TaskInfoBean?
    }

    override fun initViews() {
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        when (mLawCaseSource) {
            LAW_CASE_FROM_CASE_INFO -> {
                title_name.text = "案件详情"
                val lawCaseDetailFragment = LawCaseDetailFragment()
                val bundle = Bundle()
                bundle.putInt("id", mId)
                lawCaseDetailFragment.arguments = bundle
                fragmentTransition.replace(R.id.common_case_content, lawCaseDetailFragment)
            }
            LAW_CASE_FROM_ADD_CASE -> {
                // 普通的新增案件
                title_name.text = "新增案件"
                fragmentTransition.replace(R.id.common_case_content, LawCaseAddNormalFragment())
            }
            LAW_CASE_FROM_ADD_NORMAL_TASK -> {
                // 执法的新增案件
                title_name.text = "新增案件"
                val lawCaseAddTaskFragment = LawCaseAddTaskFragment()
                val bundle = Bundle()
                bundle.putSerializable("taskInfo", mTaskInfoBean)
                lawCaseAddTaskFragment.arguments = bundle
                fragmentTransition.replace(R.id.common_case_content, lawCaseAddTaskFragment)
            }
            LAW_CASE_FROM_ADD_JOINT_TASK -> {
                // 普通的新增案件
                title_name.text = "新增案件"
                val lawCaseAddNormalFragment = LawCaseAddNormalFragment()
                val bundle = Bundle()
                bundle.putBoolean("showUserInfo", true)
                lawCaseAddNormalFragment.arguments = bundle
                fragmentTransition.replace(R.id.common_case_content, lawCaseAddNormalFragment)
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

    override fun handleMessage(message: Message) {

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