package com.xl.kffta.ui.activity.executejointtask

import android.content.Context
import android.os.Message
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import kotlinx.android.synthetic.main.activity_execute.*
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author created by zhanghaochen
 * @date 2020-05-21 17:31
 * 描述：执行项目检查任务的列表
 */
class ExecuteJointTaskListActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        // 直接复用执行执法任务的界面
        return R.layout.activity_execute
    }

    override fun handleMessage(message: Message) {

    }

    override fun initViews() {
        title_left.setOnClickListener {
            finish()
        }
        title_name.text = "执行项目检查任务"

        exe_list_recycler.layoutManager = object : LinearLayoutManager(this) {
            override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
                try {
                    super.onLayoutChildren(recycler, state)
                } catch (ignored: Exception) {
                }
            }
        }
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
