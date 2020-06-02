package com.xl.kffta.ui.activity.executejointtask

import android.content.Context
import android.os.Message
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.adapter.jointtask.ExeJointTaskListAdapter
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.JointTaskBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.JointTaskManager
import kotlinx.android.synthetic.main.activity_execute.*
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author created by zhanghaochen
 * @date 2020-05-21 17:31
 * 描述：执行项目检查任务的列表（待执行和已执行）
 */
class ExecuteJointTaskListActivity : BaseActivity() {
    companion object {
        private val HANDLER_REFRESH = 0x601
        private val HANDLER_SEND_ET = 0x603

        /**
         * 项目检查任务的状态，待执行或者已执行
         */
        const val JOINT_EXE_TASK_STATE = "jointExeTaskType"
        const val JOINT_EXE_TASK_PENDING = 30
        const val JOINT_EXE_TASK_OVER = 32
    }


    private var mPageIndex = 0
    private var mPageSize = 50

    private var mJointExeState = JOINT_EXE_TASK_PENDING

    private val mAdapter by lazy {
        ExeJointTaskListAdapter(this)
    }

    override fun getLayoutId(): Int {
        // 直接复用执行执法任务的界面
        return R.layout.activity_execute
    }

    override fun handleMessage(message: Message) {
        when (message.what) {
            HANDLER_REFRESH -> {
                val data = message.obj
                if (data is JointTaskBean) {
                    mAdapter.notifyDataChange(data.data)
                }
            }
            HANDLER_SEND_ET -> {
                // 根据搜索内容查询
                sendRequest()
                mHandler.removeMessages(HANDLER_SEND_ET)
            }
        }
    }

    override fun initParams() {
        mJointExeState = intent.getIntExtra(JOINT_EXE_TASK_STATE, JOINT_EXE_TASK_PENDING)
    }

    override fun initViews() {
        title_left.setOnClickListener {
            finish()
        }
        when (mJointExeState) {
            JOINT_EXE_TASK_PENDING -> {
                title_name.text = "待执行项目检查任务"
            }
            JOINT_EXE_TASK_OVER -> {
                title_name.text = "已执行项目检查任务"
            }
        }


        exe_list_recycler.layoutManager = object : LinearLayoutManager(this) {
            override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
                try {
                    super.onLayoutChildren(recycler, state)
                } catch (ignored: Exception) {
                }
            }
        }
        exe_list_recycler.adapter = mAdapter
    }

    override fun initListener() {
        // 设置编辑框的逻辑
        exe_list_search.doAfterTextChanged {
            // 避免频繁操作输入框，先把之前的消息都remove掉
            mHandler.removeMessages(HANDLER_SEND_ET)
            mHandler.sendEmptyMessageDelayed(HANDLER_SEND_ET, 300)
        }
    }

    override fun onResume() {
        super.onResume()
        sendRequest()
    }

    /**
     * 发送请求，内容为输入框里的东西
     */
    private fun sendRequest() {
        showProgress()
        JointTaskManager.queryExecuteJointTaskList(mPageIndex, mPageSize, exe_list_search?.text?.toString()
                ?: "", if (mJointExeState == JOINT_EXE_TASK_PENDING) {
            JointTaskManager.ExcutionStatus_Pending.toString()
        } else {
            JointTaskManager.ExcutionStatus_Complete.toString()
        }, object : ResponseObjectCallback {
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

    // 点击其他地方隐藏键盘和光标
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val view = currentFocus
            if (isShouldHideInput(view, ev)) {
                val Object = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                Object?.hideSoftInputFromWindow(view?.getWindowToken(), 0)
                exe_list_search?.clearFocus()
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    //判断是否隐藏键盘
    fun isShouldHideInput(v: View?, event: MotionEvent): Boolean {
        if (v != null && v is EditText) {
            val leftTop = intArrayOf(0, 0)
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop)
            val left = leftTop[0]
            val top = leftTop[1]
            val bottom = top + v.height
            val right = left + v.width
            return if (event.x > left && event.x < right
                    && event.y > top && event.y < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                false
            } else {
                true
            }
        }
        return false
    }
}
