package com.xl.kffta.adapter.task

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.TakeOrderBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.TaskNetManager
import com.xl.kffta.ui.activity.receivetask.TaskInfoDetailActivity
import com.xl.kffta.util.ApplicationParams
import com.xl.kffta.util.DialogUtil
import com.xl.kffta.util.SysUtils
import com.xl.kffta.viewholder.NoDataViewHolder
import com.xl.kffta.viewholder.TakeOderViewHolder
import org.jetbrains.anko.runOnUiThread

/**
 * @author zhanghaochen
 * date 2020-05-17
 * 描述：领取任务adapter
 */
class TakeOrderAdapter(var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mDatas = ArrayList<TakeOrderBean.DataBean>()
    private var mHasNotified = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_takeorder, parent, false)
        val noDataView = LayoutInflater.from(parent.context).inflate(R.layout.item_no_data, parent, false)

        return if (viewType == 0) {
            NoDataViewHolder(noDataView)
        } else {
            TakeOderViewHolder(view)
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
            val takeOderViewHolder = holder as TakeOderViewHolder
            val dataBean = mDatas[position]
            dataBean?.let {
                takeOderViewHolder.setData(it)
                takeOderViewHolder.setHolderItemClickListener(object : TakeOderViewHolder.HolderItemClickListener {
                    override fun onTakeClick() {
                        // 领取任务
                        DialogUtil.showCommonDialog(context, "确认领取任务", object : DialogUtil.OnDialogOkClick {
                            override fun onDialogOkClick() {
                                TaskNetManager.getOrCancelTask(it.id.toString(), true, object : ResponseObjectCallback {
                                    override fun onError(msg: String) {
                                        context.runOnUiThread {
                                            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                                        }
                                    }

                                    override fun onSuccess(obj: Any) {
                                        context.runOnUiThread {
                                            // 最好的办法就是改变数据源，刷新自己
                                            Toast.makeText(context, "领取成功", Toast.LENGTH_SHORT).show()
                                            it.ownerIDs.add(ApplicationParams.USER_ID)
                                            notifyItemChanged(position)
                                        }
                                    }

                                })
                            }
                        })
                    }

                    override fun onBackClick() {
                        // 退回任务
                        DialogUtil.showCommonDialog(context, "确认退回任务", object : DialogUtil.OnDialogOkClick {
                            override fun onDialogOkClick() {
                                TaskNetManager.getOrCancelTask(it.id.toString(), false, object : ResponseObjectCallback {
                                    override fun onError(msg: String) {
                                        context.runOnUiThread {
                                            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                                        }
                                    }

                                    override fun onSuccess(obj: Any) {
                                        context.runOnUiThread {
                                            Toast.makeText(context, "退回成功", Toast.LENGTH_SHORT).show()
                                        }
                                    }

                                })
                            }
                        })
                    }

                    override fun onInfoClick(getState: Int) {
                        val intent = Intent()
                        val activity = SysUtils.getActivity(context)
                        activity?.let { parentActivity ->
                            intent.setClass(parentActivity, TaskInfoDetailActivity::class.java)
                            intent.putExtra(TaskInfoDetailActivity.TASK_ID, it.id)
                            intent.putExtra(TaskInfoDetailActivity.INFO_TYPE, TaskInfoDetailActivity.TYPE_RECEIVE_TASK)
                            intent.putExtra(TaskInfoDetailActivity.TASK_GET_STATE, getState)
                            parentActivity.startActivity(intent)
                        }
                    }

                })
            }
        } else if (getItemViewType(position) == 0) {
            holder.itemView.visibility = if (mHasNotified) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    fun notifyDataChange(takeOrderBean: TakeOrderBean) {
        if (!takeOrderBean.data.isNullOrEmpty()) {
            mDatas.clear()
            mDatas.addAll(takeOrderBean.data)
            notifyDataSetChanged()
        }
        mHasNotified = true
    }
}