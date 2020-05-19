package com.xl.kffta.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.TaskItemInfo

/**
 * @author zhanghaochen
 * Date: 2020/5/19
 * 描述：
 */
class TaskInfoDetailAdapter(var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private val ITEM_NORMAL = 1
        private val ITEM_TITLE = 2
    }

    val mDatas = ArrayList<TaskItemInfo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ITEM_NORMAL) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_taskinfo_detail, parent, false)
            TaskInfoDetailNormalHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_only_title, parent, false)
            TaskInfoDetailTitleHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val taskItemInfo = mDatas[position]
        taskItemInfo?.let {
            when (holder) {
                is TaskInfoDetailTitleHolder -> {

                }
                is TaskInfoDetailNormalHolder -> {
                    holder.label.text = it.label
                    holder.value.text = it.value
                    // 如果是事件清单，还是需要特殊处理
                    if (it.isCheckList) {
                        holder.value.setTextColor(context.resources.getColorStateList(R.color.btn_common_color))
                        holder.value.setOnClickListener {
                            Toast.makeText(context, taskItemInfo.checkListId.toString(), Toast.LENGTH_LONG).show()
                        }
                    } else {
                        holder.value.setTextColor(context.resources.getColorStateList(R.color.text_value))
                        holder.value.setOnClickListener(null)
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val taskItemInfo = mDatas[position]
        return if (taskItemInfo.isTitle) {
            ITEM_TITLE
        } else {
            ITEM_NORMAL
        }
    }

    fun notifyDataChange(taskItemInfos: ArrayList<TaskItemInfo>) {
        if (!taskItemInfos.isNullOrEmpty()) {
            mDatas.clear()
            mDatas.addAll(taskItemInfos)
            notifyDataSetChanged()
        }
    }

    /**
     * 普通的条目holder
     */
    class TaskInfoDetailNormalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label = itemView.findViewById<TextView>(R.id.info_detail_label)
        val value = itemView.findViewById<TextView>(R.id.info_detail_value)
    }

    class TaskInfoDetailTitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}
}