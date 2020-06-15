package com.xl.kffta.ui.activity.map

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import com.xl.kffta.R
import kotlinx.android.synthetic.main.map_select_dialog.*

abstract class MapDialog(private val activity: Activity) : Dialog(activity, R.style.MyDialogTheme), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map_select_dialog)
        gaode_btn.setOnClickListener(this)
        baidu_btn.setOnClickListener(this)
        tencent_btn.setOnClickListener(this)
        btn_cancel.setOnClickListener(this)
        setViewLocation()
        setCanceledOnTouchOutside(true) //外部点击取消
    }

    /**
     * 设置dialog位于屏幕底部
     */
    private fun setViewLocation() {
        val dm = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(dm)
        val height = dm.heightPixels
        val window = this.window
        val lp = window.attributes
        lp.x = 0
        lp.y = height
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT
        // 设置显示位置
        onWindowAttributesChanged(lp)
    }

    override fun onClick(v: View) {
        cancel()
    }
}