package com.xl.kffta.ui.fragment.warn

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.adapter.warn.WarnDetailAdapter
import com.xl.kffta.base.BaseFragment
import com.xl.kffta.model.warn.WarnItemBean
import org.jetbrains.anko.support.v4.find

/**
 * @author zhanghaochen
 * Date: 2020/6/13
 * 描述：预警详情base
 */
abstract class WarnInfoBaseFragment : BaseFragment() {
    protected val mDatas = ArrayList<WarnItemBean>()

    protected var mIsFileOnlyShow: Boolean = true
    protected var mId = 0

    private val mAdapter by lazy {
        WarnDetailAdapter(context, mIsFileOnlyShow)
    }

    val mRecyclerView by lazy {
        find<RecyclerView>(R.id.common_case_recycler)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_case_common, container, false)

        return view
    }

    override fun initListener(mainView: View) {
        mRecyclerView.layoutManager = object : LinearLayoutManager(context) {
            override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
                try {
                    super.onLayoutChildren(recycler, state)
                } catch (ignored: Exception) {
                }
            }
        }

        mRecyclerView.adapter = mAdapter
    }

    override fun handleMessage(message: Message) {

    }

    abstract fun initDataItems(bean: Any)

    abstract fun sendRequest()
}