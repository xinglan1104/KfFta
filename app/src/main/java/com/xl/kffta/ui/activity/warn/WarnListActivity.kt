package com.xl.kffta.ui.activity.warn

import android.content.Context
import android.os.Message
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.warn.WarnObjectsBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.WarnManager
import com.xl.kffta.viewholder.NoDataViewHolder
import kotlinx.android.synthetic.main.activity_lawcase_list.*
import kotlinx.android.synthetic.main.layout_title_bar.*
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

/**
 * @author created by zhanghaochen
 * @date 2020-06-12 16:18
 * 描述：预警列表界面
 */
class WarnListActivity : BaseActivity() {
    companion object {
        private const val PAGE_SIZE = 50

        private const val HANDLER_REFRESH_SUCCESS = 0x550
        private const val HANDLER_SEND_ET = 0x551
    }

    private val mAdapter by lazy {
        MyAdapter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_lawcase_list
    }

    override fun handleMessage(message: Message) {
        when (message.what) {
            HANDLER_REFRESH_SUCCESS -> {
                val data = message.obj
                if (data is WarnObjectsBean) {
                    mAdapter?.notifyDataChange(data.data)
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
        title_name.text = "预警列表"
        title_add.visibility = View.VISIBLE
        title_left.setOnClickListener {
            finish()
        }
    }

    override fun initListener() {
        // 新增预警
        title_add.setOnClickListener {
            startActivity<WarnInfoDetailActivity>(WarnInfoDetailActivity.WARN_SOURCE to WarnInfoDetailActivity.WARN_FROM_ADD_COMMON)
        }
        // 搜索预警
        lawcase_search.doOnTextChanged { text, start, before, count ->
            // 避免频繁操作输入框，先把之前的消息都remove掉
            mHandler.removeMessages(HANDLER_SEND_ET)
            mHandler.sendEmptyMessageDelayed(HANDLER_SEND_ET, 300)
        }

        lawcase_recycler.layoutManager = object : LinearLayoutManager(this) {
            override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
                try {
                    super.onLayoutChildren(recycler, state)
                } catch (ignored: Exception) {
                }
            }
        }
        lawcase_recycler.adapter = mAdapter
    }

    override fun onResume() {
        super.onResume()
        sendRequest()
    }

    private fun sendRequest() {
        showProgress()
        WarnManager.queryWarnObjects("0", PAGE_SIZE, lawcase_search?.text?.toString()
            ?: "", object : ResponseObjectCallback {
            override fun onError(msg: String) {
                myToast(msg)
                hideProgress()
            }

            override fun onSuccess(obj: Any) {
                mHandler.obtainMessage(HANDLER_REFRESH_SUCCESS, obj).sendToTarget()
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
                lawcase_search?.clearFocus()
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
                false
            } else {
                true
            }
        }
        return false
    }

    /**
     * 自定义的适配器
     */
    private class MyAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        val mDatas = ArrayList<WarnObjectsBean.DataBean>()
        var mHasNotified = false

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_warn_list, parent, false)
            val noDataView = LayoutInflater.from(parent.context).inflate(R.layout.item_no_data, parent, false)

            return if (viewType == 0) {
                NoDataViewHolder(noDataView)
            } else {
                MyViewHolder(view)
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder) {
                is MyViewHolder -> {
                    val data = mDatas[position]
                    holder.label1.text = "编号"
                    holder.label2.text = "企业名称"
                    holder.value1.text = data.code
                    holder.value2.text = data.business?.businessName ?: ""
                    holder.itemView.setOnClickListener {
                        context.startActivity<WarnInfoDetailActivity>(WarnInfoDetailActivity.WARN_SOURCE to WarnInfoDetailActivity.WARN_FROM_WARN_LIST,
                            WarnInfoDetailActivity.WARN_ID to data.id)
                    }
                }

                is NoDataViewHolder -> {
                    holder.itemView.visibility = if (mHasNotified) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }
                }
            }
        }

        /**
         * 没有数据返回0，有数据返回1
         */
        override fun getItemViewType(position: Int): Int {
            return if (mDatas.size <= 0) {
                0
            } else {
                1
            }
        }

        override fun getItemCount(): Int {
            return if (mDatas.size <= 0) {
                1
            } else {
                mDatas.size
            }
        }

        /**
         * 刷新全部数据
         */
        fun notifyDataChange(datas: ArrayList<WarnObjectsBean.DataBean>) {
            mDatas.clear()
            if (!datas.isNullOrEmpty()) {
                mDatas.addAll(datas)
            }
            mHasNotified = true
            notifyDataSetChanged()
        }
    }


    private class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label1 = itemView.find<TextView>(R.id.warn_label1)
        val value1 = itemView.find<TextView>(R.id.warn_value1)
        val label2 = itemView.find<TextView>(R.id.warn_label2)
        val value2 = itemView.find<TextView>(R.id.warn_value2)
    }

}
