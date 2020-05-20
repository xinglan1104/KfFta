package com.xl.kffta.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.TakeOrderBean
import com.xl.kffta.ui.activity.receivetask.TaskInfoDetailActivity
import com.xl.kffta.util.SysUtils
import org.jetbrains.anko.find

/**
 * @author created by zhanghaochen
 * @date 2020-05-20 15:26
 * 描述：执行任务列表页的适配器
 */
class ExeTaskListAdapter(var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mDatas = ArrayList<TakeOrderBean.DataBean>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ExeTaskItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_exe_list, parent, false))
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position < mDatas.size) {
            val dataBean = mDatas[position]
            val exeHolder = holder as ExeTaskItemHolder
            exeHolder.caseType.text = dataBean.govermentEnforcementScheme?.name ?: ""
            exeHolder.startTime.text = SysUtils.getDateTimestamp(dataBean.startDate)
            exeHolder.endTime.text = SysUtils.getDateTimestamp(dataBean.endDate)
            // todo 执法状态，应该是0表示等待，我猜的
            if (dataBean.excutionStatus == 0) {
                exeHolder.exeState.text = "等待"
                exeHolder.exeGo.visibility = View.VISIBLE
            } else {
                exeHolder.exeState.text = "完成"
                exeHolder.exeGo.visibility = View.GONE
            }

            exeHolder.exeGo.setOnClickListener {
                val intent = Intent()
                val activity = SysUtils.getActivity(context)
                activity?.let { parentActivity ->
                    intent.setClass(parentActivity, TaskInfoDetailActivity::class.java)
                    intent.putExtra(TaskInfoDetailActivity.TASK_ID, dataBean.id)
                    intent.putExtra(TaskInfoDetailActivity.INFO_TYPE, TaskInfoDetailActivity.TYPE_EXECUTE_TASK)
//                    intent.putExtra(TaskInfoDetailActivity.TASK_GET_STATE, getState)
                    parentActivity.startActivity(intent)
                }
            }

            holder.itemView.setOnClickListener {
                Log.d("zhc", "justclick")
            }
        }
    }

    fun notifyDataChange(datas: ArrayList<TakeOrderBean.DataBean>) {
        if (!datas.isNullOrEmpty()) {
            mDatas.clear()
            mDatas.addAll(datas)
            notifyDataSetChanged()
        } else {
            mDatas.clear()
            notifyDataSetChanged()
        }
    }


    class ExeTaskItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val caseType = itemView.find<TextView>(R.id.exe_1_value)
        val startTime = itemView.find<TextView>(R.id.exe_2_value)
        val endTime = itemView.find<TextView>(R.id.exe_3_value)
        val exeState = itemView.find<TextView>(R.id.exe_4_value)
        val exeGo = itemView.find<TextView>(R.id.exe_item_go)
    }
}