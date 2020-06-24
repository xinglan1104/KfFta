package com.xl.kffta.ui.activity.legalprocision

import android.content.Context
import android.os.Message
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.adapter.legal.LegalListAdapter
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.legalprovision.LegalProvisionBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.LegalLawManager
import kotlinx.android.synthetic.main.activity_lawcase_list.*
import kotlinx.android.synthetic.main.layout_title_bar.*
import org.jetbrains.anko.startActivity
import java.io.Serializable

/**
 * @author zhanghaochen
 * Date: 2020/6/1
 * 描述：某个类型的法律的列表页
 */
class LegalProvisionListActivity : BaseActivity() {
    companion object {
        const val TITLE_STRING = "titleString"
        const val PAGE_CODE = "PageCode"

        private const val PAGE_SIZE = 100

        private const val HANDLER_REFRESHALL_SUCCESS = 0x430
        private const val HANDLER_SEND_ET = 0x431
    }

    private var mTitleStr: String = "法律条文"

    /**
     * 该法律条文所属的列表
     */
    private var mPageCode = "0"

    private val mAdapter by lazy {
        LegalListAdapter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_lawcase_list
    }

    override fun handleMessage(message: Message) {
        when (message.what) {
            HANDLER_REFRESHALL_SUCCESS -> {
                val data = message.obj
                if (data is LegalProvisionBean) {
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
        mTitleStr = intent.getStringExtra(TITLE_STRING)
        mPageCode = intent.getStringExtra(PAGE_CODE)
    }

    override fun initViews() {
        title_name.text = mTitleStr
        title_left.setOnClickListener {
            finish()
        }
    }

    override fun initListener() {
        // 搜索法律
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

        // 设置点击事件
        mAdapter.mOnItemClickListener = object : LegalListAdapter.OnLegalItemClick {
            override fun onItemClick(legalBean: LegalProvisionBean.DataBean) {
                startActivity<LegalProvisionDetailActivity>(LegalProvisionDetailActivity.LEGAL_TITLE to mTitleStr,
                        LegalProvisionDetailActivity.LEGAL_BEAN to legalBean as Serializable)
            }

        }
    }

    override fun onResume() {
        super.onResume()
        sendRequest()
    }

    /**
     * 请求对应code的法律条文们
     */
    private fun sendRequest() {
        showProgress()
        LegalLawManager.queryLegalProvision(mPageCode, lawcase_search?.text?.toString()
                ?: "", PAGE_SIZE, object : ResponseObjectCallback {
            override fun onError(msg: String) {
                myToast(msg)
                hideProgress()
            }

            override fun onSuccess(obj: Any) {
                hideProgress()
                mHandler.obtainMessage(HANDLER_REFRESHALL_SUCCESS, obj).sendToTarget()
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

}