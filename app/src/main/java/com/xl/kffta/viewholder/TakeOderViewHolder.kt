package com.xl.kffta.viewholder

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.TakeOrderBean

/**
 * @author zhanghaochen
 * date 2020-05-17
 * 描述：领取任务viewholder
 */
class TakeOderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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
    val takeOkBtn by lazy {
        itemView.findViewById<Button>(R.id.take_btn4)
    }
    val infoBtn2 by lazy {
        itemView.findViewById<Button>(R.id.take_btn5)
    }

    public fun setData(takeOrderBean: TakeOrderBean) {

    }
}