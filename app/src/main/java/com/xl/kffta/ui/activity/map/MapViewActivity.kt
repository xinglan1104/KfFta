package com.xl.kffta.ui.activity.map

import android.graphics.Color
import android.os.Bundle
import android.os.Message
import android.text.TextUtils
import android.util.Log
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import com.amap.api.maps2d.AMap
import com.amap.api.maps2d.CameraUpdateFactory
import com.amap.api.maps2d.UiSettings
import com.amap.api.maps2d.model.*
import com.amap.api.services.geocoder.*
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import kotlinx.android.synthetic.main.layout_title_bar.*
import kotlinx.android.synthetic.main.mapview_layout.*


class MapViewActivity : BaseActivity() {

    private var aMap: AMap? = null

    private var myLocationStyle: MyLocationStyle? = null

    //声明AMapLocationClient类对象
    private var mLocationClient: AMapLocationClient? = null

    //声明AMapLocationClientOption对象
    private var mLocationOption: AMapLocationClientOption? = null
    private var address: String = ""
    override fun getLayoutId(): Int {
        return R.layout.mapview_layout;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        map_view.onCreate(savedInstanceState);
    }

    override fun initData() {
        super.initData()
        address = intent.getStringExtra("ADDRESS")
        if (!TextUtils.isEmpty(address)) {
            getLocation(address)
        } else {
            startLocation()
        }
    }

    override fun initViews() {
        super.initViews()
        title_name.text = "地图"
        title_left.setOnClickListener { finish() }
        aMap = map_view?.map
        //设置显示定位按钮 并且可以点击
        val settings: UiSettings = aMap!!.getUiSettings()
        // 是否显示定位按钮
        settings.isMyLocationButtonEnabled = true
    }

    fun startLocation() {
        // 是否可触发定位并显示定位层
        aMap!!.setMyLocationEnabled(true)
        myLocationStyle = MyLocationStyle() //初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。

        myLocationStyle!!.myLocationIcon(BitmapDescriptorFactory.fromResource(R.drawable.navi_map_gps_locked)) // 设置小蓝点的图标
        myLocationStyle!!.strokeColor(Color.argb(0, 0, 0, 0));// 设置圆形的边框颜色
        myLocationStyle!!.radiusFillColor(Color.argb(0, 0, 0, 0));// 设置圆形的填充颜色

        aMap!!.setMyLocationStyle(myLocationStyle) //设置定位蓝点的Style
        aMap!!.moveCamera(CameraUpdateFactory.zoomTo(18f))
        //初始化定位
        mLocationClient = AMapLocationClient(applicationContext)
        //设置定位回调监听
        mLocationClient!!.setLocationListener(mLocationListener)
        //初始化AMapLocationClientOption对象
        mLocationOption = AMapLocationClientOption()
        // 设置定位一次
        mLocationOption!!.setOnceLocation(true)
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption!!.setMockEnable(false)
        mLocationClient!!.setLocationOption(mLocationOption)
        mLocationClient!!.startLocation()
    }

    var mLocationListener = AMapLocationListener { amapLocation ->
        if (amapLocation != null) {
            if (amapLocation.errorCode == 0) {
                Log.d("MapViewActivity", "amapLocation.getLan==" + amapLocation.latitude + ",amapLocation.getLon==" + amapLocation.longitude)
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("MapViewActivity", "location Error, ErrCode:"
                        + amapLocation.errorCode + ", errInfo:"
                        + amapLocation.errorInfo)
            }
        }
    }

    fun getLocation(address: String) {
        var geocodeSearch = GeocodeSearch(this);
        geocodeSearch.setOnGeocodeSearchListener(object : GeocodeSearch.OnGeocodeSearchListener {
            override fun onRegeocodeSearched(regeocodeResult: RegeocodeResult?, i: Int) {}
            override fun onGeocodeSearched(geocodeResult: GeocodeResult?, i: Int) {
                if (i == 1000) {
                    if (geocodeResult != null && geocodeResult.getGeocodeAddressList() != null && geocodeResult.getGeocodeAddressList().size > 0) {
                        val geocodeAddress: GeocodeAddress = geocodeResult.getGeocodeAddressList().get(0)
                        val latitude: Double = geocodeAddress.getLatLonPoint().getLatitude() //纬度
                        val longititude: Double = geocodeAddress.getLatLonPoint().getLongitude() //经度
                        val cameraPosition = CameraPosition(LatLng(latitude, longititude), 18f, 0f, 0f)
                        val cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)
                        aMap!!.moveCamera(cameraUpdate)
                        drawMarkers(latitude, longititude)
                    }
                }
            }
        })

        var geocodeQuery = GeocodeQuery(address, "");
        geocodeSearch.getFromLocationNameAsyn(geocodeQuery);
    }

    //画定位标记图
    private fun drawMarkers(latitude: Double, longitude: Double) {
        val markerOptions = MarkerOptions()
                .position(LatLng(latitude, longitude))
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.address_poi))
                .draggable(true)
        val marker: Marker = aMap!!.addMarker(markerOptions)
        marker.showInfoWindow()
    }

    override fun handleMessage(message: Message) {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        map_view.onDestroy()
        mLocationClient!!.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        map_view.onResume()
    }

    override fun onPause() {
        super.onPause()
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        map_view.onPause()
    }

}