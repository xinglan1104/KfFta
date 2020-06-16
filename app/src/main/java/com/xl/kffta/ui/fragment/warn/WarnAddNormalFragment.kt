package com.xl.kffta.ui.fragment.warn

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xl.kffta.model.GetFilepathBean
import com.xl.kffta.model.warn.WarnByIdBean
import com.xl.kffta.model.warn.WarnItemBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.FilesNetManager
import com.xl.kffta.util.ApplicationParams
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

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mNeedFitUserInfo = arguments?.getBoolean("showUserInfo", true) ?: true
        mIsFileOnlyShow = arguments?.getBoolean("fileOnlyShow", true) ?: true
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
                // 提交案件
            }
        }
    }

    override fun initDataItems(bean: Any) {
        mDatas.clear()
        mDatas.add(WarnItemBean(label = "企业名称", editHint = "请输入企业名称", isBusinessAutoComplete = true, editAutoCompleteSingleLine = true))
        mDatas.add(WarnItemBean(label = "预警部门", isDepartmentAutoComplete = true, editHint = "请输入预警部门"))
        mDatas.add(WarnItemBean(label = "预警信息", isEditAble = true, editHint = "请输入预警信息"))
        mDatas.add(WarnItemBean(label = "备注", isEditAble = true, editHint = "请输入备注"))
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
}
