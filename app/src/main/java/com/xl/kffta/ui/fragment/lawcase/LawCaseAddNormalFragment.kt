package com.xl.kffta.ui.fragment.lawcase

import android.os.Message
import android.view.View
import com.xl.kffta.model.lawcase.LawCaseByIdBean
import com.xl.kffta.model.lawcase.LawCaseItemBean
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

    override fun initData() {
        // 新建案件，直接就不请求，直接弄
        initDataItems(LawCaseByIdBean())
        mAdapter.notifyDataChange(mDatas)
    }

    override fun initDataItems(lawIdBean: LawCaseByIdBean) {
        mDatas.clear()
        mDatas.add(LawCaseItemBean(label = "案件名称", isEditable = true, editHintStr = "请输入案件名称"))
        mDatas.add(LawCaseItemBean(label = "案件来源", isEditable = true, editHintStr = "请输入案件来源"))
        mDatas.add(LawCaseItemBean(label = "当事企业", isEditable = true, isEditAutoComplete = true, editHintStr = "请输入当事企业"))
        mDatas.add(LawCaseItemBean(label = "统一社会信用代码"))
        mDatas.add(LawCaseItemBean(label = "部门", value = "请选择部门", isShowSelector = true))
        mDatas.add(LawCaseItemBean(label = "线索(举报)内容", isEditable = true, editHintStr = "请输入线索或举报内容"))
        mDatas.add(LawCaseItemBean(label = "备注", isEditable = true, editHintStr = "请输入备注信息"))
        mDatas.add(LawCaseItemBean(isTitle = true, titleName = "案件提供信息"))
        mDatas.add(LawCaseItemBean(label = "提供者姓名", isEditable = true, editHintStr = "请输入提供者姓名"))
        mDatas.add(LawCaseItemBean(label = "提供者联系方式", isEditable = true, editHintStr = "请输入提供者联系方式"))
        mDatas.add(LawCaseItemBean(label = "提供者地址", isEditable = true, editHintStr = "请输入提供者地址"))
    }

    override fun sendRequest() {
        TODO("Not yet implemented")
    }
}