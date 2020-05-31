package com.xl.kffta.ui.fragment.lawcase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.adapter.lawcase.LawCaseDetailAdapter
import com.xl.kffta.base.BaseFragment
import org.jetbrains.anko.support.v4.find

/**
 * @author zhanghaochen
 * Date: 2020/5/31
 * 描述：新增和案件详情的base界面
 */
abstract class LawCaseBaseFragment : BaseFragment() {
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

}