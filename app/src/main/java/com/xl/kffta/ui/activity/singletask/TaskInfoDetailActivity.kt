package com.xl.kffta.ui.activity.singletask

import android.os.Message
import android.text.TextUtils
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.xl.kffta.R
import com.xl.kffta.adapter.TaskInfoDetailAdapter
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.model.TaskGetOrCancel
import com.xl.kffta.model.TaskInfoBean
import com.xl.kffta.model.TaskItemInfo
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.net.taskmanager.TaskNetManager
import com.xl.kffta.presenter.impl.TaskInfoDetailImpl
import com.xl.kffta.util.DialogUtil
import com.xl.kffta.util.SysUtils
import com.xl.kffta.view.ITaskInfoDetailView
import com.xl.kffta.viewholder.TakeOderViewHolder
import kotlinx.android.synthetic.main.activity_taskinfo_detail.*
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @author created by zhanghaochen
 * @date 2020-05-19 11:21
 * 描述：任务详情页
 */
class TaskInfoDetailActivity : BaseActivity(), ITaskInfoDetailView {
    companion object {
        const val TASK_ID = "taskId"
        //判断是否已经领取
        const val TASK_GET_STATE = "taskGetState"
        const val HANDLER_REFRESH = 0x101

        const val HANDLER_GET_SUCCESS = 0x102
        const val HANDLER_CANCEL_SUCCESS = 0x103
    }

    private var taskId: Long = 0
    private var taskGetState = 0

    private var mDatas = ArrayList<TaskItemInfo>()

    private val mAdapter by lazy {
        TaskInfoDetailAdapter(this)
    }

    private var mPresenter: TaskInfoDetailImpl? = TaskInfoDetailImpl()
    override fun getLayoutId(): Int {
        return R.layout.activity_taskinfo_detail
    }

    override fun handleMessage(message: Message) {
        when (message.what) {
            HANDLER_REFRESH -> {
                val data = message.obj as TaskInfoBean
                initItemData(data)
                mAdapter?.notifyDataChange(mDatas)
            }
            HANDLER_GET_SUCCESS -> {
                // 领取成功后，更新按钮样式
                task_info_get.isEnabled = false
                task_info_get.text = "已领取"
                task_bottom_empty.visibility = View.GONE
                task_info_back.visibility = View.GONE
            }
        }
    }

    override fun initParams() {
        taskId = intent.getLongExtra(TASK_ID, 0)
        taskGetState = intent.getIntExtra(TASK_GET_STATE, 0)
    }

    override fun initViews() {
        title_left.setOnClickListener {
            finish()
        }
        title_name.text = "任务信息"

        // 根据是否已经领取，搞最下面的按钮
        if (taskGetState == TakeOderViewHolder.GET_TASK_OK) {
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
        task_info_get.setOnClickListener {
            DialogUtil.showCommonDialog(this, "确认领取任务", object : DialogUtil.OnDialogOkClick {
                override fun onDialogOkClick() {
                    TaskNetManager.getOrCancelTask(taskId.toString(), true, object : ResponseCallback {
                        override fun onError(msg: String?) {
                            myToast(msg ?: "领取出错")
                        }

                        override fun onSuccess(jsonString: String) {
                            if (!TextUtils.isEmpty(jsonString)) {
                                // 直接把Json转换成javaBean
                                try {
                                    val taskGetOrCancel: TaskGetOrCancel? = Gson().fromJson(jsonString, TaskGetOrCancel::class.java)
                                    if (taskGetOrCancel == null) {
                                        myToast("解析错误")
                                    } else {
                                        // 获取ErrorCode,<0时错误
                                        if (taskGetOrCancel.errorCode < 0) {
                                            myToast(taskGetOrCancel.error ?: "解析错误")
                                        } else {
                                            // success
                                            mHandler.obtainMessage(HANDLER_GET_SUCCESS).sendToTarget()
                                            myToast("领取成功")
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
            })
        }
        task_info_back.setOnClickListener {
            DialogUtil.showCommonDialog(this, "确认退回任务", object : DialogUtil.OnDialogOkClick {
                override fun onDialogOkClick() {
                    TaskNetManager.getOrCancelTask(taskId.toString(), false, object : ResponseCallback {
                        override fun onError(msg: String?) {
                            myToast(msg ?: "退回出错")
                        }

                        override fun onSuccess(jsonString: String) {
                            if (!TextUtils.isEmpty(jsonString)) {
                                // 直接把Json转换成javaBean
                                try {
                                    val taskGetOrCancel: TaskGetOrCancel? = Gson().fromJson(jsonString, TaskGetOrCancel::class.java)
                                    if (taskGetOrCancel == null) {
                                        myToast("解析错误")
                                    } else {
                                        // 获取ErrorCode,<0时错误
                                        if (taskGetOrCancel.errorCode < 0) {
                                            myToast(taskGetOrCancel.error ?: "解析错误")
                                        } else {
                                            // success
                                            mHandler.obtainMessage(HANDLER_CANCEL_SUCCESS).sendToTarget()
                                            myToast("退回成功")
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
            })
        }
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