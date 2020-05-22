package com.xl.kffta.ui.activity.receivejointtask

import android.os.Message
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.adapter.jointtask.JointTaskInfoAdapter
import com.xl.kffta.adapter.jointtask.JointTaskListAdapter
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.JointTaskInfoBean
import com.xl.kffta.model.JointTaskInfoItem
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.JointTaskManager
import com.xl.kffta.util.DialogUtil
import com.xl.kffta.util.SysUtils
import kotlinx.android.synthetic.main.activity_jointinfo.*
import kotlinx.android.synthetic.main.layout_title_bar.*

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
    }

    private val HANDLER_REFRESH = 0x501
    private val HANDLER_START_JOINT_TASK_SUCCESS = 0x502

    private var mId = 0
    private var mInfoType = JOINT_TASK_TYPE_RECEIVE
    private var mTaskState = JointTaskListAdapter.TASK_HAS_NOT_TAKE

    private var mJointTaskBean: JointTaskInfoBean? = null

    private val mDatas = ArrayList<JointTaskInfoItem>()
    private val mAdapter by lazy {
        JointTaskInfoAdapter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_jointinfo
    }

    override fun handleMessage(message: Message) {
        when (message.what) {
            HANDLER_REFRESH -> {
                val data = message.obj
                if (data is JointTaskInfoBean) {
                    initDataItems(data)
                    mJointTaskBean = data
                    mAdapter?.notifyDataChange(mDatas)
                    joint_info_bottom_layout.visibility = View.VISIBLE
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
    }

    override fun initViews() {
        title_left.setOnClickListener {
            finish()
        }

        when (mInfoType) {
            JOINT_TASK_TYPE_RECEIVE -> {
                title_name.text = "领取项目检查任务详情"

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
                title_name.text = "执行项目检查任务详情"
                joint_info_back.text = "其他执法"
                joint_info_get.text = "确认"
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
                    finish()
                }

                joint_info_get.setOnClickListener {
                    // 执行项目检查任务
                    DialogUtil.showCommonDialog(this, "确认执行检查任务", object : DialogUtil.OnDialogOkClick {
                        override fun onDialogOkClick() {
                            mJointTaskBean?.let { jointTaskInfoBean ->
                                jointTaskInfoBean.data.acceptStatus = JointTaskManager.AcceptStatusApproved
                                JointTaskManager.updateJointTaskState(jointTaskInfoBean, object : ResponseObjectCallback {
                                    override fun onError(msg: String) {
                                        myToast(msg)
                                    }

                                    override fun onSuccess(obj: Any) {
                                        mHandler.obtainMessage(HANDLER_START_JOINT_TASK_SUCCESS).sendToTarget()
                                        myToast("已开始执行")
                                    }

                                })
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
                        // todo 这个地方貌似没字段，先用id代替
                        val departments = it.departmentIDs
                        val departmentsStr = StringBuilder("")
                        if (!departments.isNullOrEmpty()) {
                            departments.forEach { departmentId ->
                                departmentsStr.append(departmentId.toString())
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
                        // todo 这个地方貌似没字段，先用id代替
                        val departments = it.departmentIDs
                        val departmentsStr = StringBuilder("")
                        if (!departments.isNullOrEmpty()) {
                            departments.forEach { departmentId ->
                                departmentsStr.append(departmentId.toString())
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
                mDatas.add(JointTaskInfoItem(label = "执法时间", value = SysUtils.getDateTimestamp(infoBean.data?.checkDate)))
                mDatas.add(JointTaskInfoItem(label = "检查结果", value = infoBean.data?.result ?: ""))
                mDatas.add(JointTaskInfoItem(label = "备注", value = infoBean.data?.note ?: ""))
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

}
