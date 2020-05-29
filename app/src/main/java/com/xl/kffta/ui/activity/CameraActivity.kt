package com.xl.kffta.ui.activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Message
import android.util.Log
import com.afollestad.materialdialogs.DialogCallback
import com.afollestad.materialdialogs.MaterialDialog
import com.bumptech.glide.Glide
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import com.xl.kffta.R
import com.xl.kffta.base.BaseActivity
import com.xl.kffta.util.GlideEngine
import kotlinx.android.synthetic.main.activity_camera.*
import kotlinx.android.synthetic.main.item_pick_photo.*
import permissions.dispatcher.*


/**
 * @author created by zhanghaochen
 * @date 2020-05-28 16:29
 * 描述：拍照的界面
 */
@RuntimePermissions
class CameraActivity : BaseActivity() {
    var mSelectList = ArrayList<LocalMedia>()
    override fun getLayoutId(): Int {
        return R.layout.activity_camera
    }

    override fun handleMessage(message: Message) {

    }

    override fun initListener() {
        ccc.setOnClickListener {
            // 该方法是makeProject后自动生成的，根据被标注的方法
//            showCameraWithPermissionCheck()

            // 选照片
            openPhote()
        }

        add_screenshot_image_1.setOnClickListener {
            PictureSelector.create(this).themeStyle(R.style.picture_WeChat_style)
                .isWeChatStyle(true)
                .isNotPreviewDownload(true)
                .imageEngine(GlideEngine.createGlideEngine())
                .openExternalPreview(0, mSelectList)
        }
    }

    /**
     * 从相册选取图片
     */
    @NeedsPermission(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    fun openPhote() {
        PictureSelector.create(this).openGallery(PictureMimeType.ofImage())
            .isWeChatStyle(true)
            .selectionMode(PictureConfig.SINGLE)
            .imageEngine(GlideEngine.createGlideEngine())
            .forResult(PictureConfig.CHOOSE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                PictureConfig.CHOOSE_REQUEST -> {
                    // 结果回调
                    var selectList = PictureSelector.obtainMultipleResult(data)
                    if (!selectList.isNullOrEmpty()) {
                        mSelectList.clear()
                        mSelectList.addAll(selectList)
                        selectList.forEach {
                            Log.d("zhc", "选取照片：${it.path}")
                            Glide.with(this).load(it.path).into(add_screenshot_image_1)
                        }
                    }
                }
            }
        }
    }

    /**
     * 需要权限的方法
     */
    @NeedsPermission(Manifest.permission.CAMERA)
    fun showCamera() {
        PictureSelector.create(this)
            .openCamera(PictureMimeType.ofVideo())
            .recordVideoSecond(20)
            .imageEngine(GlideEngine.createGlideEngine())
            .forResult(object : OnResultCallbackListener<LocalMedia> {
                override fun onResult(result: List<LocalMedia>) {
                    // 结果回调
                }

                override fun onCancel() {
                    // 取消
                }
            })
    }

    /**
     * 拒绝一次权限后，再次调用需要权限方法时的后续操作
     */
    @OnShowRationale(Manifest.permission.CAMERA)
    fun showWhyForCamera() {
        MaterialDialog(this).show {
            title(text = "摄像头权限")
            message(text = "拍照需要摄像头权限")
            positiveButton(text = "确定", click = object : DialogCallback {
                override fun invoke(p1: MaterialDialog) {
                    // 该方法也是自动生成的，用于再次申请权限
                    proceedShowCameraPermissionRequest()
                }

            })
            negativeButton(text = "取消")
        }
    }

    /**
     * 拒绝后立即调用
     */
    @OnPermissionDenied(Manifest.permission.CAMERA)
    fun showCameraDenied() {
        myToast("拒绝获取摄像头权限")
    }

    /**
     * 点击了始终禁止权限后，调用权限相关方法时的后续提示
     */
    @OnNeverAskAgain(Manifest.permission.CAMERA)
    fun showNeverAskAgain() {
        MaterialDialog(this).show {
            title(text = "权限设置提示")
            message(text = "应用权限被拒绝,为了不影响您的正常使用，请在 权限 中开启对应权限")
            positiveButton(text = "确定")
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        // 必要的一步回调
        onRequestPermissionsResult(requestCode, grantResults)
    }
}
