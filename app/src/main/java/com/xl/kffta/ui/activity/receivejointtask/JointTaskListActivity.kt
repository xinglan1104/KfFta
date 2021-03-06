package com.xl.kffta.ui.activity.receivejointtask

import android.os.Message
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.adapter.jointtask.JointTaskListAdapter
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.JointTaskBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.JointTaskManager
import com.xl.kffta.util.DialogUtil
import kotlinx.android.synthetic.main.activity_takeorder.*
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author created by zhanghaochen
 * @date 2020-05-21 10:32
 * 描述：领取项目检查任务（待领取的）
 */
class JointTaskListActivity : BaseActivity() {
    companion object {
        private const val HANDLER_REFRESH = 0x401
    }

    private val mAdapter by lazy {
        JointTaskListAdapter(this)
    }

    private var mPageIndex = 0
    private var mPageSize = 100

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
                    if (data.data?.size ?: 0 > 0) {
                        title_take_all.visibility = View.VISIBLE
                    } else {
                        title_take_all.visibility = View.GONE
                    }
                }
            }
        }
    }

    override fun initViews() {
        title_left.setOnClickListener {
            finish()
        }
        title_name.text = "待领取项目检查任务"
    }

    override fun initListener() {
        title_take_all.setOnClickListener {
            DialogUtil.showCommonDialog(this@JointTaskListActivity, "确定要领取所有任务吗", object : DialogUtil.OnDialogOkClick {
                override fun onDialogOkClick() {
                    takeAllQuest()
                }

            })
        }

        take_recycler.layoutManager = object : LinearLayoutManager(this) {
            override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
                try {
                    super.onLayoutChildren(recycler, state)
                } catch (ignored: Exception) {
                }
            }
        }

        take_recycler.adapter = mAdapter
        mAdapter.setOnJointTaskAcceptOrRefuseSuccessListener(object : JointTaskListAdapter.OnJointTaskAcceptOrRefuseSuccessListener {
            override fun onJointTaskAcceptOrRefuseSuccess() {
                // 领取或退回成功，再次刷新界面
                sendRequest()
            }

        })

        // todo 先禁用刷新功能
        take_refresh_layout.setEnableRefresh(false)
        take_refresh_layout.setEnableLoadMore(false)
    }

    override fun onResume() {
        super.onResume()
        sendRequest()
    }

    private fun sendRequest() {
        showProgress()
        JointTaskManager.queryJointTask(mPageIndex, mPageSize, object : ResponseObjectCallback {
            override fun onError(msg: String) {
                myToast(msg)
                hideProgress()
            }

            override fun onSuccess(obj: Any) {
                mHandler.obtainMessage(HANDLER_REFRESH, obj).sendToTarget()
                hideProgress()
            }

        })
    }

    private fun takeAllQuest() {
        showProgress()
        JointTaskManager.getOrCancelJointTask("-1", true, object : ResponseObjectCallback {
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
}
