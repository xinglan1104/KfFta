package com.xl.kffta.adapter.jointtask

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.JointTaskBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.JointTaskManager
import com.xl.kffta.ui.activity.receivejointtask.JointTaskInfoActivity
import com.xl.kffta.util.DialogUtil
import com.xl.kffta.util.SysUtils
import com.xl.kffta.viewholder.NoDataViewHolder
import org.jetbrains.anko.find
import org.jetbrains.anko.runOnUiThread

/**
 * @author created by zhanghaochen
 * @date 2020-05-21 10:46
 * 描述：领取项目检查任务的列表
 */
class JointTaskListAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val TASK_HAS_TAKE = 1
        const val TASK_HAS_NOT_TAKE = 2
    }

    val mDatas = ArrayList<JointTaskBean.DataBean>()
    var mHasNotified = false
    var mJointTaskAcceptOrRefuseSuccessListener: OnJointTaskAcceptOrRefuseSuccessListener? = null

    interface OnJointTaskAcceptOrRefuseSuccessListener {
        fun onJointTaskAcceptOrRefuseSuccess()
    }

    fun setOnJointTaskAcceptOrRefuseSuccessListener(listener: OnJointTaskAcceptOrRefuseSuccessListener) {
        this.mJointTaskAcceptOrRefuseSuccessListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_joint_task, parent, false)
        val noDataView = LayoutInflater.from(parent.context).inflate(R.layout.item_no_data, parent, false)

        return if (viewType == 0) {
            NoDataViewHolder(noDataView)
        } else {
            JointTaskItemHolder(view)
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
            val jointBean = mDatas[position]
            val jointHolder = holder as JointTaskItemHolder

            jointHolder.value1.text = jointBean.govermentJointSupervisionScheme?.name ?: ""
            jointHolder.value2.text = SysUtils.getDateTimestamp(jointBean.checkDate)
//            jointHolder.value3.text = SysUtils.getDateTimestamp(jointBean.checkDate)

            val takeState = if (jointBean.acceptStatus == JointTaskManager.AcceptStatusApproved) {
                TASK_HAS_TAKE
            } else {
                TASK_HAS_NOT_TAKE
            }
            when (takeState) {
                TASK_HAS_TAKE -> {
                    jointHolder.btn1.text = "已领取"
                    jointHolder.btn1.isEnabled = false
                    jointHolder.emptyView.visibility = View.GONE
                    jointHolder.btn2.visibility = View.GONE
                }
                TASK_HAS_NOT_TAKE -> {
                    jointHolder.btn1.text = "领取"
                    jointHolder.btn1.isEnabled = true
                    jointHolder.emptyView.visibility = View.VISIBLE
                    jointHolder.btn2.visibility = View.VISIBLE
                }
            }

            jointHolder.btn1.setOnClickListener {
                DialogUtil.showCommonDialog(context, "确认领取检查任务", object : DialogUtil.OnDialogOkClick {
                    override fun onDialogOkClick() {
                        JointTaskManager.getOrCancelJointTask(jointBean.id.toString(), true, object : ResponseObjectCallback {
                            override fun onError(msg: String) {
                                context.runOnUiThread {
                                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                                }
                            }

                            override fun onSuccess(obj: Any) {
                                // 最好的办法就是改变数据源，刷新自己
                                context.runOnUiThread {
                                    Toast.makeText(context, "领取成功", Toast.LENGTH_SHORT).show()
                                    jointBean.acceptStatus = JointTaskManager.AcceptStatusApproved
                                    notifyItemChanged(position)

                                    // 成功了，需要通知主界面刷新
                                    mJointTaskAcceptOrRefuseSuccessListener?.onJointTaskAcceptOrRefuseSuccess()
                                }
                            }

                        })
                    }
                })
            }
            jointHolder.btn2.setOnClickListener {
                DialogUtil.showCommonDialog(context, "确认退回检查任务", object : DialogUtil.OnDialogOkClick {
                    override fun onDialogOkClick() {
                        JointTaskManager.getOrCancelJointTask(jointBean.id.toString(), false, object : ResponseObjectCallback {
                            override fun onError(msg: String) {
                                context.runOnUiThread {
                                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                                }
                            }

                            override fun onSuccess(obj: Any) {
                                context.runOnUiThread {
                                    Toast.makeText(context, "退回成功", Toast.LENGTH_SHORT).show()
                                    // 成功了，需要通知主界面刷新
                                    mJointTaskAcceptOrRefuseSuccessListener?.onJointTaskAcceptOrRefuseSuccess()
                                }
                            }

                        })
                    }

                })
            }
            jointHolder.itemView.setOnClickListener {
                // 跳转到详情
                val intent = Intent()
                val activity = SysUtils.getActivity(context)
                activity?.let { parentActivity ->
                    intent.setClass(parentActivity, JointTaskInfoActivity::class.java)
                    intent.putExtra(JointTaskInfoActivity.JOINT_TASK_ID, jointBean.id)
                    intent.putExtra(JointTaskInfoActivity.JOINT_TASK_TYPE, JointTaskInfoActivity.JOINT_TASK_TYPE_RECEIVE)
                    intent.putExtra(JointTaskInfoActivity.JOINT_TASK_STATE, takeState)
                    parentActivity.startActivity(intent)
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

    class JointTaskItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val value1 = itemView.find<TextView>(R.id.take_1_value)
        val value2 = itemView.find<TextView>(R.id.take_2_value)
        val value3 = itemView.find<TextView>(R.id.take_3_value)

        val btn1 = itemView.find<TextView>(R.id.take_btn1)
        val btn2 = itemView.find<TextView>(R.id.take_btn2)
        val btn3 = itemView.find<TextView>(R.id.take_btn3)

        val emptyView = itemView.find<View>(R.id.take_empty_1)
    }
}
