package com.xl.kffta.ui.activity.receivetask

import android.os.Message
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.adapter.task.TakeOrderAdapter
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.TakeOrderBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.TaskNetManager
import com.xl.kffta.presenter.impl.TakeOrderPresenterImpl
import com.xl.kffta.util.DialogUtil
import com.xl.kffta.view.ITakeOrderView
import kotlinx.android.synthetic.main.activity_takeorder.*
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author zhanghaochen
 * date 2020-05-17
 * 描述：待领取任务的界面
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
        title_name.text = "待领取任务"
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
        mAdapter.setTakeOrRefuseSuccessListener(object : TakeOrderAdapter.TakeOrRefuseSuccessListener {
            override fun onTakeOrRefuseSuccess() {
                sendRequest()
            }

        })

        // todo 先禁用刷新功能
        take_refresh_layout.setEnableRefresh(false)
        take_refresh_layout.setEnableLoadMore(false)
    }

    override fun initListener() {
        title_take_all.setOnClickListener {
            DialogUtil.showCommonDialog(this@TakeOrderActivity, "确定要领取所有任务吗", object : DialogUtil.OnDialogOkClick {
                override fun onDialogOkClick() {
                    takeAllQuest()
                }

            })
        }
    }

    override fun initData() {

    }

    override fun onResume() {
        super.onResume()
        mPresenter?.bindView(this)
        sendRequest()
    }

    private fun sendRequest() {
        mPresenter?.queryTask("0", "0", "100")
        showProgress()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.unBindView()
    }

    /**
     * 领取全部任务
     */
    private fun takeAllQuest() {
        showProgress()
        TaskNetManager.getOrCancelTask("-1", true, object : ResponseObjectCallback {
            override fun onError(msg: String) {
                hideProgress()
                myToast("领取全部任务失败：$msg")
            }

            override fun onSuccess(obj: Any) {
                hideProgress()
                myToast("已领取全部任务")
                mHandler.postDelayed({ sendRequest() }, 200)
            }

        })
    }

    override fun refreshAllSuccess(takeOrderBean: TakeOrderBean) {
        hideProgress()
        runOnUiThread {
            mAdapter.notifyDataChange(takeOrderBean)
            // 如果有任务，显示一键领取按钮
            if (takeOrderBean.data?.size ?: 0 > 0) {
                title_take_all.visibility = View.VISIBLE
            } else {
                title_take_all.visibility = View.GONE
            }
        }
    }

    override fun refreshAllFail(msg: String) {
        hideProgress()
        myToast(msg)
    }

    override fun loadMoreSuccess(takeOrderBean: TakeOrderBean) {
        hideProgress()
    }

    override fun loadMoreFail(msg: String) {
        hideProgress()
        myToast(msg)
    }

}