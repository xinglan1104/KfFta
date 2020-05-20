package com.xl.kffta.ui.activity.singletask

import android.os.Message
import android.text.TextUtils
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.xl.kffta.R
import com.xl.kffta.adapter.CheckListAdapter
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.CheckListBean
import com.xl.kffta.model.CheckListItemBean
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.net.taskmanager.TaskNetManager
import kotlinx.android.synthetic.main.activity_checklist.*
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author created by zhanghaochen
 * @date 2020-05-20 10:32
 * 描述：事件清单页面
 */
class CheckListActivity : BaseActivity() {
    companion object {
        const val CHECKLIST_ID = "checkListId"
        const val HANDLER_GET_SUCCESS = 0x201
    }

    private val mAdapter by lazy {
        CheckListAdapter(this)
    }

    private var mCheckListId: Int = 0

    private var mItemDatas = ArrayList<CheckListItemBean>()

    override fun getLayoutId(): Int {
        return R.layout.activity_checklist
    }

    override fun handleMessage(message: Message) {
        when (message.what) {
            HANDLER_GET_SUCCESS -> {
                val data = message.obj
                if (data is CheckListBean) {
                    refreshData(data)
                }
            }
        }
    }

    override fun initParams() {
        mCheckListId = intent.getIntExtra(CHECKLIST_ID, 0)
    }

    override fun initViews() {
        title_left.setOnClickListener {
            finish()
        }
        title_name.text = "事件清单"

        // recycler
        checklist_recycler.layoutManager = object : LinearLayoutManager(this) {
            override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
                try {
                    super.onLayoutChildren(recycler, state)
                } catch (ignored: java.lang.Exception) {
                }
            }
        }
        checklist_recycler.adapter = mAdapter
    }

    override fun initListener() {

    }

    /**
     * 把源数据转换成列表专用数据
     */
    fun initItemData(checkListBean: CheckListBean) {
        mItemDatas.clear()

        mItemDatas.add(CheckListItemBean("编号", checkListBean.data?.code ?: "", isClickable = false))
        mItemDatas.add(CheckListItemBean("检查项目名称", checkListBean.data?.name
                ?: "", isClickable = false))

        // 自贸区权限，是个列表
        val zmqqx = checkListBean.data?.freeTradeZonePriviledge
        if (!zmqqx.isNullOrEmpty()) {
            mItemDatas.add(CheckListItemBean(isTitle = true, title = "自贸区权限"))
            zmqqx.forEach {
                mItemDatas.add(CheckListItemBean(label = "事项名称", value = it.name, dialogName = it.priviledge, dialogValue = it.reason))
            }
        }

        // 省级下放权限清单
        val sjxf = checkListBean.data?.provincialPriviledge
        if (!sjxf.isNullOrEmpty()) {
            mItemDatas.add(CheckListItemBean(isTitle = true, title = "省级下放权限清单"))
            sjxf.forEach {
                mItemDatas.add(CheckListItemBean(label = "事项名称", value = it.name, dialogName = it.priviledge, dialogValue = it.reason))
            }
        }

        // 企业登记
        val qydj = checkListBean.data?.businessRegistration
        if (!qydj.isNullOrEmpty()) {
            mItemDatas.add(CheckListItemBean(isTitle = true, title = "企业登记"))
            qydj.forEach {
                mItemDatas.add(CheckListItemBean(label = "企业登记", value = it.name, dialogName = it.name, dialogValue = it.legalBasis))
            }
        }

        // 市场准入和任职
        val sczr = checkListBean.data?.marketEntryAndAppointment
        if (!sczr.isNullOrEmpty()) {
            mItemDatas.add(CheckListItemBean(isTitle = true, title = "市场准入和任职"))
            sczr.forEach {
                mItemDatas.add(CheckListItemBean(label = "企业登记", value = it.name, dialogName = it.priviledge, dialogValue = it.legalBasis))
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("CheckListActivity", "id:$mCheckListId")
        sendRequest()
    }

    private fun refreshData(checkListBean: CheckListBean) {
        initItemData(checkListBean)
        mAdapter?.notifyDataChange(mItemDatas)
    }

    private fun sendRequest() {
        TaskNetManager.queryCheckListById(mCheckListId.toString(), object : ResponseCallback {
            override fun onError(msg: String?) {
                myToast(msg ?: "请求错误")
            }

            override fun onSuccess(jsonString: String) {
                Log.d("CheckListActivity", "callback获取：$jsonString")
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val checkListBean: CheckListBean? = Gson().fromJson(jsonString, CheckListBean::class.java)
                        if (checkListBean == null) {
                            myToast("解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (checkListBean.errorCode < 0) {
                                myToast(checkListBean.error ?: "解析错误")
                            } else {
                                // success
                                mHandler.obtainMessage(HANDLER_GET_SUCCESS, checkListBean).sendToTarget()
                            }
                        }
                    } catch (e: Exception) {
                        myToast(e.message ?: "解析错误")
                    }
                } else {
                    myToast("请求返回为空")
                }
            }
        })
    }
}