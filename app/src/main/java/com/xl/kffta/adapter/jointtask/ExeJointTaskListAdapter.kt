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
import com.xl.kffta.net.taskmanager.FilesNetManager
import com.xl.kffta.net.taskmanager.JointTaskManager
import com.xl.kffta.net.taskmanager.LocationManager
import com.xl.kffta.ui.activity.receivejointtask.JointTaskInfoActivity
import com.xl.kffta.util.SysUtils
import com.xl.kffta.viewholder.NoDataViewHolder
import org.jetbrains.anko.find

/**
 * @author created by zhanghaochen
 * @date 2020-05-22 13:55
 * 描述：可执行或已执行项目检查任务的列表
 */
class ExeJointTaskListAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mHasNotified = false
    val mDatas = ArrayList<JointTaskBean.DataBean>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exe_joint_holder, parent, false)
        val noDataView = LayoutInflater.from(parent.context).inflate(R.layout.item_no_data, parent, false)
        return if (viewType == 0) {
            NoDataViewHolder(noDataView)
        } else {
            ExeJointTaskItemHolder(view)
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
        if (position < mDatas.size && getItemViewType(position) == 1) {
            val data = mDatas[position]
            holder as ExeJointTaskItemHolder

            holder.value1.text = data.govermentJointSupervisionScheme?.name ?: ""
            holder.value3.text = data.result ?: ""
            holder.value4.text = if (data.acceptStatus == JointTaskManager.AcceptStatusApproved) {
                "通过"
            } else {
                "等待"
            }

            // 看看是否已完成
            val executeState = data.excutionStatus
            if (executeState == JointTaskManager.ExcutionStatus_Complete) {
                holder.value5.text = "完成"
                holder.value2.text = "执行时间"
                holder.value2.text = SysUtils.getDateTimestamp(data.checkDate)
                holder.btn1.visibility = View.GONE
                holder.layout3.visibility = View.GONE
                holder.layout4.visibility = View.GONE
                holder.layout5.visibility = View.GONE
                holder.itemView.setOnClickListener {
                    // 跳转到执行项目检查任务的详情页
                    val intent = Intent()
                    val activity = SysUtils.getActivity(context)
                    activity?.let { parentActivity ->
                        intent.setClass(parentActivity, JointTaskInfoActivity::class.java)
                        intent.putExtra(JointTaskInfoActivity.JOINT_TASK_ID, data.id)
                        intent.putExtra(JointTaskInfoActivity.JOINT_TASK_TYPE, JointTaskInfoActivity.JOINT_TASK_TYPE_EXECUTE)
                        intent.putExtra(JointTaskInfoActivity.JOINT_TASK_EXE_STATE, JointTaskInfoActivity.JOINT_TASK_EXE_STATE_COMPLETE)
                        intent.putExtra(JointTaskInfoActivity.FILE_ONLY_SHOW, true)
                        parentActivity.startActivity(intent)
                    }
                }
                holder.btn1.setOnClickListener(null)
            } else {
                holder.value5.text = "等待"
                holder.value2.text = "检查时间"
                holder.value2.text = SysUtils.getDateTimestamp(data.checkDate)
                holder.btn1.visibility = View.VISIBLE
                holder.layout3.visibility = View.VISIBLE
                holder.layout4.visibility = View.VISIBLE
                holder.layout5.visibility = View.VISIBLE
                holder.itemView.setOnClickListener(null)
                holder.btn1.setOnClickListener {
                    // 跳转到执行项目检查任务的详情页
                    val intent = Intent()
                    val activity = SysUtils.getActivity(context)
                    activity?.let { parentActivity ->
                        // 点击了开始执法，表示开始执法了，插入一条数据库
                        LocationManager.executeTaskInSql(data.id.toLong(), 0, FilesNetManager.JOINT_TASK_CODENAME, System.currentTimeMillis())

                        intent.setClass(parentActivity, JointTaskInfoActivity::class.java)
                        intent.putExtra(JointTaskInfoActivity.JOINT_TASK_ID, data.id)
                        intent.putExtra(JointTaskInfoActivity.JOINT_TASK_TYPE, JointTaskInfoActivity.JOINT_TASK_TYPE_EXECUTE)
                        intent.putExtra(JointTaskInfoActivity.JOINT_TASK_EXE_STATE, JointTaskInfoActivity.JOINT_TASK_EXE_STATE_PENDING)
                        intent.putExtra(JointTaskInfoActivity.FILE_ONLY_SHOW, false)
                        parentActivity.startActivity(intent)
                    }
                }
            }
        } else if (getItemViewType(position) == 0) {
            holder.itemView.visibility = if (mHasNotified) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    /**
     * 刷新全部数据
     */
    fun notifyDataChange(datas: ArrayList<JointTaskBean.DataBean>) {
        mDatas.clear()
        if (!datas.isNullOrEmpty()) {
            mDatas.addAll(datas)
        }
        mHasNotified = true
        notifyDataSetChanged()
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

        val layout3 = itemView.find<ViewGroup>(R.id.exe_joint_layout_3)
        val layout4 = itemView.find<ViewGroup>(R.id.exe_joint_layout_4)
        val layout5 = itemView.find<ViewGroup>(R.id.exe_joint_layout_5)
        val btn1 = itemView.find<TextView>(R.id.exe_joint_btn1)
    }
}
