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
                holder.value1.text = data.name ?: ""
                holder.value2.text = data.penalties ?: ""
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
                    holder.value3.text = departmentsStr.toString().trim()
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
        val value1 = itemView.find<TextView>(R.id.legal_1_value)
        val value2 = itemView.find<TextView>(R.id.legal_2_value)
        val value3 = itemView.find<TextView>(R.id.legal_3_value)
    }
}