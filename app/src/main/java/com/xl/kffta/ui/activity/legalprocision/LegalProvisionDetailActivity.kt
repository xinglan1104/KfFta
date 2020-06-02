package com.xl.kffta.ui.activity.legalprocision

import android.os.Message
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.legalprovision.LegalProvisionBean
import com.xl.kffta.util.SysUtils
import kotlinx.android.synthetic.main.activity_legal_detail.*
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author created by zhanghaochen
 * @date 2020-06-02 14:36
 * 描述：法律条文的详情，这边由于只是展示和条目较少
 * 直接全部写在布局中
 */
class LegalProvisionDetailActivity : BaseActivity() {
    companion object {
        const val LEGAL_BEAN = "legalBean"
        const val LEGAL_TITLE = "legalTitle"
    }

    private var mLegalBean: LegalProvisionBean.DataBean? = null
    private var mTitleStr = ""

    override fun getLayoutId(): Int {
        return R.layout.activity_legal_detail
    }

    override fun handleMessage(message: Message) {

    }

    override fun initParams() {
        mTitleStr = intent.getStringExtra(LEGAL_TITLE)
        mLegalBean = intent.getSerializableExtra(LEGAL_BEAN) as LegalProvisionBean.DataBean?
    }

    override fun initViews() {
        title_name.text = "${mTitleStr}详情"
        title_left.setOnClickListener {
            finish()
        }

        // 直接赋值不bb
        mLegalBean?.let {
            // 联合惩戒部门可能是多个
            val departments = it.department
            if (!departments.isNullOrEmpty()) {
                val departmentsStr = StringBuilder("")
                departments.forEach { department ->
                    departmentsStr.append(department.name.toString())
                    departmentsStr.append(",")
                }
                if (departmentsStr.length > 2) {
                    // 把最后一个,逗号替换掉
                    departmentsStr.replace(departmentsStr.length - 1, departmentsStr.length, "")
                }
                detail_value.text = departmentsStr.toString().trim()
            }

            detail_value2.text = it.creator?.displayName ?: ""
            detail_value3.text = SysUtils.getDateTimestamp(it.createTime)
            detail_value4.text = it.name ?: ""
            detail_value5.text = it.penalties ?: ""
        }
    }
}