package com.xl.kffta.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.JointTaskBean
import com.xl.kffta.util.SysUtils
import org.jetbrains.anko.find

/**
 * @author created by zhanghaochen
 * @date 2020-05-21 10:46
 * 描述：领取项目检查任务的列表
 */
class JointTaskListAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val TASK_HAS_TAKE = 1
    val TASK_HAS_NOT_TAKE = 2
    val mDatas = ArrayList<JointTaskBean.DataBean>()

    interface HolderItemClickListener {
        fun onTakeClick()
        fun onBackClick()
        fun onInfoClick(getState: Int)
    }

    private var mHolderItemClickListener: HolderItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_joint_task, parent, false)

        return JointTaskItemHolder(view)
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position < mDatas.size) {
            val jointBean = mDatas[position]
            val jointHolder = holder as JointTaskItemHolder

            jointHolder.value1.text = jointBean.govermentJointSupervisionScheme?.name ?: ""
            jointHolder.value2.text = SysUtils.getDateTimestamp(jointBean.createTime)
            jointHolder.value3.text = SysUtils.getDateTimestamp(jointBean.checkDate)

            // AcceptStatus判断是否领取，Approved = 3，pending = 1
            val takeState = if (jointBean.acceptStatus == 3) {
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
                mHolderItemClickListener?.onTakeClick()
            }
            jointHolder.btn2.setOnClickListener {
                mHolderItemClickListener?.onBackClick()
            }
            jointHolder.btn3.setOnClickListener {
                mHolderItemClickListener?.onInfoClick(takeState)
            }
        }
    }

    /**
     * 设置点击事件
     */
    fun setHolderItemClickListener(holderItemClickListener: HolderItemClickListener) {
        this.mHolderItemClickListener = holderItemClickListener
    }

    /**
     * 刷新全部数据
     */
    fun notifyDataChange(datas: ArrayList<JointTaskBean.DataBean>) {
        if (!datas.isNullOrEmpty()) {
            mDatas.clear()
            mDatas.addAll(datas)
            notifyDataSetChanged()
        }
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
