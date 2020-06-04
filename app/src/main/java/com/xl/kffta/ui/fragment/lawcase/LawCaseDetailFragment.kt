package com.xl.kffta.ui.fragment.lawcase

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xl.kffta.model.lawcase.LawCaseByIdBean
import com.xl.kffta.model.lawcase.LawCaseItemBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.LawCaseManager
import com.xl.kffta.util.SysUtils

/**
 * @author created by zhanghaochen
 * @date 2020-06-03 17:24
 * 描述：案件详情的fragment
 */
class LawCaseDetailFragment : LawCaseBaseFragment() {
    companion object {
        private const val HANDLER_REFRESH_SUCCESS = 0x531
    }

    private var mId = 0

    override fun handleMessage(message: Message) {
        when (message.what) {
            HANDLER_REFRESH_SUCCESS -> {
                val data = message.obj
                if (data is LawCaseByIdBean) {
                    initDataItems(data)
                    mAdapter?.notifyDataChange(mDatas)
                }
            }
        }
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mId = arguments?.getInt("id", 0) ?: 0

        return super.initView(inflater, container, savedInstanceState)
    }

    override fun initListener(mainView: View) {
        super.initListener(mainView)

    }

    override fun initData() {
        sendRequest()
    }

    /**
     * 把接口数据转换成简单的展示数据
     */
    override fun initDataItems(lawIdBean: LawCaseByIdBean) {
        mDatas.clear()
        mDatas.add(LawCaseItemBean(label = "案件名称", value = lawIdBean.data?.name ?: ""))
        mDatas.add(LawCaseItemBean(label = "案件来源", value = lawIdBean.data?.source ?: ""))
        mDatas.add(LawCaseItemBean(label = "当事企业", value = lawIdBean.data?.business?.businessName
                ?: ""))
        mDatas.add(LawCaseItemBean(label = "统一社会信用代码", value = lawIdBean.data?.business?.businessLicenseRegistrationNumber
                ?: ""))
        mDatas.add(LawCaseItemBean(label = "部门", value = lawIdBean.data.department?.name ?: ""))
        mDatas.add(LawCaseItemBean(label = "创建人", value = lawIdBean.data.creator.userName ?: ""))
        mDatas.add(LawCaseItemBean(label = "创建时间", value = SysUtils.getDateTimestamp(lawIdBean.data?.createTime)))
        mDatas.add(LawCaseItemBean(label = "线索(举报)内容", value = lawIdBean.data?.content ?: ""))
        mDatas.add(LawCaseItemBean(isTitle = true, titleName = "案件提供者信息"))
        mDatas.add(LawCaseItemBean(label = "提供者姓名", value = lawIdBean.data?.contactName ?: ""))
        mDatas.add(LawCaseItemBean(label = "提供者联系方式", value = lawIdBean.data?.contactPhone ?: ""))
        mDatas.add(LawCaseItemBean(label = "提供者地址", value = lawIdBean.data?.contactAddress ?: ""))
    }

    override fun sendRequest() {
        LawCaseManager.queryJointTaskById(mId, object : ResponseObjectCallback {
            override fun onError(msg: String) {
                myToast(msg)
            }

            override fun onSuccess(obj: Any) {
                mHandler.obtainMessage(HANDLER_REFRESH_SUCCESS, obj).sendToTarget()
            }

        })
    }
}