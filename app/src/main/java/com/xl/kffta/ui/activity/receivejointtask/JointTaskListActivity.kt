package com.xl.kffta.ui.activity.receivejointtask

import android.os.Message
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.adapter.jointtask.JointTaskListAdapter
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.JointTaskBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.JointTaskManager
import kotlinx.android.synthetic.main.activity_takeorder.*
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author created by zhanghaochen
 * @date 2020-05-21 10:32
 * 描述：领取项目检查任务
 */
class JointTaskListActivity : BaseActivity() {

    private val mAdapter by lazy {
        JointTaskListAdapter(this)
    }

    private var mPageIndex = 0
    private var mPageSize = 50

    private val HANDLER_REFRESH = 0x401

    override fun getLayoutId(): Int {
        // 直接套用领取任务的布局
        return R.layout.activity_takeorder
    }

    override fun handleMessage(message: Message) {
        when (message.what) {
            HANDLER_REFRESH -> {
                val data = message.obj
                if (data is JointTaskBean) {
                    mAdapter.notifyDataChange(data.data)
                }
            }
        }
    }

    override fun initViews() {
        title_left.setOnClickListener {
            finish()
        }
        title_name.text = "领取项目检查任务"
    }

    override fun initListener() {
        take_recycler.layoutManager = object : LinearLayoutManager(this) {
            override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
                try {
                    super.onLayoutChildren(recycler, state)
                } catch (ignored: Exception) {
                }
            }
        }

        take_recycler.adapter = mAdapter

        // todo 先禁用刷新功能
        take_refresh_layout.setEnableRefresh(false)
        take_refresh_layout.setEnableLoadMore(false)
    }

    override fun onResume() {
        super.onResume()
        sendRequest()
    }

    private fun sendRequest() {
        JointTaskManager.queryAllJointTask(mPageIndex, mPageSize, object : ResponseObjectCallback {
            override fun onError(msg: String) {
                myToast(msg)
            }

            override fun onSuccess(obj: Any) {
                mHandler.obtainMessage(HANDLER_REFRESH, obj).sendToTarget()
            }

        })
    }
}
