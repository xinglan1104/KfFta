package com.xl.kffta.adapter.task

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.TakeOrderBean
import com.xl.kffta.net.taskmanager.FilesNetManager
import com.xl.kffta.net.taskmanager.LocationManager
import com.xl.kffta.net.taskmanager.TaskNetManager
import com.xl.kffta.ui.activity.receivetask.TaskInfoDetailActivity
import com.xl.kffta.util.SysUtils
import com.xl.kffta.viewholder.NoDataViewHolder
import org.jetbrains.anko.find

/**
 * @author created by zhanghaochen
 * @date 2020-05-20 15:26
 * 描述：执行任务列表页的适配器
 */
class ExeTaskListAdapter(var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mDatas = ArrayList<TakeOrderBean.DataBean>()
    private var mHasNotified = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exe_list, parent, false)
        val noDataView = LayoutInflater.from(parent.context).inflate(R.layout.item_no_data, parent, false)
        return if (viewType == 0) {
            NoDataViewHolder(noDataView)
        } else {
            ExeTaskItemHolder(view)
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
            val dataBean = mDatas[position]
            val exeHolder = holder as ExeTaskItemHolder
            exeHolder.caseType.text = dataBean.business?.businessName ?: ""

            // 获取状态，记录是否执行完成
            val excutionStatus = dataBean.excutionStatus
            if (excutionStatus == TaskNetManager.TASK_EXCUTIONSTATUS_PENDING) {
                // 待执行任务
                exeHolder.exeState.text = "等待"
                exeHolder.exeGo.visibility = View.VISIBLE
                // 执法开始时间，执法结束时间
                exeHolder.startTimeLabel.text = "执法开始时间"
                exeHolder.startTime.text = SysUtils.getDateTimestamp(dataBean.startDate)
                exeHolder.endTime.text = SysUtils.getDateTimestamp(dataBean.endDate)
                exeHolder.endTime.visibility = View.VISIBLE
                exeHolder.endTimeLabel.visibility = View.VISIBLE
                exeHolder.itemView.setOnClickListener(null)

                exeHolder.exeGo.setOnClickListener {
                    val intent = Intent()
                    val activity = SysUtils.getActivity(context)
                    activity?.let { parentActivity ->
                        // 点击了开始执法，表示开始执法了，插入一条数据库
                        LocationManager.executeTaskInSql(dataBean.id, FilesNetManager.TASK_CODENAME, System.currentTimeMillis())

                        intent.setClass(parentActivity, TaskInfoDetailActivity::class.java)
                        intent.putExtra(TaskInfoDetailActivity.TASK_ID, dataBean.id)
                        intent.putExtra(TaskInfoDetailActivity.INFO_TYPE, TaskInfoDetailActivity.TYPE_EXECUTE_TASK)
                        intent.putExtra(TaskInfoDetailActivity.TASK_EXE_STATE, TaskInfoDetailActivity.TASK_EXE_STATE_PENDING)
                        intent.putExtra(TaskInfoDetailActivity.FILE_ONLY_SHOW, false)
                        parentActivity.startActivity(intent)
                    }
                }
            } else {
                // 已执行任务
                exeHolder.exeState.text = "完成"
                exeHolder.exeGo.visibility = View.GONE
                // 执法时间，另一个时间不展示
                exeHolder.startTimeLabel.text = "执法时间"
                exeHolder.startTime.text = SysUtils.getDateTimestamp(dataBean.excuteTime)
                exeHolder.endTime.visibility = View.GONE
                exeHolder.endTimeLabel.visibility = View.GONE
                exeHolder.itemView.setOnClickListener {
                    val intent = Intent()
                    val activity = SysUtils.getActivity(context)
                    activity?.let { parentActivity ->
                        intent.setClass(parentActivity, TaskInfoDetailActivity::class.java)
                        intent.putExtra(TaskInfoDetailActivity.TASK_ID, dataBean.id)
                        intent.putExtra(TaskInfoDetailActivity.INFO_TYPE, TaskInfoDetailActivity.TYPE_EXECUTE_TASK)
                        intent.putExtra(TaskInfoDetailActivity.TASK_EXE_STATE, TaskInfoDetailActivity.TASK_EXE_STATE_OVER)
                        intent.putExtra(TaskInfoDetailActivity.FILE_ONLY_SHOW, true)
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

    fun notifyDataChange(datas: ArrayList<TakeOrderBean.DataBean>) {
        mDatas.clear()
        if (!datas.isNullOrEmpty()) {
            mDatas.addAll(datas)
        }
        mHasNotified = true
        notifyDataSetChanged()
    }


    class ExeTaskItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val caseType = itemView.find<TextView>(R.id.exe_1_value)
        val startTime = itemView.find<TextView>(R.id.exe_2_value)
        val startTimeLabel = itemView.find<TextView>(R.id.exe_2_label)
        val endTime = itemView.find<TextView>(R.id.exe_3_value)
        val endTimeLabel = itemView.find<TextView>(R.id.exe_3_label)
        val exeState = itemView.find<TextView>(R.id.exe_4_value)
        val exeGo = itemView.find<TextView>(R.id.exe_item_go)
    }
}