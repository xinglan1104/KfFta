package com.xl.kffta.ui.activity.lawcase

import android.os.Message
import android.view.View
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import kotlinx.android.synthetic.main.layout_title_bar.*
import org.jetbrains.anko.startActivity

/**
 * @author zhanghaochen
 * Date: 2020/5/30
 * 描述：案件主界面，是个搜索列表
 */
class LawcaseListActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_lawcase_list
    }

    override fun handleMessage(message: Message) {

    }

    override fun initViews() {
        title_name.text = "案件"
        title_add.visibility = View.VISIBLE
        title_left.setOnClickListener {
            finish()
        }
    }

    override fun initListener() {
        title_add.setOnClickListener {
            startActivity<LawCaseInfoDetailActivity>(
                    LawCaseInfoDetailActivity.LAW_CASE_SOURCE to LawCaseInfoDetailActivity.LAW_CASE_FROM_ADD_CASE)
        }
    }
}