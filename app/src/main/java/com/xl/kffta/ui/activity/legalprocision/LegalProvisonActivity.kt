package com.xl.kffta.ui.activity.legalprocision

import android.content.Context
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import kotlinx.android.synthetic.main.activity_takeorder.*
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author created by zhanghaochen
 * @date 2020-06-01 16:16
 * 描述：法律条文主界面
 */
class LegalProvisonActivity : BaseActivity() {
    private val mAdapter by lazy {
        MyAdapter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_takeorder
    }

    override fun handleMessage(message: Message) {

    }

    override fun initViews() {
        title_name.text = "法律条文"
        title_left.setOnClickListener {
            finish()
        }
    }

    override fun initListener() {
        take_recycler.layoutManager = object : LinearLayoutManager(this) {
            override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
                try {
                    super.onLayoutChildren(recycler, state)
                } catch (e: Exception) {
                }
            }
        }
        take_recycler.adapter = mAdapter

        take_refresh_layout.setEnableRefresh(false)
        take_refresh_layout.setEnableLoadMore(false)
    }

    override fun initData() {
        val legals = ArrayList<LegalSimpleBean>()
        legals.add(LegalSimpleBean("协同监管措施", 130))
        legals.add(LegalSimpleBean("许可处罚信息", 129))
        legals.add(LegalSimpleBean("联合惩戒措施", 128))
        legals.add(LegalSimpleBean("省级下放权限清单", 127))
        legals.add(LegalSimpleBean("企业登记", 133))
        legals.add(LegalSimpleBean("市场准入和任职", 134))
        legals.add(LegalSimpleBean("自贸区权限清单", 126))
        mAdapter?.notifyData(legals)
    }

    /**
     * 自定义的适配器
     */
    private class MyAdapter(val context: Context) : RecyclerView.Adapter<MyHolder>() {
        val datas = ArrayList<LegalSimpleBean>()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_legal_main, parent, false)
            return MyHolder(view)
        }

        override fun getItemCount(): Int {
            return datas.size
        }

        override fun onBindViewHolder(holder: MyHolder, position: Int) {
            val legalBean = datas[position]

            holder.textView.text = legalBean.name
            holder.itemView.setOnClickListener {
                // 跳转到法律详情
            }
        }

        fun notifyData(data: ArrayList<LegalSimpleBean>) {
            datas.clear()
            datas.addAll(data)
            notifyDataSetChanged()
        }

    }

    private class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.lp_name)
    }

    private data class LegalSimpleBean(var name: String, var pageCode: Int)
}
