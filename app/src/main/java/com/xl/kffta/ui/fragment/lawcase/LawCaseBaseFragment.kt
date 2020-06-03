package com.xl.kffta.ui.fragment.lawcase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.adapter.lawcase.LawCaseDetailAdapter
import com.xl.kffta.base.BaseFragment
import com.xl.kffta.model.lawcase.LawCaseByIdBean
import com.xl.kffta.model.lawcase.LawCaseItemBean
import org.jetbrains.anko.support.v4.find

/**
 * @author zhanghaochen
 * Date: 2020/5/31
 * 描述：新增和案件详情的base界面
 */
abstract class LawCaseBaseFragment : BaseFragment() {
    protected val mDatas = ArrayList<LawCaseItemBean>()

    val mAdapter by lazy {
        LawCaseDetailAdapter(context)
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

    abstract fun initDataItems(lawIdBean: LawCaseByIdBean)

    abstract fun sendRequest()
}