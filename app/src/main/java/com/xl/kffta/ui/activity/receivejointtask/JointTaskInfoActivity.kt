package com.xl.kffta.ui.activity.receivejointtask

import android.os.Message
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.adapter.jointtask.JointTaskInfoAdapter
import com.xl.kffta.adapter.jointtask.JointTaskListAdapter
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.CommonFileBean
import com.xl.kffta.model.GetFilepathBean
import com.xl.kffta.model.JointTaskInfoBean
import com.xl.kffta.model.JointTaskInfoItem
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.FilesNetManager
import com.xl.kffta.net.taskmanager.JointTaskManager
import com.xl.kffta.ui.activity.lawcase.LawCaseInfoDetailActivity
import com.xl.kffta.util.ApplicationParams
import com.xl.kffta.util.DialogUtil
import com.xl.kffta.util.SysUtils
import kotlinx.android.synthetic.main.activity_jointinfo.*
import kotlinx.android.synthetic.main.activity_taskinfo_detail.*
import kotlinx.android.synthetic.main.layout_title_bar.*
import org.jetbrains.anko.startActivity

/**
 * @author created by zhanghaochen
 * @date 2020-05-21 14:29
 * 描述：领取或者执行项目检查任务详情
 */
class JointTaskInfoActivity : BaseActivity() {

    companion object {
        const val JOINT_TASK_ID = "jointTaskId"

        // 判断是否已经领取
        const val JOINT_TASK_STATE = "jointTaskState"

        // 区分是领取的详情还是执行时的详情
        const val JOINT_TASK_TYPE = "jointTaskType"
        const val JOINT_TASK_TYPE_RECEIVE = 10
        const val JOINT_TASK_TYPE_EXECUTE = 11

        // 判断领取的任务中，是待执行还是已执行的
        const val JOINT_TASK_EXE_STATE = "jointTaskExeState"
        const val JOINT_TASK_EXE_STATE_PENDING = 14
        const val JOINT_TASK_EXE_STATE_COMPLETE = 15

        const val FILE_ONLY_SHOW = "fileOnlyShow"
    }

    private val HANDLER_REFRESH = 0x501
    private val HANDLER_START_JOINT_TASK_SUCCESS = 0x502

    private var mId = 0
    private var mInfoType = JOINT_TASK_TYPE_RECEIVE
    private var mTaskState = JointTaskListAdapter.TASK_HAS_NOT_TAKE
    private var mExeTaskState = JOINT_TASK_EXE_STATE_COMPLETE

    private var mJointTaskBean: JointTaskInfoBean? = null

    private var mIsFileOnlyShow: Boolean = true

    private val mDatas = ArrayList<JointTaskInfoItem>()
    private val mAdapter by lazy {
        JointTaskInfoAdapter(this, mIsFileOnlyShow)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_jointinfo
    }

    override fun handleMessage(message: Message) {
        when (message.what) {
            HANDLER_REFRESH -> {
                val data = message.obj
                if (data is JointTaskInfoBean) {
                    // 看看有没有files文件上传路径字段，如果是已执行的，可以不用再请求这个字段
                    if (data.data?.files.isNullOrEmpty() && mExeTaskState == JOINT_TASK_EXE_STATE_PENDING) {
                        // 如果没有文件上传路径，需要发送请求，请求文件上传的路径是啥
                        requestFilePath(data)
                    } else {
                        // 已经有文件上传路径，赋值全局的
                        ApplicationParams.TEMP_FILE_PATH = data.data?.files ?: ""

                        initDataItems(data)
                        mJointTaskBean = data
                        mAdapter?.notifyDataChange(mDatas)
                        if (mExeTaskState != JOINT_TASK_EXE_STATE_COMPLETE) {
                            joint_info_bottom_layout.visibility = View.VISIBLE
                        }
                    }
                }
            }
            HANDLER_START_JOINT_TASK_SUCCESS -> {
                finish()
            }
        }
    }

