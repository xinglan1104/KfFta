package com.xl.kffta.adapter.lawcase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.lawcase.LawCaseItemBean
import org.jetbrains.anko.find

/**
 * @author zhanghaochen
 * Date: 2020/5/31
 * 描述：案件二级页面的adapter
 */
class LawCaseDetailAdapter(val context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val ITEM_NORMAL = 10
        private const val ITEM_TITLE = 11
        private const val ITEM_EDITABLE = 12
    }

    val mDatas = ArrayList<LawCaseItemBean>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            ITEM_TITLE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_only_title, parent, false)
                return CaseDetailTitleHolder(view)
            }
            ITEM_EDITABLE -> {
                val editViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_with_edit, parent, false)
                return CaseDetailEditHolder(editViewHolder)
            }
            else -> {
                val normalView = LayoutInflater.from(parent.context).inflate(R.layout.item_taskinfo_detail, parent, false)
                return CaseDetailNormalHolder(normalView)
            }
        }
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        val caseItem = mDatas[position]
        if (caseItem.isTitle) {
            return ITEM_TITLE
        } else if (caseItem.isEditable) {
            return ITEM_EDITABLE
        } else {
            return ITEM_NORMAL
        }
    }

    /**
     * 普通的条目holder
     */
    class CaseDetailNormalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label = itemView.findViewById<TextView>(R.id.info_detail_label)
        val value = itemView.findViewById<TextView>(R.id.info_detail_value)
    }

    class CaseDetailTitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    /**
     * 编辑框的holder
     */
    class CaseDetailEditHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label = itemView.find<TextView>(R.id.info_detail_et_label)
        val edit = itemView.find<EditText>(R.id.info_detail_et)
    }
}