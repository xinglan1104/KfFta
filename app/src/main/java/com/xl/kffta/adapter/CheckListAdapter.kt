package com.xl.kffta.adapter

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.CheckListItemBean
import org.jetbrains.anko.find

/**
 * @author created by zhanghaochen
 * @date 2020-05-20 12:33
 * 描述：
 */
class CheckListAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private val ITEM_NORMAL = 1
        private val ITEM_TITLE = 2
    }

    private var mItemDatas = ArrayList<CheckListItemBean>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ITEM_NORMAL) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_taskinfo_detail, parent, false)
            CheckListNormalHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_only_title, parent, false)
            CheckListTitleHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return mItemDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val checkItem = mItemDatas[position]
        when (holder) {
            is CheckListTitleHolder -> {
                holder.title.text = checkItem.title
                holder.title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16F)
            }
            is CheckListNormalHolder -> {
                holder.label.text = checkItem.label
                holder.value.text = checkItem.value
                // 判断是否可点击
                if (checkItem.isClickable) {
                    holder.value.setTextColor(context.resources.getColorStateList(R.color.btn_common_color))
                    holder.value.setOnClickListener {
                        // 点击了,弹dialog

                    }
                } else {
                    holder.value.setTextColor(context.resources.getColorStateList(R.color.text_value))
                    holder.value.setOnClickListener(null)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val checkItem = mItemDatas[position]
        return if (checkItem.isTitle) {
            ITEM_TITLE
        } else {
            ITEM_NORMAL
        }
    }

    fun notifyDataChange(checkListItems: ArrayList<CheckListItemBean>) {
        if (!checkListItems.isNullOrEmpty()) {
            mItemDatas.clear()
            mItemDatas.addAll(checkListItems)
            notifyDataSetChanged()
        }
    }

    class CheckListNormalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label = itemView.findViewById<TextView>(R.id.info_detail_label)
        val value = itemView.findViewById<TextView>(R.id.info_detail_value)
    }

    class CheckListTitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.find<TextView>(R.id.item_title)
    }
}