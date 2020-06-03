package com.xl.kffta.ui.fragment.lawcase

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author created by zhanghaochen
 * @date 2020-06-03 17:24
 * 描述：案件详情的fragment
 */
class LawCaseDetailFragment : LawCaseBaseFragment() {

    private var mId = 0

    override fun handleMessage(message: Message) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mId = arguments?.getInt("id", 0) ?: 0

        return super.initView(inflater, container, savedInstanceState)
    }

    override fun initListener(mainView: View) {
        title_name.text = "案件详情"

    }
}