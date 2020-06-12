package com.xl.kffta.ui.activity.receivetask

import android.os.Message
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.adapter.task.TaskInfoDetailAdapter
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.GetFilepathBean
import com.xl.kffta.model.TaskInfoBean
import com.xl.kffta.model.TaskItemInfo
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.FilesNetManager
import com.xl.kffta.net.taskmanager.LocationManager
import com.xl.kffta.net.taskmanager.TaskNetManager
import com.xl.kffta.presenter.impl.TaskInfoDetailImpl
import com.xl.kffta.ui.activity.lawcase.LawCaseInfoDetailActivity
import com.xl.kffta.util.ApplicationParams
import com.xl.kffta.util.DialogUtil
import com.xl.kffta.util.SysUtils
import com.xl.kffta.view.ITaskInfoDetailView
import kotlinx.android.synthetic.main.activity_taskinfo_detail.*
import kotlinx.android.synthetic.main.layout_title_bar.*
import org.jetbrains.anko.startActivity

/**
 * @author created by zhanghaochen
 * @date 2020-05-19 11:21
 * 描述：任务详情页
 */
class TaskInfoDetailActivity : BaseActivity(), ITaskInfoDetailView {
    companion object {
        /**
         * 任务信息详情页
         */
        const val TYPE_RECEIVE_TASK = 10

        /**
         * 执行任务信息的详情页
         */
        const val TYPE_EXECUTE_TASK = 11

        const val INFO_TYPE = "infoType"
        const val TASK_ID = "taskId"
        const val FILE_ONLY_SHOW = "fileOnlyShow"

        //判断是否已经领取
        const val TASK_GET_STATE = "taskGetState"
        const val GET_TASK_OK = 1
        const val GET_TASK_HAVE_NOT = 2


        const val HANDLER_REFRESH = 0x101

        // 判断是否执行
        const val TASK_EXE_STATE = "taskExeState"
        const val TASK_EXE_STATE_PENDING = 5
        const val TASK_EXE_STATE_OVER = 6

        const val HANDLER_GET_SUCCESS = 0x102
        const val HANDLER_CANCEL_SUCCESS = 0x103
        const val HANDLER_START_SUCCESS = 0x104
    }

    private var taskId: Long = 0
    private var taskGetState = 0
    private var mTaskExeState = 0

    // 区分显示的内容
    private var mInfoType = 10

    private var mIsFileOnlyShow: Boolean = true

    private var mDatas = ArrayList<TaskItemInfo>()

    private val mAdapter by lazy {
        TaskInfoDetailAdapter(this, mIsFileOnlyShow)
    }

    private var mTaskInfoBean: TaskInfoBean? = null

    private var mPresenter: TaskInfoDetailImpl? = TaskInfoDetailImpl()
    override fun getLayoutId(): Int {
        return R.layout.activity_taskinfo_detail
    }

    override fun handleMessage(message: Message) {
        when (message.what) {
            HANDLER_REFRESH -> {
                val data = message.obj
                if (data is TaskInfoBean && data.data != null) {
                    // 看看有没有files文件上传路径字段，如果是已执行的，可以不用再请求这个字段
                    if (data.data.files.isNullOrEmpty() && mTaskExeState == TASK_EXE_STATE_PENDING) {
                        // 如果没有文件上传路径，需要发送请求，请求文件上传的路径是啥
                        requestFilePath(data)
                    } else {
                        // 已经有文件上传路径，赋值全局的
                        ApplicationParams.TEMP_FILE_PATH = data.data.files ?: ""

                        initItemData(data)
                        mAdapter?.notifyDataChange(mDatas)
                        mTaskInfoBean = data
                        task_info_bottom_layout?.visibility = View.VISIBLE
                    }
                }
            }
            HANDLER_GET_SUCCESS -> {
                // 领取成功后，更新按钮样式
                task_info_get.isEnabled = false
                task_info_get.text = "已领取"
                task_bottom_empty.visibility = View.GONE
                task_info_back.visibility = View.GONE
            }
            HANDLER_START_SUCCESS -> {
                // 完成执法
                LocationManager.finishOrCancelTask(taskId, FilesNetManager.TASK_CODENAME)
                finish()
            }
        }
    }

    override fun initParams() {
        taskId = intent.getLongExtra(TASK_ID, 0)
        taskGetState = intent.getIntExtra(TASK_GET_STATE, 0)
        mTaskExeState = intent.getIntExtra(TASK_EXE_STATE, 0)
        mInfoType = intent.getIntExtra(INFO_TYPE, 0)
        mIsFileOnlyShow = intent.getBooleanExtra(FILE_ONLY_SHOW, true)

    }

