package com.xl.kffta.adapter.jointtask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.JointTaskInfoItem
import com.xl.kffta.util.DialogUtil

/**
 * @author created by zhanghaochen
 * @date 2020-05-21 15:39
 * 描述：项目检查任务详情的适配器
 */
class JointTaskInfoAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mDatas = ArrayList<JointTaskInfoItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_jointtast_info, parent, false)

        return JointTaskInfoNormalHolder(view)
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position < mDatas.size) {
            val jointTaskInfoItem = mDatas[position]
            val jointNormalHolder = holder as JointTaskInfoNormalHolder

            jointNormalHolder.label.text = jointTaskInfoItem.label
            jointNormalHolder.value.text = jointTaskInfoItem.value

            // 根据是否可点击给予不同颜色
            // 如果是事件清单，还是需要特殊处理
            if (jointTaskInfoItem.isClickable) {
                jointNormalHolder.value.setTextColor(context.resources.getColorStateList(R.color.btn_common_color))
                jointNormalHolder.value.setOnClickListener {
                    // 点击了,搞个弹窗
                    DialogUtil.showJointRiskDialog(context, jointTaskInfoItem.checkStateName, jointTaskInfoItem.deparmentName, jointTaskInfoItem.riskInfo)
                }
            } else {
                jointNormalHolder.value.setTextColor(context.resources.getColorStateList(R.color.text_value))
                jointNormalHolder.value.setOnClickListener(null)
            }
        }
    }

    fun notifyDataChange(jointTaskItem: ArrayList<JointTaskInfoItem>) {
        if (!jointTaskItem.isNullOrEmpty()) {
            mDatas.clear()
            mDatas.addAll(jointTaskItem)
            notifyDataSetChanged()
        }
    }

    /**
     * 普通的条目holder
     */
    class JointTaskInfoNormalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label = itemView.findViewById<TextView>(R.id.joint_info_label)
        val value = itemView.findViewById<TextView>(R.id.joint_info_value)
    }

    class JointTaskInfoTitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
