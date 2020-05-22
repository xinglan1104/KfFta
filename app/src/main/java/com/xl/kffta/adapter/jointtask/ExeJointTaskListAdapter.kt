package com.xl.kffta.adapter.jointtask

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.JointTaskBean
import com.xl.kffta.net.taskmanager.JointTaskManager
import com.xl.kffta.ui.activity.receivejointtask.JointTaskInfoActivity
import com.xl.kffta.util.SysUtils
import org.jetbrains.anko.find

/**
 * @author created by zhanghaochen
 * @date 2020-05-22 13:55
 * 描述：可执行项目检查任务的列表
 */
class ExeJointTaskListAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val mDatas = ArrayList<JointTaskBean.DataBean>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exe_joint_holder, parent, false)

        return ExeJointTaskItemHolder(view)
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position < mDatas.size) {
            val data = mDatas[position]
            holder as ExeJointTaskItemHolder

            holder.value1.text = data.govermentJointSupervisionScheme?.name ?: ""
            holder.value2.text = SysUtils.getDateTimestamp(data.checkDate)
            holder.value3.text = data.result ?: ""
            holder.value4.text = if (data.acceptStatus == JointTaskManager.AcceptStatusApproved) {
                "通过"
            } else {
                "等待"
            }
            holder.value5.text = if (data.excutionStatus == JointTaskManager.ExcutionStatus_Complete) {
                "完成"
            } else {
                "等待"
            }

            holder.btn1.setOnClickListener {
                // 跳转到执行项目检查任务的详情页
                val intent = Intent()
                val activity = SysUtils.getActivity(context)
                activity?.let { parentActivity ->
                    intent.setClass(parentActivity, JointTaskInfoActivity::class.java)
                    intent.putExtra(JointTaskInfoActivity.JOINT_TASK_ID, data.id)
                    intent.putExtra(JointTaskInfoActivity.JOINT_TASK_TYPE, JointTaskInfoActivity.JOINT_TASK_TYPE_EXECUTE)
                    parentActivity.startActivity(intent)
                }
            }
        }
    }

    /**
     * 刷新全部数据
     */
    fun notifyDataChange(datas: ArrayList<JointTaskBean.DataBean>) {
        if (!datas.isNullOrEmpty()) {
            mDatas.clear()
            mDatas.addAll(datas)
            notifyDataSetChanged()
        } else {
            // 带搜索的，搜出来没有就是没有
            mDatas.clear()
            notifyDataSetChanged()
        }
    }

    fun notifyDataChangeLoadingMore(datas: ArrayList<JointTaskBean.DataBean>) {
        if (!datas.isNullOrEmpty()) {
            mDatas.addAll(datas)
            notifyDataSetChanged()
        }
    }


    class ExeJointTaskItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val value1 = itemView.find<TextView>(R.id.exe_joint_1_value)
        val value2 = itemView.find<TextView>(R.id.exe_joint_2_value)
        val value3 = itemView.find<TextView>(R.id.exe_joint_3_value)
        val value4 = itemView.find<TextView>(R.id.exe_joint_4_value)
        val value5 = itemView.find<TextView>(R.id.exe_joint_5_value)
        val btn1 = itemView.find<TextView>(R.id.exe_joint_btn1)
    }
}
