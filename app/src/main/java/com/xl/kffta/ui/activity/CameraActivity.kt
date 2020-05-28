package com.xl.kffta.ui.activity

import android.Manifest
import android.os.Message
import android.util.Log
import com.afollestad.materialdialogs.MaterialDialog
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import kotlinx.android.synthetic.main.activity_camera.*
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions

/**
 * @author created by zhanghaochen
 * @date 2020-05-28 16:29
 * 描述：拍照的界面
 */
@RuntimePermissions
class CameraActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_camera
    }

    override fun handleMessage(message: Message) {

    }

    override fun initListener() {
        ccc.setOnClickListener {
            showCamera()
        }
    }

    @NeedsPermission(Manifest.permission.CAMERA)
    fun showCamera() {
        Log.d("zhc", "zzz")
    }

    fun showWhyForCamera() {
        MaterialDialog(this).show {
            title = "摄像头权限"
            message(text = "拍照需要摄像头权限")
        }
    }
}
