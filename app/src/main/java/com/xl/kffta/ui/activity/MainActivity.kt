package com.xl.kffta.ui.activity

import android.Manifest
import android.content.Intent
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.TextView
import com.afollestad.materialdialogs.DialogCallback
import com.afollestad.materialdialogs.MaterialDialog
import com.xl.kffta.R
import com.xl.kffta.base.App
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.greendao.TaskInfoDao
import com.xl.kffta.model.LocationUploadBean
import com.xl.kffta.model.QueryTaskCountBean
import com.xl.kffta.model.sql.TaskInfo
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.LocationManager
import com.xl.kffta.net.taskmanager.TaskNetManager
import com.xl.kffta.ui.activity.executejointtask.ExecuteJointTaskListActivity
import com.xl.kffta.ui.activity.executetask.ExecuteListActivity
import com.xl.kffta.ui.activity.lawcase.LawcaseListActivity
import com.xl.kffta.ui.activity.legalprocision.LegalProvisonActivity
import com.xl.kffta.ui.activity.receivejointtask.JointTaskListActivity
import com.xl.kffta.ui.activity.receivetask.TakeOrderActivity
import com.xl.kffta.util.DialogUtil
import org.jetbrains.anko.debug
import permissions.dispatcher.*
import kotlin.system.exitProcess

/**
 * @author created by zhanghaochen
 * @date 2020-05-15 16:08
 * 描述：主界面-任务大厅
 */
@RuntimePermissions
class MainActivity : BaseActivity(), View.OnClickListener {
    private var mForceQuit = false

    override val loggerTag: String
        get() = "MainActivity"

    override fun initViews() {
        findViewById<View>(R.id.title_left).visibility = View.GONE
        (findViewById<View>(R.id.title_name) as TextView).text = "智慧执法"
    }

