package com.xl.kffta.ui.activity.legalprocision

import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.legalprovision.LegalProvisionBean
import kotlinx.android.synthetic.main.activity_legal_detail.*
import kotlinx.android.synthetic.main.layout_title_bar.*
import org.jetbrains.anko.find

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

    private val mAdapter by lazy {
        MyAdapter()
    }

    private var mLegalBean: LegalProvisionBean.DataBean? = null
    private var mTitleStr = ""

    private val mDataItems = ArrayList<LegalDetailItem>()

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

        legal_detail_recycler.layoutManager = object : LinearLayoutManager(this) {
            override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
                try {
                    super.onLayoutChildren(recycler, state)
                } catch (ignored: Exception) {
                }
            }
        }
        legal_detail_recycler.adapter = mAdapter

        // 直接赋值不bb
        mLegalBean?.let {
            initDataItems(it)
            mAdapter.notifyDataChanged(mDataItems)
        }
    }

    private fun initDataItems(bean: LegalProvisionBean.DataBean) {
        mDataItems.clear()
        when (bean.pageCode) {
            130, 129 -> {
                // 许可处罚信息
                // 协同监管措施
                // 联合惩戒部门可能是多个
                val departments = bean.department
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
                    mDataItems.add(LegalDetailItem("联合惩戒部门", departmentsStr.toString().trim()))
                }
//                mDataItems.add(LegalDetailItem("创建人", bean.creator?.displayName ?: ""))
//                mDataItems.add(LegalDetailItem("创建时间", SysUtils.getDateTimestamp(bean.createTime)))
                mDataItems.add(LegalDetailItem("法律法规及政策依据", bean.name ?: ""))
                mDataItems.add(LegalDetailItem("惩罚措施", bean.penalties ?: ""))
            }
            128 -> {
                // 联合惩戒措施
                val departments = bean.department
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
                    mDataItems.add(LegalDetailItem("联合惩戒部门", departmentsStr.toString().trim()))
                }
                mDataItems.add(LegalDetailItem("惩戒事项", bean.name ?: ""))
//                mDataItems.add(LegalDetailItem("创建人", bean.creator?.displayName ?: ""))
//                mDataItems.add(LegalDetailItem("创建时间", SysUtils.getDateTimestamp(bean.createTime)))
                mDataItems.add(LegalDetailItem("惩罚措施", bean.penalties ?: ""))
                mDataItems.add(LegalDetailItem("法律法规及政策依据", bean.legalBasis ?: ""))
            }
            127 -> {
                // 省级下放权限清单
                mDataItems.add(LegalDetailItem("事项名称", bean.name ?: ""))
                val departments = bean.department
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
                    mDataItems.add(LegalDetailItem("联合惩戒部门", departmentsStr.toString().trim()))
                }
                // 实施部门可能是多个
                val dd = bean.implementationDepartment
                if (!dd.isNullOrEmpty()) {
                    val ddStrs = StringBuilder("")
                    dd.forEach { d ->
                        ddStrs.append(d.name.toString())
                        ddStrs.append(",")
                    }
                    if (ddStrs.length > 2) {
                        ddStrs.replace(ddStrs.length - 1, ddStrs.length, "")
                    }
                    mDataItems.add(LegalDetailItem("实施部门", ddStrs.toString().trim()))
                }
                mDataItems.add(LegalDetailItem("职权类别", bean.priviledge ?: ""))
                mDataItems.add(LegalDetailItem("下放理由", bean.reason ?: ""))
                mDataItems.add(LegalDetailItem("备注", bean.note ?: ""))
//                mDataItems.add(LegalDetailItem("创建时间", SysUtils.getDateTimestamp(bean.createTime)))
            }
            133 -> {
                // 企业登记
                mDataItems.add(LegalDetailItem("提供信息事项", bean.name ?: ""))
                mDataItems.add(LegalDetailItem("法律法规及政策依据", bean.legalBasis ?: ""))
//                mDataItems.add(LegalDetailItem("创建时间", SysUtils.getDateTimestamp(bean.createTime)))
            }
            134 -> {
                // 市场准入和任职
                mDataItems.add(LegalDetailItem("联合惩罚领域", bean.name ?: ""))
                mDataItems.add(LegalDetailItem("法律法规及政策依据", bean.legalBasis ?: ""))
                mDataItems.add(LegalDetailItem("信息提供部门和信息类型", bean.priviledge ?: ""))
                mDataItems.add(LegalDetailItem("限制方式", bean.penalties ?: ""))
//                mDataItems.add(LegalDetailItem("创建时间", SysUtils.getDateTimestamp(bean.createTime)))
            }
            126 -> {
                // 自贸区权限清单
                val departments = bean.department
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
                    mDataItems.add(LegalDetailItem("承建部门", departmentsStr.toString().trim()))
                }
                mDataItems.add(LegalDetailItem("事项名称", bean.name ?: ""))
                // 实施部门可能是多个
                val dd = bean.implementationDepartment
                if (!dd.isNullOrEmpty()) {
                    val ddStrs = StringBuilder("")
                    dd.forEach { d ->
                        ddStrs.append(d.name.toString())
                        ddStrs.append(",")
                    }
                    if (ddStrs.length > 2) {
                        ddStrs.replace(ddStrs.length - 1, ddStrs.length, "")
                    }
                    mDataItems.add(LegalDetailItem("实施部门", ddStrs.toString().trim()))
                }
                mDataItems.add(LegalDetailItem("职权类别", bean.priviledge ?: ""))
                mDataItems.add(LegalDetailItem("下放理由", bean.reason ?: ""))
                mDataItems.add(LegalDetailItem("备注", bean.note ?: ""))
            }
        }
    }

    private class MyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        private val mDatas = ArrayList<LegalDetailItem>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_legal_detail, parent, false)

            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return mDatas.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if (holder is MyViewHolder) {
                holder.label.text = mDatas[position].label
                holder.value.text = mDatas[position].value
            }
        }

        fun notifyDataChanged(datas: ArrayList<LegalDetailItem>) {
            if (datas.isNotEmpty()) {
                mDatas.clear()
                mDatas.addAll(datas)
                notifyDataSetChanged()
            }
        }
    }

    private class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label = itemView.find<TextView>(R.id.detail_label)
        val value = itemView.find<TextView>(R.id.detail_value)
    }

    private data class LegalDetailItem(var label: String, var value: String)
}