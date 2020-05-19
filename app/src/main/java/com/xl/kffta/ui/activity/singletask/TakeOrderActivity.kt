package com.xl.kffta.ui.activity.singletask

import android.os.Message
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.adapter.TakeOrderAdapter
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.TakeOrderBean
import com.xl.kffta.presenter.impl.TakeOrderPresenterImpl
import com.xl.kffta.view.ITakeOrderView
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author zhanghaochen
 * date 2020-05-17
 * 描述：领取任务的界面
 */
class TakeOrderActivity : BaseActivity(), ITakeOrderView {
    var mPresenter: TakeOrderPresenterImpl? = TakeOrderPresenterImpl()

    val mRecycler by lazy {
        findViewById<RecyclerView>(R.id.take_recycler)
    }

    val mAdapter by lazy {
        TakeOrderAdapter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_takeorder
    }

    override fun handleMessage(message: Message) {

    }

    override fun initViews() {
        // 设置标题名字
        title_name.text = "领取任务"
        title_left.setOnClickListener {
            finish()
        }
        val layoutManager = object : LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
                try {
                    super.onLayoutChildren(recycler, state)
                } catch (e: Exception) {

                }
            }
        }
        mRecycler.layoutManager = layoutManager
        mRecycler.adapter = mAdapter
    }

    override fun initData() {
        mPresenter?.queryTask("0", "0", "30")
    }

    override fun onResume() {
        super.onResume()
        mPresenter?.bindView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.unBindView()
    }

    override fun refreshAllSuccess(takeOrderBean: TakeOrderBean) {
        runOnUiThread {
            mAdapter.notifyDataChange(takeOrderBean)
        }
    }

    override fun refreshAllFail(msg: String) {

    }

    override fun loadMoreSuccess(takeOrderBean: TakeOrderBean) {

    }

    override fun loadMoreFail(msg: String) {

    }

}