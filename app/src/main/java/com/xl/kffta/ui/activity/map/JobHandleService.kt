package com.xl.kffta.ui.activity.map

import android.app.ActivityManager
import android.app.job.JobInfo
import android.content.ComponentName
import android.app.job.JobScheduler
import android.app.job.JobParameters
import android.content.Intent
import android.app.job.JobService
import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import kotlinx.coroutines.newFixedThreadPoolContext


@SuppressLint("NewApi")
class JobHandleService : JobService() {
    private val TAG = "JobHandleService"
    private var kJobId = 10
    private var locationService:Intent?=null
    //间隔时间--周期
    val jobInfo: JobInfo
        get() {
            val builder = JobInfo.Builder(kJobId, ComponentName(this, JobHandleService::class.java))
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            builder.setPersisted(true)
            builder.setRequiresCharging(false)
            builder.setRequiresDeviceIdle(false)
            //小于7.0
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                // 每隔1s 执行一次 job
                builder.setPeriodic(10000)
            } else {
                //延迟执行任务
                builder.setMinimumLatency(0)
                builder.setOverrideDeadline(0);
            }
            return builder.build()
        }

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "jobService create")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.i(TAG, "jobService start")
        // 在服务启动时，直接将任务推到JobScheduler 的任务队列,然后在设定的时间条件到达时，便会直接吊起我们的服务，走onStartJob()方法
        scheduleJob(jobInfo)
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        Log.i(TAG,"onDestroy")
        stopService(locationService)
        super.onDestroy()
    }

    override fun onStartJob(params: JobParameters): Boolean {
        val isLocalServiceWork = isServiceWork("com.xl.kffta.ui.activity.map.LocationService")
        Log.i(TAG, "isRunning==" + isLocalServiceWork)
        if (locationService == null) {
            locationService = Intent(this, LocationService::class.java)
        }
        if (!isLocalServiceWork) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(locationService)
            } else {
                startService(locationService)
            }
        }
        jobFinished(params, true)
        return true
    }

    override fun onStopJob(params: JobParameters): Boolean {
        Log.i(TAG, "job stop")
        // 当执行完毕时，我们再将任务加入到 JobScheduler 里面就可以了。
        scheduleJob(jobInfo)
        jobFinished(params, true)
        return true
    }

    /**
     * Send job to the JobScheduler.
     */
    fun scheduleJob(t: JobInfo) {
        Log.i(TAG, "Scheduling job")
        val tm = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        tm?.schedule(t)
    }

    /**
     * 判断某个服务是否正在运行的方法
     *
     * @param mContext
     * @param serviceName 是包名+服务的类名（例如：net.loonggg.testbackstage.TestService）
     * @return true代表正在运行，false代表服务没有正在运行
     */
    fun isServiceWork(serviceName: String): Boolean {
        var isWork = false
        val myAM = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        var myList: List<ActivityManager.RunningServiceInfo>? = null
        if (myAM != null) {
            myList = myAM.getRunningServices(100)
        }
        if (myList != null && myList.size <= 0) {
            return false
        }
        if (myList != null) {
            for (i in myList.indices) {
                val mName = myList[i].service.getClassName()
                if (mName == serviceName) {
                    isWork = true
                    break
                }
            }
        }
        return isWork
    }
}