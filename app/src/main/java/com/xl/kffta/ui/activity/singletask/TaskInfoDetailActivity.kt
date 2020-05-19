package com.xl.kffta.ui.activity.singletask

import android.os.Message
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.TaskInfoBean
import com.xl.kffta.model.TaskItemInfo
import com.xl.kffta.presenter.impl.TaskInfoDetailImpl
import com.xl.kffta.util.SysUtils
import com.xl.kffta.view.ITaskInfoDetailView
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author created by zhanghaochen
 * @date 2020-05-19 11:21
 * 描述：任务详情页
 */
class TaskInfoDetailActivity : BaseActivity(), ITaskInfoDetailView {
    companion object {
        const val TASK_ID = "taskId"
        const val HANDLER_REFRESH = 0x101
    }

    private var taskId: Long = 0

    private var mDatas = ArrayList<TaskItemInfo>()

    private var mPresenter: TaskInfoDetailImpl? = TaskInfoDetailImpl()
    override fun getLayoutId(): Int {
        return R.layout.activity_taskinfo_detail
    }

    override fun handleMessage(message: Message) {
        when (message.what) {
            HANDLER_REFRESH -> {

            }
        }
    }

    override fun initParams() {
        taskId = intent.getLongExtra(TASK_ID, 0)
    }

    override fun initViews() {
        title_left.setOnClickListener {
            finish()
        }
        title_name.text = "任务信息"
    }

    override fun initData() {
        mPresenter?.queryTaskById(taskId.toString())
    }

    private fun initItemData(taskInfoBean: TaskInfoBean) {
        // 清空数据
        mDatas.clear()
        mDatas.add(TaskItemInfo("企业名称", taskInfoBean.data?.business?.businessName
                ?: "", isTitle = false, isCheckList = false))
        mDatas.add(TaskItemInfo("统一代码", taskInfoBean.data?.business?.businessLicenseRegistrationNumber
                ?: "", isTitle = false, isCheckList = false))
        mDatas.add(TaskItemInfo("经营场所", taskInfoBean.data?.business?.dom
                ?: "", isTitle = false, isCheckList = false))
        mDatas.add(TaskItemInfo("抽取方案", taskInfoBean.data?.govermentEnforcementScheme?.name
                ?: "", isTitle = false, isCheckList = false))
        // 执法人可能有多个
        val peoples = taskInfoBean.data?.pendingOwner
        val peoplesStr = StringBuilder()
        peoples?.forEach {
            peoplesStr.append(SysUtils.getSafeString(it.userName))
            peoplesStr.append(" ")
        }
        mDatas.add(TaskItemInfo("待接收执法人", peoplesStr.toString(), isTitle = false, isCheckList = false))

        mDatas.add(TaskItemInfo("执法人数", taskInfoBean.data?.requiredQuantity.toString(), isTitle = false, isCheckList = false))
        mDatas.add(TaskItemInfo("执法开始时间", taskInfoBean.data?.startDate
                ?: "", isTitle = false, isCheckList = false))
        mDatas.add(TaskItemInfo("执法截止时间", taskInfoBean.data?.endDate
                ?: "", isTitle = false, isCheckList = false))
        mDatas.add(TaskItemInfo("创建时间", taskInfoBean.data?.createTime
                ?: "", isTitle = false, isCheckList = false))

        val checkList = taskInfoBean.data?.checkList
        if (!checkList.isNullOrEmpty()) {
            mDatas.add(TaskItemInfo("事项清单", "", isTitle = true, isCheckList = false))
            checkList.forEach {
                mDatas.add(TaskItemInfo("事件清单", it.name
                        ?: "", isTitle = false, isCheckList = false, checkListId = it.id))
            }

        }
    }

    override fun onResume() {
        super.onResume()
        mPresenter?.bindView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.unBindView()
    }

    override fun loadViewSuccess(taskInfoBean: TaskInfoBean) {
        mHandler.obtainMessage(HANDLER_REFRESH, taskInfoBean).sendToTarget()
    }

    override fun loadViewFail(msg: String) {

    }
}