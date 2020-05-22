package com.xl.kffta.adapter.task

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.TaskItemInfo
import com.xl.kffta.ui.activity.receivetask.CheckListActivity
import com.xl.kffta.util.SysUtils

/**
 * @author zhanghaochen
 * Date: 2020/5/19
 * 描述：任务详情页的适配器
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
                            // 点击了事件清单，跳转至事件清单
                            val activity = SysUtils.getActivity(context)
                            activity?.apply {
                                val intent = Intent(this, CheckListActivity::class.java)
                                intent.putExtra(CheckListActivity.CHECKLIST_ID, taskItemInfo.checkListId)
                                startActivity(intent)
                            }
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