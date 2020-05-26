package com.xl.kffta.ui.activity.executetask

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
import com.xl.kffta.adapter.task.ExeTaskListAdapter
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.TakeOrderBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.TaskNetManager
import kotlinx.android.synthetic.main.activity_execute.*
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author created by zhanghaochen
 * @date 2020-05-20 15:04
 * 描述：执行任务列表页,待执行和已执行的
 */
class ExecuteListActivity : BaseActivity() {

    private val HANDLER_REFRESH_ALL = 0x301
    private val HANDLER_SEND_ET = 0x302

    companion object {
        const val EXE_TASK_TYPE = "extTaskType"
        /**
         * 待执行
         */
        const val EXE_TASK_PENDING = 20
        /**
         * 已经执行完成
         */
        const val EXE_TASK_OVER = 21
    }

    private var mExeTaskType = EXE_TASK_PENDING

    private val mAdapter by lazy {
        ExeTaskListAdapter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_execute
    }

    override fun handleMessage(message: Message) {
        when (message.what) {
            HANDLER_REFRESH_ALL -> {
                val data = message.obj
                if (data is TakeOrderBean) {
                    if (data.data != null) {
                        mAdapter.notifyDataChange(data.data as ArrayList<TakeOrderBean.DataBean>)
                    }
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
        // 默认是待执行状态
        mExeTaskType = intent.getIntExtra(EXE_TASK_TYPE, EXE_TASK_PENDING)
    }

    override fun initViews() {
        title_left.setOnClickListener {
            finish()
        }
        when (mExeTaskType) {
            EXE_TASK_PENDING -> {
                title_name.text = "待执行任务"
            }
            EXE_TASK_OVER -> {
                title_name.text = "已执行任务"
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
     * 发送请求
     */
    private fun sendRequest() {
        showProgress()
        TaskNetManager.queryExecuteTaskList(pageCode = 0, pageSize = 50, searchStr = exe_list_search?.text.toString()
                ?: "", excutionStatus = if (mExeTaskType == EXE_TASK_PENDING) {
            "0"
        } else {
            "1"
        }, callback = object : ResponseObjectCallback {
            override fun onError(msg: String) {
                myToast(msg)
                hideProgress()
            }

            override fun onSuccess(obj: Any) {
                mHandler.obtainMessage(HANDLER_REFRESH_ALL, obj).sendToTarget()
                hideProgress()
            }

        })
    }

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