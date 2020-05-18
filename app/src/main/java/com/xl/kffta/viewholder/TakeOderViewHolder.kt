package com.xl.kffta.viewholder

import android.view.View
import android.widget.Button
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
    companion object {
        const val GET_TASK_OK = 1
        const val GET_TASK_HAVE_NOT = 2
    }

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
        itemView.findViewById<Button>(R.id.take_btn1)
    }
    val backBtn by lazy {
        itemView.findViewById<Button>(R.id.take_btn2)
    }
    val infoBtn by lazy {
        itemView.findViewById<Button>(R.id.take_btn3)
    }

    public fun setData(takeOrderBean: TakeOrderBean.DataBean) {
        caseType.text = SysUtils.getSafeString(takeOrderBean.govermentEnforcementScheme?.name)
        startTime.text = SysUtils.getSafeString(takeOrderBean.startDate)
        endTime.text = SysUtils.getSafeString(takeOrderBean.endDate)

        // pendingOwnerId包含用户id，说明领取过了
        val takeState = if (takeOrderBean.pendingOwnerIDs.contains(ApplicationParams.USER_ID)) {
            GET_TASK_OK
        } else {
            GET_TASK_HAVE_NOT
        }
        when (takeState) {
            GET_TASK_OK -> {
                takeBtn.text = "已领取"
            }
            GET_TASK_HAVE_NOT -> {
                takeBtn.text = "领取"
            }
        }
    }
}