    override fun initParams() {
        mId = intent.getIntExtra(JOINT_TASK_ID, 0)
        mTaskState = intent.getIntExtra(JOINT_TASK_STATE, JointTaskListAdapter.TASK_HAS_NOT_TAKE)
        mInfoType = intent.getIntExtra(JOINT_TASK_TYPE, JOINT_TASK_TYPE_RECEIVE)
        mExeTaskState = intent.getIntExtra(JOINT_TASK_EXE_STATE, JOINT_TASK_EXE_STATE_COMPLETE)
        mIsFileOnlyShow = intent.getBooleanExtra(FILE_ONLY_SHOW, true)
    }

    override fun initViews() {
        title_left.setOnClickListener {
            finish()
        }

        when (mInfoType) {
            JOINT_TASK_TYPE_RECEIVE -> {
                title_name.text = "待领取项目检查任务详情"

                // 根据领取状态显示底部按钮
                if (mTaskState == JointTaskListAdapter.TASK_HAS_TAKE) {
                    joint_info_get.text = "已领取"
                    joint_info_get.isEnabled = false
                    joint_info_back.visibility = View.GONE
                    joint_bottom_empty.visibility = View.GONE
                } else {
                    joint_info_get.text = "领取"
                    joint_info_get.isEnabled = true
                    joint_info_back.visibility = View.VISIBLE
                    joint_bottom_empty.visibility = View.VISIBLE
                }
                joint_info_back.text = "退回"
            }
            JOINT_TASK_TYPE_EXECUTE -> {
                // 执行的任务里，也分未执行和已经执行的了
                title_name.text = "执行项目检查任务详情"
                if (mExeTaskState == JOINT_TASK_EXE_STATE_COMPLETE) {
                    joint_info_bottom_layout.visibility = View.GONE
                } else {
                    joint_info_bottom_layout.visibility = View.VISIBLE
                    joint_info_back.text = "其他执法"
                    joint_info_get.text = "执法完成"
                }
            }
        }

    }

    override fun initListener() {
        joint_info_recycler.layoutManager = object : LinearLayoutManager(this) {
            override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
                try {
                    super.onLayoutChildren(recycler, state)
                } catch (ignored: Exception) {
                }
            }
        }

        joint_info_recycler.adapter = mAdapter

