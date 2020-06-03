package com.xl.kffta.ui.activity.lawcase

import android.os.Bundle
import android.os.Message
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.ui.fragment.lawcase.LawCaseAddNormalFragment
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

    override fun getLayoutId(): Int {
        return R.layout.activity_lawcase_detail
    }

    override fun initParams() {
        mLawCaseSource = intent.getIntExtra(LAW_CASE_SOURCE, 0)
        mId = intent.getIntExtra(LAW_CASE_ID, 0)
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
                title_name.text = "新增案件"
                fragmentTransition.replace(R.id.common_case_content, LawCaseAddNormalFragment())
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
}