package com.xl.kffta.ui.fragment.warn

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xl.kffta.model.CommonFileBean
import com.xl.kffta.model.warn.WarnByIdBean
import com.xl.kffta.model.warn.WarnItemBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.FilesNetManager
import com.xl.kffta.net.taskmanager.WarnManager
import com.xl.kffta.util.SysUtils
import org.jetbrains.anko.support.v4.runOnUiThread

/**
 * @author zhanghaochen
 * Date: 2020/6/13
 * 描述：预警详情页
 */
class WarnDetailFragment : WarnInfoBaseFragment() {


    companion object {
        private const val HANDLER_REFRESH_SUCCESS = 0x531
    }

    override fun handleMessage(message: Message) {
        when (message.what) {
            HANDLER_REFRESH_SUCCESS -> {
                val data = message.obj
                if (data is WarnByIdBean) {
                    initDataItems(data)
                    mAdapter?.notifyDataChange(mDatas)
                }
            }
        }
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mId = arguments?.getInt("id", 0) ?: 0
        mIsFileOnlyShow = arguments?.getBoolean("fileOnlyShow", true) ?: true

        return super.initView(inflater, container, savedInstanceState)
    }

    override fun initData() {
        sendRequest()
    }

    override fun initDataItems(bean: Any) {
        if (bean is WarnByIdBean) {
            mDatas.clear()
            mDatas.add(WarnItemBean(label = "企业名称", value = bean.data?.business?.businessName
                    ?: ""))
            mDatas.add(WarnItemBean(label = "预警部门", value = bean.data?.department?.name ?: ""))
            mDatas.add(WarnItemBean(label = "预警人", value = bean.data?.creator?.userName ?: ""))
            mDatas.add(WarnItemBean(label = "预警时间", value = SysUtils.getDateTimestamp(bean.data?.createTime)))
            mDatas.add(WarnItemBean(label = "预警信息", value = bean.data?.content ?: ""))
            mDatas.add(WarnItemBean(label = "备注", value = bean.data?.note ?: ""))

            // 由于是详情界面，files没返回，没东西，就不需要处理
            val ids = SysUtils.getFileIds(bean.data?.files)
            if (!ids.isNullOrEmpty()) {
                requestFiles(ids)
                mDatas.add(WarnItemBean(label = "附件", isUploadFile = true))
            }
        }
    }

    override fun sendRequest() {
        WarnManager.queryWarnById(mId, object : ResponseObjectCallback {
            override fun onError(msg: String) {
                myToast(msg)
            }

            override fun onSuccess(obj: Any) {
                mHandler.obtainMessage(HANDLER_REFRESH_SUCCESS, obj).sendToTarget()
            }
        })
    }

    /**
     * 请求id对应的文件
     */
    private fun requestFiles(ids: ArrayList<Long>) {
        FilesNetManager.getFiles(ids, object : ResponseObjectCallback {
            override fun onError(msg: String) {

            }

            override fun onSuccess(obj: Any) {
                if (obj is CommonFileBean) {
                    runOnUiThread {
                        var position = 0
                        mDatas?.let {
                            it.forEachIndexed { index, warmItemBean ->
                                if (warmItemBean.label == "附件") {
                                    warmItemBean.commonFileBean = obj
                                    position = index
                                    return@forEachIndexed
                                }
                            }
                        }
                        if (position > 0) {
                            mAdapter.notifyItemChanged(position)
                        }
                    }
                }
            }

        })
    }

}