    override fun initViews() {
        title_left.setOnClickListener {
            finish()
        }

        when (mInfoType) {
            TYPE_RECEIVE_TASK -> {
                title_name.text = "任务信息"
                task_info_get.text = "领取"
                task_info_back.text = "退回"

                // 根据是否已经领取，搞最下面的按钮
                if (taskGetState == GET_TASK_OK) {
                    // 已领取
                    task_info_get.isEnabled = false
                    task_info_get.text = "已领取"
                    task_bottom_empty.visibility = View.GONE
                    task_info_back.visibility = View.GONE
                } else {
                    task_info_get.isEnabled = true
                    task_info_get.text = "领取"
                    task_bottom_empty.visibility = View.VISIBLE
                    task_info_back.visibility = View.VISIBLE
                }
            }
            TYPE_EXECUTE_TASK -> {
                title_name.text = "执法任务信息"
                task_info_get.text = "确认"
                task_info_back.text = "其他执法"
                // 根据是否执行了，搞下面的按钮
                if (mTaskExeState == TASK_EXE_STATE_OVER) {
                    // 已领取
                    task_info_get.isEnabled = false
                    task_info_get.text = "已执行"
                    task_bottom_empty.visibility = View.GONE
                    task_info_back.visibility = View.GONE
                } else {
                    task_info_get.isEnabled = true
                    task_info_get.text = "执法完成"
                    task_bottom_empty.visibility = View.VISIBLE
                    task_info_back.visibility = View.VISIBLE
                }
            }
        }

    }

    override fun initListener() {
        task_info_recycler.layoutManager = object : LinearLayoutManager(this) {
            override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
                try {
                    super.onLayoutChildren(recycler, state)
                } catch (ignored: Exception) {
                }
            }
        }
        task_info_recycler.adapter = mAdapter

