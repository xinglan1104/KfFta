package com.xl.kffta.ui.fragment.lawcase

import android.os.Message
import android.view.View
import com.xl.kffta.model.lawcase.LawCaseByIdBean
import kotlinx.android.synthetic.main.fragment_case_common.*

/**
 * @author zhanghaochen
 * Date: 2020/5/31
 * 描述：普通的新增案件界面
 */
class LawCaseAddNormalFragment : LawCaseBaseFragment() {

    override fun handleMessage(message: Message) {

    }

    override fun initListener(mainView: View) {
        super.initListener(mainView)

        common_bottom_layout.visibility = View.VISIBLE
        common_left_btn.text = "提交"
    }

    override fun initDataItems(lawIdBean: LawCaseByIdBean) {

    }

    override fun sendRequest() {
        TODO("Not yet implemented")
    }
}