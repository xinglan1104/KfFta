package com.xl.kffta.ui.activity.map

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.afollestad.materialdialogs.DialogCallback
import com.afollestad.materialdialogs.MaterialDialog
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
import org.jetbrains.anko.debug
import permissions.dispatcher.*

@RuntimePermissions
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class MapViewActivity : BaseActivity() {

    private var aMap: AMap? = null

//    private var myLocationStyle: MyLocationStyle? = null

    //声明AMapLocationClient类对象
    private var mLocationClient: AMapLocationClient? = null

    //声明AMapLocationClientOption对象
    private var mLocationOption: AMapLocationClientOption? = null
    private var address: String = ""
    private var currentAddress: String = ""
    private var startLat: Double = 0.0
    private var startLon: Double = 0.0
    private var endLat: Double = 0.0
    private var endLon: Double = 0.0
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
        onlyCheckLocationPermissionWithPermissionCheck()
    }

    override fun initViews() {
        super.initViews()
        title_name.text = "地图"
        title_left.setOnClickListener { finish() }
        go_btn.setOnClickListener { showDialog() }
        aMap = map_view?.map
        //设置显示定位按钮 并且可以点击
        val settings: UiSettings? = aMap?.uiSettings
        // 是否显示定位按钮
        settings?.isMyLocationButtonEnabled = true
        //禁止缩放
        settings?.setZoomGesturesEnabled(false)
        //禁止滑动手势
        settings?.setScrollGesturesEnabled(false)
    }

    @NeedsPermission(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
    fun onlyCheckLocationPermission() {
        debug("获取定位权限")
        if (!TextUtils.isEmpty(address)) {
            getLocation(address)
        }
        startLocation()
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

    fun startLocation() {
        // 是否可触发定位并显示定位层
        aMap?.setMyLocationEnabled(false)
//        myLocationStyle = MyLocationStyle() //初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
//        myLocationStyle?.myLocationIcon(BitmapDescriptorFactory.fromResource(R.drawable.navi_map_gps_locked)) // 设置小蓝点的图标
//        myLocationStyle?.strokeColor(Color.argb(0, 0, 0, 0));// 设置圆形的边框颜色
//        myLocationStyle?.radiusFillColor(Color.argb(0, 0, 0, 0));// 设置圆形的填充颜色
//        aMap?.setMyLocationStyle(myLocationStyle) //设置定位蓝点的Style
        //初始化定位
        mLocationClient = AMapLocationClient(applicationContext)
        //设置定位回调监听
        mLocationClient?.setLocationListener(mLocationListener)
        //初始化AMapLocationClientOption对象
        mLocationOption = AMapLocationClientOption()
        // 设置定位一次
        mLocationOption?.setOnceLocation(true)
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption?.setMockEnable(false)
        mLocationClient?.setLocationOption(mLocationOption)
        mLocationClient?.startLocation()
    }

    var mLocationListener = AMapLocationListener { amapLocation ->
        if (amapLocation != null) {
            if (amapLocation.errorCode == 0) {
                Log.d("MapViewActivity", "amapLocation.getLan==" + amapLocation.latitude + ",amapLocation.getLon==" + amapLocation.longitude)
                startLat = amapLocation.latitude
                startLon = amapLocation.longitude
                currentAddress = amapLocation.address
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
                        endLat = geocodeAddress.getLatLonPoint().getLatitude() //纬度
                        endLon = geocodeAddress.getLatLonPoint().getLongitude() //经度
                        val cameraPosition = CameraPosition(LatLng(endLat, endLon), 18f, 0f, 0f)
                        val cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)
                        aMap?.moveCamera(cameraUpdate)
                        drawMarkers(endLat, endLon)
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
        val marker: Marker? = aMap?.addMarker(markerOptions)
        marker?.showInfoWindow()
    }

    private fun showDialog() {
        val mapDialog: MapDialog = object : MapDialog(this@MapViewActivity) {
            override fun onClick(v: View) {
                when (v.id) {
                    R.id.gaode_btn -> {
                        if (MapUtil.isGdMapInstalled) {
                            address?.let { MapUtil.openGaoDeNavi(this@MapViewActivity, startLat, startLon, currentAddress, endLat, endLon, address) }
                        } else {
                            //这里必须要写逻辑，不然如果手机没安装该应用，程序会闪退，这里可以实现下载安装该地图应用
                            Toast.makeText(this@MapViewActivity, "尚未安装高德地图", Toast.LENGTH_SHORT).show()
                        }
                    }
                    R.id.baidu_btn -> {
                        if (MapUtil.isBaiduMapInstalled) {
                            address?.let { MapUtil.openBaiDuNavi(this@MapViewActivity, startLat, startLon, currentAddress, endLat, endLon, address) }
                        } else {
                            //这里必须要写逻辑，不然如果手机没安装该应用，程序会闪退，这里可以实现下载安装该地图应用
                            Toast.makeText(this@MapViewActivity, "尚未安装百度地图", Toast.LENGTH_SHORT).show()
                        }
                    }
                    R.id.tencent_btn -> {
                        if (MapUtil.isTencentMapInstalled) {
                            address?.let { MapUtil.openTencentMap(this@MapViewActivity, startLat, startLon, currentAddress, endLat, endLon, address) }
                        } else {
                            //这里必须要写逻辑，不然如果手机没安装该应用，程序会闪退，这里可以实现下载安装该地图应用
                            Toast.makeText(this@MapViewActivity, "尚未安装腾讯地图", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                super.onClick(v)
            }
        }
        mapDialog.show()
    }

    override fun handleMessage(message: Message) {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        map_view.onDestroy()
        mLocationClient?.onDestroy()
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