package com.xl.kffta.ui.activity.legalprocision

import android.os.Message
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.adapter.legal.LegalListAdapter
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.legalprovision.LegalProvisionBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.LegalLawManager
import kotlinx.android.synthetic.main.activity_normal_recycler.*
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

        private const val PAGE_SIZE = 50

        private const val HANDLER_REFRESHALL_SUCCESS = 0x430
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
        return R.layout.activity_normal_recycler
    }

    override fun handleMessage(message: Message) {
        when (message.what) {
            HANDLER_REFRESHALL_SUCCESS -> {
                val data = message.obj
                if (data is LegalProvisionBean) {
                    mAdapter.notifyDataChange(data.data)
                }
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
        common_recycler.layoutManager = object : LinearLayoutManager(this) {
            override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
                try {
                    super.onLayoutChildren(recycler, state)
                } catch (ignored: Exception) {
                }
            }
        }
        common_recycler.adapter = mAdapter

        // 设置点击事件
        mAdapter.mOnItemClickListener = object : LegalListAdapter.OnLegalItemClick {
            override fun onItemClick(legalBean: LegalProvisionBean.DataBean) {
                startActivity<LegalProvisionDetailActivity>(LegalProvisionDetailActivity.LEGAL_TITLE to mTitleStr,
                        LegalProvisionDetailActivity.LEGAL_BEAN to legalBean as Serializable)
            }

        }

        // todo 先禁用刷新功能
        refresh_layout.setEnableRefresh(false)
        refresh_layout.setEnableLoadMore(false)
    }

    override fun initData() {
        sendRequest()
    }

    /**
     * 请求对应code的法律条文们
     */
    private fun sendRequest() {
        showProgress()
        LegalLawManager.queryLegalProvision(mPageCode, PAGE_SIZE, object : ResponseObjectCallback {
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
}