    override fun initListener() {
        findViewById<View>(R.id.main_layout_1).setOnClickListener(this)
        findViewById<View>(R.id.main_layout_2).setOnClickListener(this)
        findViewById<View>(R.id.main_layout_3).setOnClickListener(this)
        findViewById<View>(R.id.main_layout_4).setOnClickListener(this)
        findViewById<View>(R.id.main_layout_5).setOnClickListener(this)
        findViewById<View>(R.id.main_layout_6).setOnClickListener(this)
        findViewById<View>(R.id.main_layout_7).setOnClickListener(this)
        findViewById<View>(R.id.main_layout_8).setOnClickListener(this)
        findViewById<View>(R.id.main_layout_9).setOnClickListener(this)

        // 获取权限
        onlyCheckLocationPermissionWithPermissionCheck()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun handleMessage(message: Message) {
        when (message.what) {
            HANDLER_REFRESH_COUNT -> {
                if (message.obj is QueryTaskCountBean) {
                    val bean = message.obj as QueryTaskCountBean

                    (findViewById<View>(R.id.main_count_1) as TextView).text = bean.pendingClaimedEnforcementTaskCount.toString()
                    (findViewById<View>(R.id.main_count_2) as TextView).text = bean.pendingExcutedEnforcementTaskCount.toString()
                    (findViewById<View>(R.id.main_count_3) as TextView).text = bean.pendingClaimedProjectTaskCount.toString()
                    (findViewById<View>(R.id.main_count_4) as TextView).text = bean.pendingExcutedProjectTaskCount.toString()
                    (findViewById<View>(R.id.main_count_5) as TextView).text = bean.excutedEnforcementTaskCount.toString()
                    (findViewById<View>(R.id.main_count_6) as TextView).text = bean.excutedProjectTaskCount.toString()
                }

                mHandler.removeMessages(HANDLER_REFRESH_COUNT)
            }
            else -> {
            }
        }
    }

    override fun onClick(v: View) {
        val id = v.id
        val intent = Intent()
        when (id) {
            R.id.main_layout_1 -> startActivity(Intent(this@MainActivity, TakeOrderActivity::class.java))
            R.id.main_layout_2 -> {
                // 待执行的
                intent.setClass(this@MainActivity, ExecuteListActivity::class.java)
                intent.putExtra(ExecuteListActivity.EXE_TASK_TYPE, ExecuteListActivity.EXE_TASK_PENDING)
                startActivity(intent)
            }
            R.id.main_layout_3 -> startActivity(Intent(this@MainActivity, JointTaskListActivity::class.java))
            R.id.main_layout_4 -> {
                intent.setClass(this@MainActivity, ExecuteJointTaskListActivity::class.java)
                intent.putExtra(ExecuteJointTaskListActivity.JOINT_EXE_TASK_STATE, ExecuteJointTaskListActivity.JOINT_EXE_TASK_PENDING)
                startActivity(Intent(intent))
            }
            R.id.main_layout_5 -> {
                intent.setClass(this@MainActivity, ExecuteListActivity::class.java)
                intent.putExtra(ExecuteListActivity.EXE_TASK_TYPE, ExecuteListActivity.EXE_TASK_OVER)
                startActivity(intent)
            }
            R.id.main_layout_6 -> {
                intent.setClass(this@MainActivity, ExecuteJointTaskListActivity::class.java)
                intent.putExtra(ExecuteJointTaskListActivity.JOINT_EXE_TASK_STATE, ExecuteJointTaskListActivity.JOINT_EXE_TASK_OVER)
                startActivity(Intent(intent))
            }
            R.id.main_layout_7 -> startActivity(Intent(this@MainActivity, LawcaseListActivity::class.java))
            R.id.main_layout_9 -> {
                // todo 地址上传的测试
                val uploadBean = LocationUploadBean()
                // 先插入一条数据
                try {
                    val taskInfo = TaskInfo()
                    taskInfo.companyId = 10
                    taskInfo.codeName = "CloudEasy.ERP.BL.Model.Government.GovermentEnforcementTask"
                    taskInfo.executeTime = System.currentTimeMillis().toString()
                    taskInfo.excutionStatus = 0
                    taskInfo.pageCode = 0
                    taskInfo.id = 2
                    App.daoSession?.taskInfoDao?.insert(taskInfo)
                } catch (ignored: Exception) {
                }

                // 查询数据库
                val tasks = App.daoSession?.taskInfoDao?.queryBuilder()?.where(TaskInfoDao.Properties.Id.eq(2))?.build()?.list()
                if (!tasks.isNullOrEmpty()) {
                    val task1 = tasks[0]

                    uploadBean.alt = 0.0
//                    uploadBean.companyID =task1.companyId
//                    uploadBean.createTime = task1.executeTime
                    uploadBean.objectCodename = task1.codeName
                    uploadBean.objectID = task1.id.toInt()
                    uploadBean.objectPagecode = 0
                    uploadBean.positionDateTime = System.currentTimeMillis().toString()
                    uploadBean.lat = 0.0
                    uploadBean.lng = 0.0

                    LocationManager.uploadLocationInfo(uploadBean)
                }

            }
            R.id.main_layout_8 -> startActivity(Intent(this@MainActivity, LegalProvisonActivity::class.java))
        }
    }


    override fun onResume() {
        super.onResume()
        sendRequest()
    }

    /**
     * 请求主页几个列表的数量
     */
    private fun sendRequest() {
        TaskNetManager.getMainCount(object : ResponseObjectCallback {
            override fun onError(msg: String) {
                Log.e("zhc", "请求数量失败：$msg")
            }

            override fun onSuccess(obj: Any) {
                mHandler.obtainMessage(HANDLER_REFRESH_COUNT, obj).sendToTarget()
            }
        })
    }

    override fun onBackPressed() {
        DialogUtil.showCommonDialog(this, "确定要退出应用吗", object : DialogUtil.OnDialogOkClick {
            override fun onDialogOkClick() {
                mForceQuit = true
                finish()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mForceQuit) {
            exitProcess(0)
        }
    }

    @NeedsPermission(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
    fun onlyCheckLocationPermission() {
        debug("获取定位权限")
    }

    /**
     * 拒绝一次权限后，再次调用需要权限方法时的后续操作
     */
    @OnShowRationale(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
    fun showWhyForLocation() {
        MaterialDialog(this).show {
            title(text = "系统提示")
            message(text = "获取当前位置需要定位权限")
            positiveButton(text = "确定", click = object : DialogCallback {
                override fun invoke(p1: MaterialDialog) {
                    // 该方法也是自动生成的，用于再次申请权限
                    proceedOnlyCheckLocationPermissionPermissionRequest()
                }

            })
            negativeButton(text = "取消")
        }
    }

    /**
     * 拒绝后立即调用
     */
    @OnPermissionDenied(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
    fun showLocationDenied() {
        MaterialDialog(this).show {
            title(text = "系统提示")
            message(text = "您已拒绝定位授权，将无定位功能")
            positiveButton(text = "确定")
        }
    }

    /**
     * 点击了始终禁止权限后，调用权限相关方法时的后续提示
     */
    @OnNeverAskAgain(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
    fun showNeverAskAgain() {
        MaterialDialog(this).show {
            title(text = "权限设置提示")
            message(text = "应用权限被拒绝,为了不影响您的正常使用，请在 权限 中开启对应权限")
            positiveButton(text = "确定")
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        onRequestPermissionsResult(requestCode, grantResults)
    }

    companion object {

        private val HANDLER_REFRESH_COUNT = 0x801
    }
}
