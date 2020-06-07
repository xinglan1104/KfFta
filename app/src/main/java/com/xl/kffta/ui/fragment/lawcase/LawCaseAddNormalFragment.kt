package com.xl.kffta.ui.fragment.lawcase

import android.os.Message
import android.text.TextUtils
import android.view.View
import com.xl.kffta.model.GetFilepathBean
import com.xl.kffta.model.lawcase.LawCaseByIdBean
import com.xl.kffta.model.lawcase.LawCaseItemBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.FilesNetManager
import com.xl.kffta.net.taskmanager.LawCaseManager
import com.xl.kffta.util.DialogUtil
import kotlinx.android.synthetic.main.fragment_case_common.*
import org.jetbrains.anko.support.v4.runOnUiThread

/**
 * @author zhanghaochen
 * Date: 2020/5/31
 * 描述：普通的新增案件界面
 */
class LawCaseAddNormalFragment : LawCaseBaseFragment() {
    var mFilePath: String = ""

    override fun handleMessage(message: Message) {

    }

    override fun initListener(mainView: View) {
        super.initListener(mainView)

        common_bottom_layout.visibility = View.VISIBLE
        common_left_btn.text = "提交"
        common_right_btn.text = "返回"
        common_right_btn.setOnClickListener {
            activity?.finish()
        }

        // 提交按钮的点击逻辑
        common_left_btn.setOnClickListener {
            // 判断是否全部输入了
            val noEnterTip = mAdapter.getNoEnterString()
            if (!TextUtils.isEmpty(noEnterTip)) {
                myToast(noEnterTip)
            } else {
                // 提交案件
                LawCaseManager.addNewCommonCase(getNewCaseBean(mAdapter.mResultMap), object : ResponseObjectCallback {
                    override fun onError(msg: String) {
                        runOnUiThread {
                            DialogUtil.showSingleCommonDialog(context = context, msg = msg)
                        }
                    }

                    override fun onSuccess(obj: Any) {
                        myToast("新增案件成功")
                        runOnUiThread {
                            activity?.finish()
                        }
                    }

                })
            }
        }
    }

    override fun initData() {
        sendRequest()

    }

    override fun initDataItems(lawIdBean: LawCaseByIdBean) {
        mDatas.clear()
        mDatas.add(LawCaseItemBean(label = "案件名称", isEditable = true, editHintStr = "请输入案件名称"))
        mDatas.add(LawCaseItemBean(label = "案件来源", isEditable = true, editHintStr = "请输入案件来源"))
        mDatas.add(LawCaseItemBean(isEditAutoComplete = true))
        mDatas.add(LawCaseItemBean(label = "部门", value = "请选择部门", isShowSelector = true))
        mDatas.add(LawCaseItemBean(label = "线索(举报)内容", isEditable = true, editHintStr = "请输入线索或举报内容"))
        mDatas.add(LawCaseItemBean(label = "备注", isEditable = true, editHintStr = "请输入备注信息"))
        if (!TextUtils.isEmpty(mFilePath)) {
            mDatas.add(LawCaseItemBean(label = "附件", needUpload = true, uploadPath = mFilePath))
        }

        mDatas.add(LawCaseItemBean(isTitle = true, titleName = "案件提供信息"))
        mDatas.add(LawCaseItemBean(label = "提供者姓名", isEditable = true, editHintStr = "请输入提供者姓名"))
        mDatas.add(LawCaseItemBean(label = "提供者联系方式", isEditable = true, editHintStr = "请输入提供者联系方式"))
        mDatas.add(LawCaseItemBean(label = "提供者地址", isEditable = true, editHintStr = "请输入提供者地址"))

        mAdapter.mResultMap["案件名称"] = ""
        mAdapter.mResultMap["案件来源"] = ""
        mAdapter.mResultMap["当事企业"] = ""
        mAdapter.mResultMap["统一社会信用代码"] = ""
        mAdapter.mResultMap["部门"] = ""
        mAdapter.mResultMap["线索(举报)内容"] = ""
        mAdapter.mResultMap["备注"] = ""
        mAdapter.mResultMap["提供者姓名"] = ""
        mAdapter.mResultMap["提供者联系方式"] = ""
        mAdapter.mResultMap["提供者地址"] = ""
    }

    override fun sendRequest() {
        // 新增案件，肯定没有files的路径，请求一下
        FilesNetManager.getUploadFilePath(FilesNetManager.LAWCASE_CODENAME, object : ResponseObjectCallback {
            override fun onError(msg: String) {
                myToast("无法获取附件上传路径")
                runOnUiThread {
                    // 新建案件，不需要请求，直接弄
                    initDataItems(LawCaseByIdBean())
                    mAdapter.notifyDataChange(mDatas)
                }
            }

            override fun onSuccess(obj: Any) {
                runOnUiThread {
                    if (obj is GetFilepathBean) {
                        mFilePath = obj.data ?: ""

                        // 新建案件，不需要请求，直接弄
                        initDataItems(LawCaseByIdBean())
                        mAdapter.notifyDataChange(mDatas)
                    }
                }
            }

        })
    }

    /**
     * 把输入内容包装成案件data
     */
    private fun getNewCaseBean(hashMap: LinkedHashMap<String, String>): LawCaseByIdBean {
        val lawCaseByIdBean = LawCaseByIdBean()
        lawCaseByIdBean.data = LawCaseByIdBean.DataBean()
        lawCaseByIdBean.data.business = LawCaseByIdBean.DataBean.BusinessBean()
        lawCaseByIdBean.data.department = LawCaseByIdBean.DataBean.DepartmentBeanX()
        lawCaseByIdBean.data.name = hashMap["案件名称"]
        lawCaseByIdBean.data.source = hashMap["案件来源"]
        lawCaseByIdBean.data.business.businessName = hashMap["当事企业"]
        lawCaseByIdBean.data.business.businessLicenseRegistrationNumber = hashMap["统一社会信用代码"]
        lawCaseByIdBean.data.department.name = hashMap["部门"]
        lawCaseByIdBean.data.content = hashMap["线索(举报)内容"]
        lawCaseByIdBean.data.note = hashMap["备注"]
        lawCaseByIdBean.data.contactName = hashMap["提供者姓名"]
        lawCaseByIdBean.data.contactPhone = hashMap["提供者联系方式"]
        lawCaseByIdBean.data.contactAddress = hashMap["提供者地址"]

        // 附件部分，先看看有没有上传
        if (mAdapter?.mIsUploaded) {
            // 上传了就加个|0
            if (!TextUtils.isEmpty(mFilePath)) {
                mFilePath = "$mFilePath|0"
            }
        }
        if (!mFilePath.isNullOrEmpty()) {
            lawCaseByIdBean.data.files = mFilePath
        }
        return lawCaseByIdBean
    }
}