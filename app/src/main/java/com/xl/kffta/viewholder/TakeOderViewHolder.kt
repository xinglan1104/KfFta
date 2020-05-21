package com.xl.kffta.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.TakeOrderBean
import com.xl.kffta.util.ApplicationParams
import com.xl.kffta.util.SysUtils

/**
 * @author zhanghaochen
 * date 2020-05-17
 * 描述：领取任务viewholder
 */
class TakeOderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val GET_TASK_OK = 1
    private val GET_TASK_HAVE_NOT = 2

    interface HolderItemClickListener {
        fun onTakeClick()
        fun onBackClick()
        fun onInfoClick(getState: Int)
    }

    var mHolderItemClickListener: HolderItemClickListener? = null

    val caseType by lazy {
        itemView.findViewById<TextView>(R.id.take_1_value)
    }
    val startTime by lazy {
        itemView.findViewById<TextView>(R.id.take_2_value)
    }
    val endTime by lazy {
        itemView.findViewById<TextView>(R.id.take_3_value)
    }
    val takeBtn by lazy {
        itemView.findViewById<TextView>(R.id.take_btn1)
    }
    val backBtn by lazy {
        itemView.findViewById<TextView>(R.id.take_btn2)
    }
    val infoBtn by lazy {
        itemView.findViewById<TextView>(R.id.take_btn3)
    }
    val emptyView by lazy {
        itemView.findViewById<View>(R.id.take_empty_1)
    }

    /**
     * 设置点击事件
     */
    fun setHolderItemClickListener(holderItemClickListener: HolderItemClickListener) {
        this.mHolderItemClickListener = holderItemClickListener
    }

    fun setData(takeOrderBean: TakeOrderBean.DataBean) {
        caseType.text = SysUtils.getSafeString(takeOrderBean.govermentEnforcementScheme?.name)
        startTime.text = SysUtils.getDateTimestamp(takeOrderBean.startDate)
        endTime.text = SysUtils.getDateTimestamp(takeOrderBean.endDate)


        // owenerids包含用户id，说明领取过了
        val takeState = if (takeOrderBean.ownerIDs.contains(ApplicationParams.USER_ID)) {
            GET_TASK_OK
        } else {
            GET_TASK_HAVE_NOT
        }
        when (takeState) {
            GET_TASK_OK -> {
                takeBtn.text = "已领取"
                takeBtn.isEnabled = false
                emptyView.visibility = View.GONE
                backBtn.visibility = View.GONE
            }
            GET_TASK_HAVE_NOT -> {
                takeBtn.text = "领取"
                takeBtn.isEnabled = true
                emptyView.visibility = View.VISIBLE
                backBtn.visibility = View.VISIBLE
            }
        }
        takeBtn.setOnClickListener {
            mHolderItemClickListener?.onTakeClick()
        }
        backBtn.setOnClickListener {
            mHolderItemClickListener?.onBackClick()
        }
        infoBtn.setOnClickListener {
            mHolderItemClickListener?.onInfoClick(takeState)
        }
    }
}