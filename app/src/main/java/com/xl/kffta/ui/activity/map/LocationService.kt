package com.xl.kffta.ui.activity.map

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import com.amap.api.maps2d.model.LatLng

import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date

class LocationService : Service() {
    //声明AMapLocationClient类对象
    var mLocationClient: AMapLocationClient? = null
    // 声明AMapLocationClientOption对象
    var mLocationOption: AMapLocationClientOption? = null
    var points: MutableList<LatLng> = ArrayList()

    // 声明定位回调监听器
    var mLocationListener: AMapLocationListener = AMapLocationListener { amapLocation ->
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
        points.add(LatLng(latitude, longitude))
        //时间
        val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = Date(amapLocation.time)
        val time = df.format(date)

        val longitudestr = longitude.toString()
        val latitudestr = latitude.toString()
    }

    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        getPosition()
    }

    fun getPosition() {
        //初始化定位
        mLocationClient = AMapLocationClient(this.applicationContext)
        // 初始化AMapLocationClientOption对象
        mLocationOption = AMapLocationClientOption()
        // 设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption?.locationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption?.interval = 2000
        // 获取一次定位结果： //该方法默认为false。
        mLocationOption?.isOnceLocation = false
        mLocationOption?.isOnceLocationLatest = false
        //给定位客户端对象设置定位参数
        mLocationClient?.setLocationOption(mLocationOption)
        // 设置定位回调监听
        mLocationClient?.setLocationListener(mLocationListener)
        // 启动定位
        mLocationClient?.startLocation()
    }

    companion object {
        private val TAG = "LocationService"
    }

}
