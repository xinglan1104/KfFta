package com.xl.kffta.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.TakeOrderBean
import com.xl.kffta.viewholder.TakeOderViewHolder

/**
 * @author zhanghaochen
 * date 2020-05-17
 * 描述：领取任务adapter
 */
class TakeOrderAdapter(var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mDatas = ArrayList<TakeOrderBean.DataBean>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_takeorder, parent, false)

        return TakeOderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holder = holder as TakeOderViewHolder
        holder.setData(mDatas[position])
    }

    fun notifyDataChange(takeOrderBean: TakeOrderBean) {
        if (!takeOrderBean.data.isNullOrEmpty()) {
            mDatas.clear()
            mDatas.addAll(takeOrderBean.data)
            notifyDataSetChanged()
        }
    }
}