        // 下面两个按钮
        when (mInfoType) {
            TYPE_RECEIVE_TASK -> {
                task_info_get.setOnClickListener {
                    DialogUtil.showCommonDialog(this, "确认领取任务", object : DialogUtil.OnDialogOkClick {
                        override fun onDialogOkClick() {
                            TaskNetManager.getOrCancelTask(taskId.toString(), true, object : ResponseObjectCallback {
                                override fun onError(msg: String) {
                                    myToast(msg)
                                }

                                override fun onSuccess(obj: Any) {
                                    mHandler.obtainMessage(HANDLER_GET_SUCCESS).sendToTarget()
                                    myToast("领取成功")
                                }

                            })
                        }
                    })
                }
                task_info_back.setOnClickListener {
                    DialogUtil.showCommonDialog(this, "确认退回任务", object : DialogUtil.OnDialogOkClick {
                        override fun onDialogOkClick() {
                            TaskNetManager.getOrCancelTask(taskId.toString(), false, object : ResponseObjectCallback {
                                override fun onError(msg: String) {
                                    myToast(msg)
                                }

                                override fun onSuccess(obj: Any) {
                                    mHandler.obtainMessage(HANDLER_CANCEL_SUCCESS).sendToTarget()
                                    myToast("退回成功")
                                }

                            })
                        }
                    })
                }
            }
            TYPE_EXECUTE_TASK -> {
                task_info_get.setOnClickListener { _ ->
                    // 确认执行任务
                    DialogUtil.showCommonDialog(this, "确认完成执法吗", object : DialogUtil.OnDialogOkClick {
                        override fun onDialogOkClick() {
                            mTaskInfoBean?.let { taskInfoBean ->
                                // 执行时，这些东西需要变化
                                taskInfoBean.data.result = mAdapter.mCheckResult
                                taskInfoBean.data.note = mAdapter.mNote
                                // 时间需要进行转换
                                taskInfoBean.data.excuteTime = "/Date(${SysUtils.dateToStamp(mAdapter.mDateSelected)})/"
                                // 如果有附件提交，需要在file加0
                                if (ApplicationParams.TEMP_FILE_PATH.isNotEmpty() && mAdapter.mHasUpLoadFile) {
                                    taskInfoBean.data.files = SysUtils.getAppendAddFilePath(ApplicationParams.TEMP_FILE_PATH)
                                }

                                // 需要完整输入
                                val tipStr = when {
                                    taskInfoBean.data.result.isNullOrEmpty() -> "请输入检查结果"
                                    taskInfoBean.data.note.isNullOrEmpty() -> "请输入备注"
                                    mAdapter.mDateSelected.isEmpty() -> "请选择日期"
                                    else -> ""
                                }

                                if (tipStr.isNotEmpty()) {
                                    DialogUtil.showSingleCommonDialog(context = this@TaskInfoDetailActivity, msg = tipStr)
                                } else {
                                    // 都输入完了，就执行
                                    taskInfoBean.data.excutionStatus = TaskNetManager.TASK_EXCUTIONSTATUS_APPROVED
                                    TaskNetManager.updateTaskState(taskInfoBean, object : ResponseObjectCallback {
                                        override fun onError(msg: String) {
                                            myToast(msg)
                                        }

                                        override fun onSuccess(obj: Any) {
                                            mHandler.obtainMessage(HANDLER_START_SUCCESS).sendToTarget()
                                            myToast("已完成执法")
                                        }

                                    })
                                }

                            }
                        }
                    })
                }
                task_info_back.setOnClickListener {
                    // 选择其他执法方式
                    showLawCaseOrWarnDialog()
                }
            }
        }

    }

    override fun initData() {
        mPresenter?.queryTaskById(taskId.toString())
    }

    private fun initItemData(taskInfoBean: TaskInfoBean) {
        // 清空数据
        mDatas.clear()
        when (mInfoType) {
            TYPE_RECEIVE_TASK -> {
                mDatas.add(TaskItemInfo("企业名称", taskInfoBean.data?.business?.businessName
                        ?: "", isTitle = false, isCheckList = false,
                        isBusinessTv = true,
                        businessCode = taskInfoBean.data?.business?.businessLicenseRegistrationNumber
                                ?: "",
                        businessPeople = taskInfoBean.data?.business?.representative
                                ?: "",
                        businessCreateTime = taskInfoBean.data?.business?.businessRegistrationTime
                                ?: ""))
                mDatas.add(TaskItemInfo("经营场所", taskInfoBean.data?.business?.dom
                        ?: "", isTitle = false, isCheckList = false, isLocationAble = true))
                mDatas.add(TaskItemInfo("抽取方案", taskInfoBean.data?.govermentEnforcementScheme?.name
                        ?: "", isTitle = false, isCheckList = false))
                // 执法人可能有多个
                val peoples = taskInfoBean.data?.pendingOwner
                val peoplesStr = StringBuilder("")
                peoples?.forEach {
                    peoplesStr.append(SysUtils.getSafeString(it.userName))
                    peoplesStr.append("  ")
                }
                mDatas.add(TaskItemInfo("待接收执法人", peoplesStr.toString(), isTitle = false, isCheckList = false))

                mDatas.add(TaskItemInfo("执法人数", taskInfoBean.data?.requiredQuantity.toString(), isTitle = false, isCheckList = false))
                mDatas.add(TaskItemInfo("执法开始时间", SysUtils.getDateTimestamp(taskInfoBean.data?.startDate)
                        ?: "", isTitle = false, isCheckList = false))
                mDatas.add(TaskItemInfo("执法截止时间", SysUtils.getDateTimestamp(taskInfoBean.data?.endDate)
                        ?: "", isTitle = false, isCheckList = false))
                mDatas.add(TaskItemInfo("创建时间", SysUtils.getDateTimestamp(taskInfoBean.data?.createTime)
                        ?: "", isTitle = false, isCheckList = false))

                val checkList = taskInfoBean.data?.checkList
                if (!checkList.isNullOrEmpty()) {
                    mDatas.add(TaskItemInfo("事项清单", "", isTitle = true, isCheckList = false))
                    checkList.forEach {
                        mDatas.add(TaskItemInfo("事件清单", it.name
                                ?: "", isTitle = false, isCheckList = true, checkListId = it.id))
                    }
                }
            }
            TYPE_EXECUTE_TASK -> {
                mDatas.add(TaskItemInfo(label = "企业名称", value = taskInfoBean.data?.business?.businessName
                        ?: "",
                        isBusinessTv = true,
                        businessCode = taskInfoBean.data?.business?.businessLicenseRegistrationNumber
                                ?: "",
                        businessPeople = taskInfoBean.data?.business?.representative
                                ?: "",
                        businessCreateTime = taskInfoBean.data?.business?.businessRegistrationTime
                                ?: ""))
                mDatas.add(TaskItemInfo(label = "经营场所", value = taskInfoBean.data?.business?.dom
                        ?: "", isLocationAble = true))
                // 执法人可能有多个
                val owners = taskInfoBean.data?.owner
                val ownerStr = StringBuilder("")
                owners?.forEach {
                    ownerStr.append(SysUtils.getSafeString(it.userName))
                    ownerStr.append("  ")
                }
                mDatas.add(TaskItemInfo(label = "执法人", value = ownerStr.toString()))

                // 下面三个选项，待执行是可以编辑的
                if (mTaskExeState == TASK_EXE_STATE_OVER) {
                    // 执行完成
                    mDatas.add(TaskItemInfo(label = "执法时间", value = SysUtils.getDateTimestamp(taskInfoBean.data?.excuteTime)))
                    mDatas.add(TaskItemInfo(label = "检查结果", value = taskInfoBean.data?.result
                            ?: ""))
                    mDatas.add(TaskItemInfo(label = "备注", value = taskInfoBean.data?.note ?: ""))
                    mDatas.add(TaskItemInfo(label = "附件", needUpLoadFile = true, upLoadFileEnable = false))

                    // 已执行的，如果有filepath的id，就请求
                    val ids = SysUtils.getFileIds(taskInfoBean.data?.files)
                    if (!ids.isNullOrEmpty()) {
                        requestFiles(ids)
                    }
                } else {
                    // 待执行
                    mDatas.add(TaskItemInfo(label = "执法时间", isDatePicker = true))
                    mDatas.add(TaskItemInfo(label = "检查结果", isEditable = true))
                    mDatas.add(TaskItemInfo(label = "备注", isEditable = true))
                    mDatas.add(TaskItemInfo(label = "附件", needUpLoadFile = true, upLoadFileEnable = true))

                    // 等待执行的，不管如何，先清除对应的附件缓存
                    FilesNetManager.emptyTempFolder(ApplicationParams.TEMP_FILE_PATH)
                }

                val checkList = taskInfoBean.data?.checkList
                if (!checkList.isNullOrEmpty()) {
                    mDatas.add(TaskItemInfo("事项清单", "", isTitle = true, isCheckList = false))
                    checkList.forEach {
                        mDatas.add(TaskItemInfo("事件清单", it.name
                                ?: "", isTitle = false, isCheckList = true, checkListId = it.id))
                    }
                }
            }
        }

    }

    /**
     * 通过请求获取文件的上传path
     */
    private fun requestFilePath(taskInfoBean: TaskInfoBean) {
        FilesNetManager.getUploadFilePath(FilesNetManager.TASK_CODENAME, object : ResponseObjectCallback {
            override fun onError(msg: String) {
                myToast("无法获取附件上传路径")
                runOnUiThread {
                    initItemData(taskInfoBean)
                    mAdapter?.notifyDataChange(mDatas)
                    mTaskInfoBean = taskInfoBean
                    task_info_bottom_layout?.visibility = View.VISIBLE
                }
            }

            override fun onSuccess(obj: Any) {
                runOnUiThread {
                    if (obj is GetFilepathBean) {
                        // 赋值这个文件路径
                        ApplicationParams.TEMP_FILE_PATH = obj.data ?: ""

                        initItemData(taskInfoBean)
                        mAdapter?.notifyDataChange(mDatas)
                        mTaskInfoBean = taskInfoBean
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
        FilesNetManager.getFileUrls(ids, object : ResponseObjectCallback {
            override fun onError(msg: String) {

            }

            override fun onSuccess(obj: Any) {
                if (obj is ArrayList<*>) {
                    runOnUiThread {
                        var position = 0
                        mDatas?.let {
                            it.forEachIndexed { index, taskItemInfo ->
                                if (taskItemInfo.label == "附件") {
                                    taskItemInfo.urls = obj as ArrayList<String>
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

    /**
     * 显示立案和预警选择框
     */
    private fun showLawCaseOrWarnDialog() {
        DialogUtil.showCaseOrWarnDialog(this, object : DialogUtil.OnLawCaseOrWarnClickListener {
            override fun onLawCaseClick() {
                startActivity<LawCaseInfoDetailActivity>(LawCaseInfoDetailActivity.LAW_CASE_SOURCE to LawCaseInfoDetailActivity.LAW_CASE_FROM_ADD_NORMAL_TASK,
                        LawCaseInfoDetailActivity.ADD_TASK_LAW to mTaskInfoBean)
            }

            override fun onWarnClick() {

            }

            override fun onCancelClick() {

            }

        })
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
        myToast(msg)
    }

}