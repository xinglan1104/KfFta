package com.xl.kffta.ui.fragment.lawcase

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xl.kffta.model.GetFilepathBean
import com.xl.kffta.model.TaskInfoBean
import com.xl.kffta.model.lawcase.LawCaseByIdBean
import com.xl.kffta.model.lawcase.LawCaseItemBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.FilesNetManager
import com.xl.kffta.util.ApplicationParams
import com.xl.kffta.util.SysUtils
import kotlinx.android.synthetic.main.fragment_case_common.*
import org.jetbrains.anko.support.v4.runOnUiThread

/**
 * @author zhanghaochen
 * Date: 2020/6/7
 * 描述：执法的新增立案
 */
class LawCaseAddTaskFragment : LawCaseBaseFragment() {

    private var mTaskInfoBean: TaskInfoBean? = null

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mTaskInfoBean = arguments?.getSerializable("taskInfo") as TaskInfoBean?

        return super.initView(inflater, container, savedInstanceState)
    }

    override fun initListener(mainView: View) {
        super.initListener(mainView)

        common_bottom_layout.visibility = View.VISIBLE
        common_left_btn.text = "提交"
        common_right_btn.text = "返回"
        common_right_btn.setOnClickListener {
            activity?.finish()
        }
    }

    override fun initData() {
        sendRequest()
    }

    override fun sendRequest() {
        // 新增案件，肯定没有files的路径，请求一下
        FilesNetManager.getUploadFilePath(FilesNetManager.TASK_CODENAME, object : ResponseObjectCallback {
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
                        mTaskInfoBean?.let { initDataItems(it) }
                        mAdapter.notifyDataChange(mDatas)
                    }
                }
            }

        })
    }

    override fun handleMessage(message: Message) {

    }

    override fun initDataItems(bean: Any) {
        if (bean is TaskInfoBean) {
            mDatas.clear()
            mDatas.add(LawCaseItemBean(label = "企业名称", value = bean.data?.business?.businessName
                    ?: ""))
            mDatas.add(LawCaseItemBean(label = "经营场所", value = bean.data?.business?.dom
                    ?: "", isLocationAble = true))
            // 执法人可能有多个
            val owners = bean.data?.owner
            val ownerStr = StringBuilder("")
            owners?.forEach {
                ownerStr.append(SysUtils.getSafeString(it.userName))
                ownerStr.append("  ")
            }
            mDatas.add(LawCaseItemBean(label = "执法人", value = ownerStr.toString()))

            // 执行完成
            mDatas.add(LawCaseItemBean(label = "执法时间", value = SysUtils.getDateTimestamp(bean.data?.excuteTime)))
            mDatas.add(LawCaseItemBean(label = "检查结果", value = bean.data?.result
                    ?: ""))
            mDatas.add(LawCaseItemBean(label = "备注", value = bean.data?.note ?: ""))
            mDatas.add(LawCaseItemBean(label = "附件"))

            mDatas.add(LawCaseItemBean(titleName = "案件提供者信息", isTitle = true))
            mDatas.add(LawCaseItemBean(label = "提供者姓名", value = ApplicationParams.USER_NAME))
            mDatas.add(LawCaseItemBean(label = "提供者联系方式", value = ApplicationParams.USER_PHONE))
            mDatas.add(LawCaseItemBean(label = "提供者地址", value = ApplicationParams.USER_ADDRESS))
        }
    }
}