        when (mInfoType) {
            JOINT_TASK_TYPE_RECEIVE -> {
                // 退回任务
                joint_info_back.setOnClickListener {
                    DialogUtil.showCommonDialog(this, "确认退回检查任务", object : DialogUtil.OnDialogOkClick {
                        override fun onDialogOkClick() {
                            JointTaskManager.getOrCancelJointTask(mId.toString(), false, object : ResponseObjectCallback {
                                override fun onError(msg: String) {
                                    myToast(msg)
                                }

                                override fun onSuccess(obj: Any) {
                                    myToast("退回成功")
                                    finish()
                                }

                            })
                        }

                    })
                }
                // 领取任务
                joint_info_get.setOnClickListener {
                    DialogUtil.showCommonDialog(this, "确认领取检查任务", object : DialogUtil.OnDialogOkClick {
                        override fun onDialogOkClick() {
                            JointTaskManager.getOrCancelJointTask(mId.toString(), true, object : ResponseObjectCallback {
                                override fun onError(msg: String) {
                                    myToast(msg)
                                }

                                override fun onSuccess(obj: Any) {
                                    myToast("领取成功")
                                    finish()
                                }

                            })
                        }
                    })
                }
            }
            JOINT_TASK_TYPE_EXECUTE -> {
                joint_info_back.setOnClickListener {
                    // 选择立案或者预警
                    showLawCaseOrWarnDialog()
                }

                joint_info_get.setOnClickListener {
                    // 执行项目检查任务
                    DialogUtil.showCommonDialog(this, "确认完成执行检查任务吗", object : DialogUtil.OnDialogOkClick {
                        override fun onDialogOkClick() {
                            mJointTaskBean?.let { jointTaskInfoBean ->
                                jointTaskInfoBean.data.result = mAdapter.mCheckResult
                                jointTaskInfoBean.data.note = mAdapter.mNote
                                // 时间需要进行特殊处理
                                jointTaskInfoBean.data.checkDate = "/Date(${SysUtils.dateToStamp(mAdapter.mDateSelected)})/"

                                // 如果有附件提交，需要在file加0
                                if (ApplicationParams.TEMP_FILE_PATH.isNotEmpty() && mAdapter.mHasAddFile) {
                                    jointTaskInfoBean.data.files = SysUtils.getAppendAddFilePath(ApplicationParams.TEMP_FILE_PATH)
                                }

                                // 需要完整输入
                                val tipStr = when {
                                    jointTaskInfoBean.data.result.isNullOrEmpty() -> "请输入检查结果"
                                    jointTaskInfoBean.data.note.isNullOrEmpty() -> "请输入备注"
                                    mAdapter.mDateSelected.isEmpty() -> "请选择日期"
                                    else -> ""
                                }
                                if (tipStr.isNotEmpty()) {
                                    DialogUtil.showSingleCommonDialog(context = this@JointTaskInfoActivity, msg = tipStr)
                                } else {
                                    JointTaskManager.updateJointTaskState(jointTaskInfoBean, object : ResponseObjectCallback {
                                        override fun onError(msg: String) {
                                            myToast(msg)
                                        }

                                        override fun onSuccess(obj: Any) {
                                            jointTaskInfoBean.data.acceptStatus = JointTaskManager.AcceptStatusApproved
                                            mHandler.obtainMessage(HANDLER_START_JOINT_TASK_SUCCESS).sendToTarget()
                                            myToast("已完成执行检查任务")
                                        }

                                    })
                                }
                            }

                        }

                    })
                }
            }
        }

    }

    override fun onResume() {
        super.onResume()
        sendRequest()
    }

    /**
     * 把冗余的服务器数据转成可用数据
     */
    private fun initDataItems(infoBean: JointTaskInfoBean) {
        mDatas.clear()
        when (mInfoType) {
            JOINT_TASK_TYPE_RECEIVE -> {
                mDatas.add(JointTaskInfoItem(label = "联合监管检查方案", value = infoBean.data?.govermentJointSupervisionScheme?.name
                        ?: ""))
                mDatas.add(JointTaskInfoItem(label = "部门", value = infoBean.data?.deparment?.name
                        ?: ""))

                // 检查阶段是个数组
                val states = infoBean.data?.govermentProjectRisk
                if (!states.isNullOrEmpty()) {
                    states.forEach {
                        // 可能有多个部门
                        val departments = it.department
                        val departmentsStr = StringBuilder("")
                        if (!departments.isNullOrEmpty()) {
                            departments.forEach { department ->
                                departmentsStr.append(department.name.toString())
                                departmentsStr.append(",")
                            }
                        }
                        if (departmentsStr.length > 2) {
                            // 把最后一个,逗号替换掉
                            departmentsStr.replace(departmentsStr.length - 1, departmentsStr.length, "")
                        }

                        mDatas.add(JointTaskInfoItem(label = "检查阶段", value = it.name, isClickable = true, checkStateName = it.name, deparmentName = departmentsStr.toString(), riskInfo = it.risk))
                    }
                }
            }
            JOINT_TASK_TYPE_EXECUTE -> {
                mDatas.add(JointTaskInfoItem(label = "联合监管检查方案", value = infoBean.data?.govermentJointSupervisionScheme?.name
                        ?: ""))
                mDatas.add(JointTaskInfoItem(label = "部门", value = infoBean.data?.deparment?.name
                        ?: ""))

                // 检查阶段是个数组
                val states = infoBean.data?.govermentProjectRisk
                if (!states.isNullOrEmpty()) {
                    states.forEach {
                        // 可能有多个部门
                        val departments = it.department
                        val departmentsStr = StringBuilder("")
                        if (!departments.isNullOrEmpty()) {
                            departments.forEach { department ->
                                departmentsStr.append(department.name.toString())
                                departmentsStr.append(",")
                            }
                        }
                        if (departmentsStr.length > 2) {
                            // 把最后一个,逗号替换掉
                            departmentsStr.replace(departmentsStr.length - 1, departmentsStr.length, "")
                        }

                        mDatas.add(JointTaskInfoItem(label = "检查阶段", value = it.name, isClickable = true, checkStateName = it.name, deparmentName = departmentsStr.toString(), riskInfo = it.risk))
                    }
                }
                // 执法人
                mDatas.add(JointTaskInfoItem(label = "执法人", value = infoBean.data?.owner?.userName
                        ?: ""))

                // 下面三个在未执行的时候，是可以编辑的
                if (mExeTaskState == JOINT_TASK_EXE_STATE_COMPLETE) {
                    mDatas.add(JointTaskInfoItem(label = "执法时间", value = SysUtils.getDateTimestamp(infoBean.data?.checkDate)))
                    mDatas.add(JointTaskInfoItem(label = "检查结果", value = infoBean.data?.result
                            ?: ""))
                    mDatas.add(JointTaskInfoItem(label = "备注", value = infoBean.data?.note ?: ""))

                    // 已执行的，如果有filepath的id，就请求
                    val ids = SysUtils.getFileIds(infoBean.data?.files)
                    if (!ids.isNullOrEmpty()) {
                        requestFiles(ids)
                    }

                } else {
                    mDatas.add(JointTaskInfoItem(label = "执法时间", isDatePicker = true))
                    mDatas.add(JointTaskInfoItem(label = "检查结果", isEditable = true))
                    mDatas.add(JointTaskInfoItem(label = "备注", isEditable = true))

                    // 等待执行的，不管如何，先清除对应的附件缓存
                    FilesNetManager.emptyTempFolder(ApplicationParams.TEMP_FILE_PATH)
                }
                mDatas.add(JointTaskInfoItem(label = "附件", needUpLoad = true))

            }
        }

    }

    /**
     * 发送请求
     */
    fun sendRequest() {
        JointTaskManager.queryJointTaskById(mId.toString(), object : ResponseObjectCallback {
            override fun onError(msg: String) {
                myToast(msg)
            }

            override fun onSuccess(obj: Any) {
                mHandler.obtainMessage(HANDLER_REFRESH, obj).sendToTarget()
            }

        })
    }

    /**
     * 通过请求获取文件的上传path
     */
    private fun requestFilePath(taskInfoBean: JointTaskInfoBean) {
        FilesNetManager.getUploadFilePath(FilesNetManager.JOINT_TASK_CODENAME, object : ResponseObjectCallback {
            override fun onError(msg: String) {
                myToast("无法获取附件上传路径")
                runOnUiThread {
                    initDataItems(taskInfoBean)
                    mAdapter?.notifyDataChange(mDatas)
                    mJointTaskBean = taskInfoBean
                    task_info_bottom_layout?.visibility = View.VISIBLE
                }
            }

            override fun onSuccess(obj: Any) {
                runOnUiThread {
                    if (obj is GetFilepathBean) {
                        // 赋值这个文件路径
                        ApplicationParams.TEMP_FILE_PATH = obj.data ?: ""

                        initDataItems(taskInfoBean)
                        mAdapter?.notifyDataChange(mDatas)
                        mJointTaskBean = taskInfoBean
                        task_info_bottom_layout?.visibility = View.VISIBLE
                    }
                }
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
                            it.forEachIndexed { index, taskItemInfo ->
                                if (taskItemInfo.label == "附件") {
                                    taskItemInfo.commonFileBean = obj
                                    position = index
                                    return@forEachIndexed
                                }
                            }
                        }
                        if (position > 0) {
                            mAdapter?.notifyItemChanged(position)
                        }
                    }
                }
            }

        })
    }

    /**
     * 显示立案和预警选择框
     */
    private fun showLawCaseOrWarnDialog() {
        DialogUtil.showCaseOrWarnDialog(this, object : DialogUtil.OnLawCaseOrWarnClickListener {
            override fun onLawCaseClick() {
                startActivity<LawCaseInfoDetailActivity>(LawCaseInfoDetailActivity.LAW_CASE_SOURCE to LawCaseInfoDetailActivity.LAW_CASE_FROM_ADD_JOINT_TASK)
            }

            override fun onWarnClick() {

            }

            override fun onCancelClick() {

            }

        })
    }

}
