package com.xl.kffta.adapter.legal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.legalprovision.LegalProvisionBean
import com.xl.kffta.viewholder.NoDataViewHolder
import org.jetbrains.anko.find

/**
 * @author zhanghaochen
 * Date: 2020/6/1
 * 描述：法律条文列表页的适配器
 */
class LegalListAdapter(var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface OnLegalItemClick {
        fun onItemClick(legalBean: LegalProvisionBean.DataBean)
    }

    val mDatas = ArrayList<LegalProvisionBean.DataBean>()

    var mHasNotified = false

    var mOnItemClickListener: OnLegalItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_legal_list, parent, false)
        val noDataView = LayoutInflater.from(parent.context).inflate(R.layout.item_no_data, parent, false)

        return if (viewType == 0) {
            NoDataViewHolder(noDataView)
        } else {
            LegalListViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return if (mDatas.size <= 0) {
            1
        } else {
            mDatas.size
        }
    }

    /**
     * 没有数据返回0，有数据返回1
     */
    override fun getItemViewType(position: Int): Int {
        return if (mDatas.size <= 0) {
            0
        } else {
            1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LegalListViewHolder -> {
                // 普通的列表项
                val data = mDatas[position]

                when (data.pageCode) {
                    130, 129 -> {
                        // 许可处罚信息
                        // 协同监管措施
                        // 联合惩戒部门可能是多个
                        val departments = data.department
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
                            holder.label1.text = "联合惩戒部门"
                            holder.value1.text = departmentsStr.toString().trim()
                        }
                        holder.label2.text = "法律法规及政策依据"
                        holder.value2.text = data.name ?: ""

                        holder.layout3.visibility = View.VISIBLE
                        holder.label3.text = "惩罚措施"
                        holder.value3.text = data.penalties ?: ""
                    }
                    128 -> {
                        // 联合惩戒措施
                        val departments = data.department
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
                            holder.label1.text = "联合惩戒部门"
                            holder.value1.text = departmentsStr.toString().trim()
                        }
                        holder.label2.text = "惩罚措施"
                        holder.value2.text = data.penalties ?: ""

                        holder.layout3.visibility = View.VISIBLE
                        holder.label3.text = "惩戒事项"
                        holder.value3.text = data.name ?: ""
                    }
                    127 -> {
                        // 省级下放权限清单
                        holder.label1.text = "事项名称"
                        holder.value1.text = data.name ?: ""
                        val departments = data.department
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
                            holder.label2.text = "联合惩戒部门"
                            holder.value2.text = departmentsStr.toString().trim()
                        }
                        // 实施部门可能是多个
                        val dd = data.implementationDepartment
                        if (!dd.isNullOrEmpty()) {
                            val ddStrs = StringBuilder("")
                            dd.forEach { d ->
                                ddStrs.append(d.name.toString())
                                ddStrs.append(",")
                            }
                            if (ddStrs.length > 2) {
                                ddStrs.replace(ddStrs.length - 1, ddStrs.length, "")
                            }
                            holder.layout3.visibility = View.VISIBLE
                            holder.label3.text = "实施部门"
                            holder.value3.text = ddStrs.toString().trim()
                        }
                    }
                    133 -> {
                        // 企业登记
                        holder.label1.text = "提供信息事项"
                        holder.value1.text = data.name ?: ""
                        holder.label2.text = "法律法规及政策依据"
                        holder.value2.text = data.legalBasis ?: ""

                        holder.layout3.visibility = View.GONE
                    }
                    134 -> {
                        // 市场准入和任职
                        holder.label1.text = "联合惩罚领域"
                        holder.value1.text = data.name ?: ""
                        holder.label2.text = "信息提供部门和信息类型"
                        holder.value2.text = data.priviledge ?: ""

                        holder.layout3.visibility = View.VISIBLE
                        holder.label3.text = "限制方式"
                        holder.value3.text = data.penalties ?: ""
                    }
                    126 -> {
                        // 自贸区权限清单
                        val departments = data.department
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
                            holder.label1.text = "承建部门"
                            holder.value1.text = departmentsStr.toString().trim()
                        }
                        holder.label2.text = "事项名称"
                        holder.value2.text = data.name ?: ""
                        // 实施部门可能是多个
                        val dd = data.implementationDepartment
                        if (!dd.isNullOrEmpty()) {
                            val ddStrs = StringBuilder("")
                            dd.forEach { d ->
                                ddStrs.append(d.name.toString())
                                ddStrs.append(",")
                            }
                            if (ddStrs.length > 2) {
                                ddStrs.replace(ddStrs.length - 1, ddStrs.length, "")
                            }
                            holder.layout3.visibility = View.VISIBLE
                            holder.label3.text = "实施部门"
                            holder.value3.text = ddStrs.toString().trim()
                        }
                    }
                }

                holder.itemView.setOnClickListener {
                    // 跳转至详情页
                    mOnItemClickListener?.onItemClick(data)
                }
            }
            is NoDataViewHolder -> {
                // 没有数据的样子
                holder.itemView.visibility = if (mHasNotified) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }
        }
    }

    /**
     * 刷新全部数据
     */
    fun notifyDataChange(datas: ArrayList<LegalProvisionBean.DataBean>) {
        mDatas.clear()
        if (!datas.isNullOrEmpty()) {
            mDatas.addAll(datas)
        }
        mHasNotified = true
        notifyDataSetChanged()
    }

    class LegalListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label1 = itemView.find<TextView>(R.id.legal_1_label)
        val label2 = itemView.find<TextView>(R.id.legal_2_label)
        val label3 = itemView.find<TextView>(R.id.legal_3_label)

        val value1 = itemView.find<TextView>(R.id.legal_1_value)
        val value2 = itemView.find<TextView>(R.id.legal_2_value)
        val value3 = itemView.find<TextView>(R.id.legal_3_value)

        val layout1 = itemView.find<ViewGroup>(R.id.legal_1_layout)
        val layout2 = itemView.find<ViewGroup>(R.id.legal_2_layout)
        val layout3 = itemView.find<ViewGroup>(R.id.legal_3_layout)
    }
}