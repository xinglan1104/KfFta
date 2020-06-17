package com.xl.kffta.ui.fragment.warn

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xl.kffta.model.GetFilepathBean
import com.xl.kffta.model.TaskInfoBean
import com.xl.kffta.model.upload.WarnUploadBean
import com.xl.kffta.model.warn.WarnByIdBean
import com.xl.kffta.model.warn.WarnItemBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.FilesNetManager
import com.xl.kffta.net.taskmanager.WarnManager
import com.xl.kffta.ui.activity.warn.WarnInfoDetailActivity
import com.xl.kffta.util.ApplicationParams
import com.xl.kffta.util.DialogUtil
import com.xl.kffta.util.SysUtils
import kotlinx.android.synthetic.main.fragment_case_common.*
import org.jetbrains.anko.support.v4.runOnUiThread

/**
 * @author created by zhanghaochen
 * @date 2020-06-16 11:14
 * 描述：添加预警界面
 */
class WarnAddNormalFragment : WarnInfoBaseFragment() {
    // 是否要填充自己的信息
    private var mNeedFitUserInfo: Boolean = true

    private var mTaskInfoBean: TaskInfoBean? = null

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mNeedFitUserInfo = arguments?.getBoolean("showUserInfo", true) ?: true
        mIsFileOnlyShow = arguments?.getBoolean("fileOnlyShow", true) ?: true
        mTaskInfoBean = arguments?.getSerializable(WarnInfoDetailActivity.TASK_INFO_BEAN) as TaskInfoBean?
        return super.initView(inflater, container, savedInstanceState)
    }

    override fun initListener(mainView: View) {
        super.initListener(mainView)

        common_bottom_layout.visibility = View.VISIBLE
        common_left_btn.text = "提交"
        common_right_btn.text = "取消"
        common_right_btn.setOnClickListener {
            activity?.finish()
        }

        // 提交按钮的点击逻辑
        common_left_btn.setOnClickListener {
            // 判断是否全部输入了
            val noEnterTip = mAdapter.getCommonNoEnterString()
            if (noEnterTip.isNotEmpty()) {
                myToast(noEnterTip)
            } else {
                // 提交预警
                if (mAdapter.mIsDepartmentChanged) {
                    // 编辑过部门，需要交验部门信息
                    if (mAdapter.mDepartmentInfoData == null || mAdapter.mDepartmentStr.trim() != mAdapter.mDepartmentInfoData?.name?.trim()) {
                        myToast("请正确输入部门的信息")
                        return@setOnClickListener
                    }
                }
                if (mAdapter.mBusinessInfoData == null || mAdapter.mBusinessStr != mAdapter.mBusinessInfoData?.businessName?.trim()) {
                    myToast("请正确输入企业信息")
                } else {
                    context?.let { context ->
                        DialogUtil.showCommonDialog(context, "确定要新增预警吗", object : DialogUtil.OnDialogOkClick {
                            override fun onDialogOkClick() {
                                WarnManager.addNewWarning(getWarnByIdBean(), object : ResponseObjectCallback {
                                    override fun onError(msg: String) {
                                        runOnUiThread {
                                            DialogUtil.showSingleCommonDialog(context = context, msg = msg)
                                        }
                                    }

                                    override fun onSuccess(obj: Any) {
                                        myToast("新增预警成功")
                                        runOnUiThread {
                                            activity?.finish()
                                        }
                                    }
                                })
                            }

                        })
                    }
                }

            }
        }
    }

    override fun initDataItems(bean: Any) {
        mDatas.clear()
        // 根据有没有taskinfobean，判断企业名称是否赋值
        if (mTaskInfoBean == null) {
            mDatas.add(WarnItemBean(label = "企业名称", editHint = "请输入企业名称", isBusinessAutoComplete = true, editAutoCompleteSingleLine = true))
        } else {
            mDatas.add(WarnItemBean(label = "企业名称", value = mTaskInfoBean?.data?.business?.businessName
                ?: ""))
        }
        mDatas.add(WarnItemBean(label = "预警部门", isDepartmentAutoComplete = true, editHint = "请输入预警部门", value = ApplicationParams.USER_DEPARTMENT))
        mDatas.add(WarnItemBean(label = "预警信息", isEditAble = true, editHint = "请输入预警信息", isSingleLine = false))
        mDatas.add(WarnItemBean(label = "备注", isEditAble = true, editHint = "请输入备注", isSingleLine = false))
        if (ApplicationParams.TEMP_FILE_PATH.isNotEmpty()) {
            mDatas.add(WarnItemBean(label = "附件", isUploadFile = true))
        }

        // 初始化一些提交数据
        mAdapter.mWarnResultMap["企业名称"] = ""
        mAdapter.mWarnResultMap["预警部门"] = ""
        mAdapter.mWarnResultMap["预警信息"] = ""
        mAdapter.mWarnResultMap["备注"] = ""

    }

    override fun initData() {
        sendRequest()
    }

    override fun sendRequest() {
        // 新增预警，肯定没有files的路径，请求一下
        FilesNetManager.getUploadFilePath(FilesNetManager.WARN_CODENAME, object : ResponseObjectCallback {
            override fun onError(msg: String) {
                myToast("无法获取附件上传路径")
                runOnUiThread {
                    // 新建案件，不需要请求，直接弄
                    // 赋值这个文件路径
                    ApplicationParams.TEMP_FILE_PATH = ""

                    initDataItems(WarnByIdBean())
                    mAdapter.notifyDataChange(mDatas)
                }
            }

            override fun onSuccess(obj: Any) {
                runOnUiThread {
                    if (obj is GetFilepathBean) {
                        ApplicationParams.TEMP_FILE_PATH = obj.data ?: ""

                        // 新建案件，不需要请求，直接弄
                        initDataItems(WarnByIdBean())
                        mAdapter.notifyDataChange(mDatas)
                    }
                }
            }

        })
    }

    override fun handleMessage(message: Message) {

    }

    /**
     * 把输入的内容包装成预警data
     */
    private fun getWarnByIdBean(): WarnUploadBean {
        val warnUploadBean = WarnUploadBean()
        warnUploadBean.department = WarnUploadBean.DepartmentBean()
        warnUploadBean.business = WarnUploadBean.BusinessBean()

        if (mAdapter.mIsDepartmentChanged) {
            warnUploadBean.department.id = mAdapter.mDepartmentInfoData?.id ?: 0
            warnUploadBean.department.name = mAdapter.mDepartmentInfoData?.name
            warnUploadBean.departmentID = mAdapter.mDepartmentInfoData?.id ?: 0
        } else {
            warnUploadBean.department.id = ApplicationParams.USER_DEPARTMENT_ID
            warnUploadBean.department.name = ApplicationParams.USER_DEPARTMENT
            warnUploadBean.departmentID = ApplicationParams.USER_DEPARTMENT_ID
        }

        // 企业部分要区分有没有taskinfobean
        if (mTaskInfoBean == null) {
            warnUploadBean.business.id = mAdapter.mBusinessInfoData?.id?.toInt() ?: 0
            warnUploadBean.business.businessName = mAdapter.mBusinessInfoData?.businessName
            warnUploadBean.businessID = mAdapter.mBusinessInfoData?.id ?: 0
        } else {
            warnUploadBean.business.id = mTaskInfoBean?.data?.business?.id ?: 0
            warnUploadBean.business.businessName = mTaskInfoBean?.data?.business?.businessName ?: ""
            warnUploadBean.businessID = mTaskInfoBean?.data?.businessID ?: 0
        }

        warnUploadBean.content = mAdapter.mWarnResultMap["预警信息"]
        warnUploadBean.note = mAdapter.mWarnResultMap["备注"]

        // 附件部分，先看看有没有上传
        val filePath = if (mAdapter?.mIsUploaded) {
            SysUtils.getAppendAddFilePath(ApplicationParams.TEMP_FILE_PATH)
        } else {
            ApplicationParams.TEMP_FILE_PATH
        }

        warnUploadBean.files = filePath

        return warnUploadBean
    }
}
