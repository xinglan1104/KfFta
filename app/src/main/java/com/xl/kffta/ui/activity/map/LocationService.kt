package com.xl.kffta.ui.activity.map

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import com.xl.kffta.R
import com.xl.kffta.base.App
import com.xl.kffta.greendao.TaskInfoDao
import com.xl.kffta.model.LocationUploadBean
import com.xl.kffta.model.sql.TaskInfo
import com.xl.kffta.net.taskmanager.LocationManager
import com.xl.kffta.ui.activity.MainActivity
import com.xl.kffta.util.ApplicationParams
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit


class LocationService : Service() {
    companion object {
        private val TAG = "LocationService"
    }

    //声明AMapLocationClient类对象
    var mLocationClient: AMapLocationClient? = null

    // 声明AMapLocationClientOption对象
    var mLocationOption: AMapLocationClientOption? = null

    //定时任务
    var executorService: ScheduledExecutorService = Executors.newScheduledThreadPool(1)

    var mTaskList: MutableList<TaskInfo>? = null
    var CHANNEL_ID = "com.example.recyclerviewtest.N1"
    var CHANNEL_NAME = "TEST"
    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            var notificationChannel: NotificationChannel? = null
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH)
                var notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(notificationChannel);
            }
            var intent = Intent(this, MainActivity::class.java)
            var pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

            var notification = NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle("定位中").setContentText("").setWhen(System.currentTimeMillis()).setSmallIcon(R.mipmap.icon_app_logo).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)).setContentIntent(pendingIntent).build();
            startForeground(1, notification);
        }
        initLocation()
        executorService.scheduleAtFixedRate(executors, 0, 10, TimeUnit.SECONDS);
    }

    var executors: Runnable = Runnable {
        if (ApplicationParams.TOKEN.isEmpty()) {
            stopSelf()
        } else {
            queryTaskList()
        }
    }

    fun queryTaskList() {
        // 查询数据库
        mTaskList = App.daoSession?.taskInfoDao?.queryBuilder()?.where(TaskInfoDao.Properties.ExcutionStatus.eq(0), TaskInfoDao.Properties.Token.eq(ApplicationParams.TOKEN))?.build()?.list()
        Log.i(TAG, "tasks.size==" + mTaskList?.size)
        if (!mTaskList.isNullOrEmpty()) {
            getPosition()
        }
    }

    fun initLocation() {
        //初始化定位
        mLocationClient = AMapLocationClient(this.applicationContext)
        // 初始化AMapLocationClientOption对象
        mLocationOption = AMapLocationClientOption()
        // 设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption?.locationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
        // 获取一次定位结果： //该方法默认为false。
        mLocationOption?.isOnceLocation = true
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption?.setMockEnable(false)
        //给定位客户端对象设置定位参数
        mLocationClient?.setLocationOption(mLocationOption)
        // 设置定位回调监听
        mLocationClient?.setLocationListener(mLocationListener)
    }

    fun getPosition() {
        // 启动定位
        mLocationClient?.startLocation()
    }

    // 声明定位回调监听器
    var mLocationListener: AMapLocationListener = AMapLocationListener { amapLocation ->
        mLocationClient?.stopLocation()
        if (amapLocation == null) {
            Log.i(TAG, "amapLocation is null!")
            return@AMapLocationListener
        }
        if (amapLocation.errorCode != 0) {
            Log.i(TAG, "amapLocation has exception errorCode:" + amapLocation.errorCode + ", errInfo:"
                    + amapLocation.errorInfo)
            return@AMapLocationListener
        }
        val longitude = amapLocation.longitude//获取经度
        val latitude = amapLocation.latitude//获取纬度
        upLoadLocation(latitude, longitude)
    }

    fun upLoadLocation(latitude: Double, longitude: Double) {
        mTaskList?.forEach { taskinfo ->
            var uploadBean: LocationUploadBean = LocationUploadBean()
            uploadBean.alt = 0.0
            uploadBean.objectCodename = taskinfo.codeName
            uploadBean.objectID = taskinfo.objectId.toInt()
            uploadBean.objectPagecode = 0
            uploadBean.positionDateTime = "/Date(${System.currentTimeMillis()})/"
            uploadBean.lat = latitude
            uploadBean.lng = longitude
            LocationManager.uploadLocationInfo(uploadBean)

        }
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy")
        executorService.shutdownNow()
        mLocationClient?.stopLocation()
        super.onDestroy()
    }
}
