package com.xl.kffta.ui.activity.receivejointtask

import android.os.Message
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.adapter.JointTaskInfoAdapter
import com.xl.kffta.adapter.JointTaskListAdapter
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.JointTaskInfoBean
import com.xl.kffta.model.JointTaskInfoItem
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.ProjectCheckTaskManager
import com.xl.kffta.util.DialogUtil
import kotlinx.android.synthetic.main.activity_jointinfo.*
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author created by zhanghaochen
 * @date 2020-05-21 14:29
 * 描述：领取项目检查任务详情
 */
class JointTaskInfoActivity : BaseActivity() {

    companion object {
        const val JOINT_TASK_ID = "jointTaskId"
        const val JOINT_TASK_STATE = "jointTaskState"
    }

    private val HANDLER_REFRESH = 0x501

    private var mId = 0
    private var mTaskState = JointTaskListAdapter.TASK_HAS_NOT_TAKE

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
                    mAdapter?.notifyDataChange(mDatas)
                    joint_info_bottom_layout.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun initParams() {
        mId = intent.getIntExtra(JOINT_TASK_ID, 0)
        mTaskState = intent.getIntExtra(JOINT_TASK_STATE, JointTaskListAdapter.TASK_HAS_NOT_TAKE)
    }

    override fun initViews() {
        title_left.setOnClickListener {
            finish()
        }

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

        // 退回任务
        joint_info_back.setOnClickListener {
            DialogUtil.showCommonDialog(this, "确认退回检查任务", object : DialogUtil.OnDialogOkClick {
                override fun onDialogOkClick() {
                    ProjectCheckTaskManager.getOrCancelJointTask(mId.toString(), false, object : ResponseObjectCallback {
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
                    ProjectCheckTaskManager.getOrCancelJointTask(mId.toString(), true, object : ResponseObjectCallback {
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

    override fun onResume() {
        super.onResume()
        sendRequest()
    }

    /**
     * 把冗余的服务器数据转成可用数据
     */
    private fun initDataItems(infoBean: JointTaskInfoBean) {
        mDatas.clear()
        mDatas.add(JointTaskInfoItem(label = "联合监管检查方案", value = infoBean.data?.govermentJointSupervisionScheme?.name
            ?: ""))
        mDatas.add(JointTaskInfoItem(label = "部门", value = infoBean.data?.deparment?.name ?: ""))

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

    /**
     * 发送请求
     */
    fun sendRequest() {
        ProjectCheckTaskManager.queryJointTaskById(mId.toString(), object : ResponseObjectCallback {
            override fun onError(msg: String) {
                myToast(msg)
            }

            override fun onSuccess(obj: Any) {
                mHandler.obtainMessage(HANDLER_REFRESH, obj).sendToTarget()
            }

        })
    }

}
