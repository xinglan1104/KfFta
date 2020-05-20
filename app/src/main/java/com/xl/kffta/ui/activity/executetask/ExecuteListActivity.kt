package com.xl.kffta.ui.activity.executetask

import android.content.Context
import android.os.Message
import android.text.TextUtils
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.xl.kffta.R
import com.xl.kffta.adapter.ExeTaskListAdapter
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.TakeOrderBean
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.net.taskmanager.TaskNetManager
import kotlinx.android.synthetic.main.activity_execute.*
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author created by zhanghaochen
 * @date 2020-05-20 15:04
 * 描述：执行任务列表页
 */
class ExecuteListActivity : BaseActivity() {

    companion object {
        const val HANDLER_REFRESH_ALL = 0x301
        const val HANDLER_SEND_ET = 0x302
    }

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

    override fun initViews() {
        title_left.setOnClickListener {
            finish()
        }
        title_name.text = "执行任务"

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
        TaskNetManager.queryExecuteTaskList(0, 50, exe_list_search?.text.toString()
                ?: "", object : ResponseCallback {
            override fun onError(msg: String?) {
                myToast(msg ?: "请求错误")
            }

            override fun onSuccess(jsonString: String) {
                Log.d("ExecuteListActivity", "callback获取：$jsonString")
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val exeTaskListBean: TakeOrderBean? = Gson().fromJson(jsonString, TakeOrderBean::class.java)
                        if (exeTaskListBean == null) {
                            myToast("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (exeTaskListBean.errorCode < 0) {
                                myToast(exeTaskListBean.error ?: "解析错误")
                            } else {
                                // success
                                mHandler.obtainMessage(HANDLER_REFRESH_ALL, exeTaskListBean).sendToTarget()
                            }
                        }
                    } catch (e: Exception) {
                        myToast(e.message ?: "解析错误")
                    }
                } else {
                    myToast("请求返回为空")
                }
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