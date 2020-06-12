package com.xl.kffta.viewholder;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.xl.kffta.R;
import com.xl.kffta.adapter.GridImageAdapter;
import com.xl.kffta.base.App;
import com.xl.kffta.base.LifeCycleManager;
import com.xl.kffta.model.CommonFileBean;
import com.xl.kffta.net.taskmanager.FilesNetManager;
import com.xl.kffta.util.GlideEngine;
import com.xl.kffta.widget.FullyGridLayoutManager;
import com.xl.kffta.widget.LoadingView;
import com.yalantis.ucrop.util.ScreenUtils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.ContentValues.TAG;

/**
 * @author wangyuefei
 */

public class AddPictureFileViewHolder extends RecyclerView.ViewHolder {
    public static int TYPE_SHOW = 0;
    public static int TYPE_SELECT = 1;
    private Context mContext;
    private RecyclerView mRecyclerView;
    private GridImageAdapter mAdapter;
    private LoadingView mLoadingView;

    private MyResultCallback myResultCallback;


    public AddPictureFileViewHolder(@NonNull View itemView, int type) {
        super(itemView);
        mContext = itemView.getContext();
        mLoadingView = itemView.findViewById(R.id.add_file_loading);
        mRecyclerView = itemView.findViewById(R.id.add_file_recycler);
        FullyGridLayoutManager manager = new FullyGridLayoutManager(mContext, 4, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(4, ScreenUtils.dip2px(mContext, 8), false));
        mAdapter = new GridImageAdapter(mContext, onAddPicClickListener, type);
        mAdapter.setSelectMax(9);
        myResultCallback = new MyResultCallback(mAdapter, this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((v, position) -> {
            List<LocalMedia> selectList = mAdapter.getData();
            if (selectList.size() > 0) {
                LocalMedia media = selectList.get(position);
                String mimeType = media.getMimeType();
                int mediaType = PictureMimeType.getMimeType(mimeType);
                switch (mediaType) {
                    case PictureConfig.TYPE_VIDEO:
                        // 预览视频
                        PictureSelector.create(LifeCycleManager.getInstance().getTopActivity())
                                .themeStyle(R.style.picture_default_style)
                                .externalPictureVideo(TextUtils.isEmpty(media.getAndroidQToPath()) ? media.getPath() : media.getAndroidQToPath());
                        break;
                    case PictureConfig.TYPE_AUDIO:
                        // 预览音频
                        PictureSelector.create(LifeCycleManager.getInstance().getTopActivity())
                                .externalPictureAudio(PictureMimeType.isContent(media.getPath()) ? media.getAndroidQToPath() : media.getPath());
                        break;
                    default:
                        // 预览图片 可自定长按保存路径
//                        PictureWindowAnimationStyle animationStyle = new PictureWindowAnimationStyle();
//                        animationStyle.activityPreviewEnterAnimation = R.anim.picture_anim_up_in;
//                        animationStyle.activityPreviewExitAnimation = R.anim.picture_anim_down_out;
                        PictureSelector.create(LifeCycleManager.getInstance().getTopActivity())
                                .themeStyle(R.style.picture_default_style) // xml设置主题
                                //.setPictureWindowAnimationStyle(animationStyle)// 自定义页面启动动画
                                .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)// 设置相册Activity方向，不设置默认使用系统
                                .isNotPreviewDownload(true)// 预览图片长按是否可以下载
                                //.bindCustomPlayVideoCallback(new MyVideoSelectedPlayCallback(getContext()))// 自定义播放回调控制，用户可以使用自己的视频播放界面
                                .imageEngine(GlideEngine.createGlideEngine())// 外部传入图片加载引擎，必传项
                                .openExternalPreview(position, selectList);
                        break;
                }
            }
        });

    }

    public void setUploadFileCallback(UploadFileCallback callback) {
        if (myResultCallback != null) {
            myResultCallback.setUploadFileCallback(callback);
        }
    }

    public void setList(List<LocalMedia> list) {
        if (list != null && list.size() > 0) {
            if (mAdapter != null) {
                mAdapter.setList(list);
                mAdapter.notifyDataSetChanged();
            }
        }

    }

    public void setCommonFiles(CommonFileBean fileBean) {
        if (fileBean == null) {
            return;
        }
        List<CommonFileBean.FilesBean> list = fileBean.getFiles();
        List<LocalMedia> showList = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            LocalMedia media = new LocalMedia();
            CommonFileBean.FilesBean file = list.get(i);
            String type = file.getType();
            if (TextUtils.isEmpty(type)) {
                return;
            } else if (type.startsWith("video") || type.startsWith("image")) {
                media.setPath(file.getStorePath());
                showList.add(media);
            }
        }
        setList(showList);
    }

    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {
            // 进入相册 以下是例子：不需要的api可以不写
            PictureSelector.create(LifeCycleManager.getInstance().getTopActivity())
                    .openGallery(PictureConfig.TYPE_ALL)// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                    .imageEngine(GlideEngine.createGlideEngine())// 外部传入图片加载引擎，必传项
                    .theme(R.style.picture_WeChat_style)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style v2.3.3后 建议使用setPictureStyle()动态方式
                    .isWeChatStyle(true)// 是否开启微信图片选择风格
                    .isUseCustomCamera(true)// 是否使用自定义相机
                    .isWithVideoImage(true)// 图片和视频是否可以同选,只在ofAll模式下有效
                    .isMaxSelectEnabledMask(true)// 选择数到了最大阀值列表是否启用蒙层效果
                    //.isAutomaticTitleRecyclerTop(false)// 连续点击标题栏RecyclerView是否自动回到顶部,默认true
                    //.loadCacheResourcesCallback(GlideCacheEngine.createCacheEngine())// 获取图片资源缓存，主要是解决华为10部分机型在拷贝文件过多时会出现卡的问题，这里可以判断只在会出现一直转圈问题机型上使用
                    //.setOutputCameraPath()// 自定义相机输出目录，只针对Android Q以下，例如 Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) +  File.separator + "Camera" + File.separator;
                    //.setButtonFeatures(CustomCameraView.BUTTON_STATE_BOTH)// 设置自定义相机按钮状态
                    .maxSelectNum(1)// 最大图片选择数量
                    .minSelectNum(0)// 最小选择数量
                    .maxVideoSelectNum(1) // 视频最大选择数量
                    .imageSpanCount(4)// 每行显示个数
                    .isReturnEmpty(false)// 未选择数据时点击按钮是否可以返回
                    .closeAndroidQChangeWH(true)//如果图片有旋转角度则对换宽高,默认为true
                    .closeAndroidQChangeVideoWH(true)// 如果视频有旋转角度则对换宽高,默认为false
                    //.isAndroidQTransform(false)// 是否需要处理Android Q 拷贝至应用沙盒的操作，只针对compress(false); && .isEnableCrop(false);有效,默认处理
                    .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)// 设置相册Activity方向，不设置默认使用系统
                    .isOriginalImageControl(true)// 是否显示原图控制按钮，如果设置为true则用户可以自由选择是否使用原图，压缩、裁剪功能将会失效
                    //.bindCustomPlayVideoCallback(new MyVideoSelectedPlayCallback(getContext()))// 自定义视频播放回调控制，用户可以使用自己的视频播放界面
                    //.bindCustomPreviewCallback(new MyCustomPreviewInterfaceListener())// 自定义图片预览回调接口
                    //.bindCustomCameraInterfaceListener(new MyCustomCameraInterfaceListener())// 提供给用户的一些额外的自定义操作回调
                    //.cameraFileName(System.currentTimeMillis() +".jpg")    // 重命名拍照文件名、如果是相册拍照则内部会自动拼上当前时间戳防止重复，注意这个只在使用相机时可以使用，如果使用相机又开启了压缩或裁剪 需要配合压缩和裁剪文件名api
                    //.renameCompressFile(System.currentTimeMillis() +".jpg")// 重命名压缩文件名、 如果是多张压缩则内部会自动拼上当前时间戳防止重复
                    //.renameCropFileName(System.currentTimeMillis() + ".jpg")// 重命名裁剪文件名、 如果是多张裁剪则内部会自动拼上当前时间戳防止重复
                    .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选
                    .isPreviewImage(true)// 是否可预览图片
                    .isPreviewVideo(true)// 是否可预览视频
                    //.querySpecifiedFormatSuffix(PictureMimeType.ofJPEG())// 查询指定后缀格式资源
                    .isEnablePreviewAudio(true) // 是否可播放音频
                    .isCamera(true)// 是否显示拍照按钮
                    //.isMultipleSkipCrop(false)// 多图裁剪时是否支持跳过，默认支持
                    //.isMultipleRecyclerAnimation(false)// 多图裁剪底部列表显示动画效果
                    .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                    //.imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg,Android Q使用PictureMimeType.PNG_Q
                    .isEnableCrop(false)// 是否裁剪
                    //.basicUCropConfig()//对外提供所有UCropOptions参数配制，但如果PictureSelector原本支持设置的还是会使用原有的设置
                    .isCompress(false)// 是否压缩
                    //.compressQuality(80)// 图片压缩后输出质量 0~ 100
                    .synOrAsy(true)//同步true或异步false 压缩 默认同步
                    //.queryMaxFileSize(10)// 只查多少M以内的图片、视频、音频  单位M
                    //.compressSavePath(getPath())//压缩图片保存地址
                    //.sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效 注：已废弃
                    //.glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度 注：已废弃
                    .hideBottomControls(false)// 是否显示uCrop工具栏，默认不显示
                    .isGif(false)// 是否显示gif图片
                    //.setCropDimmedColor(ContextCompat.getColor(getContext(), R.color.app_color_white))// 设置裁剪背景色值
                    //.setCircleDimmedBorderColor(ContextCompat.getColor(getApplicationContext(), R.color.app_color_white))// 设置圆形裁剪边框色值
                    //.setCircleStrokeWidth(3)// 设置圆形裁剪边框粗细
                    .isOpenClickSound(false)// 是否开启点击声音
                    //.isDragFrame(false)// 是否可拖动裁剪框(固定)
                    //.videoMinSecond(10)// 查询多少秒以内的视频
                    //.videoMaxSecond(15)// 查询多少秒以内的视频
                    //.recordVideoSecond(10)//录制视频秒数 默认60s
                    //.isPreviewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
                    //.cropCompressQuality(90)// 注：已废弃 改用cutOutQuality()
                    .cutOutQuality(90)// 裁剪输出质量 默认100
                    .minimumCompressSize(100)// 小于多少kb的图片不压缩
                    //.cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效
                    //.cropImageWideHigh()// 裁剪宽高比，设置如果大于图片本身宽高则无效
                    //.rotateEnabled(false) // 裁剪是否可旋转图片
                    //.scaleEnabled(false)// 裁剪是否可放大缩小图片
                    //.videoQuality()// 视频录制质量 0 or 1
                    //.forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
                    .forResult(myResultCallback);
        }
    };

    public void showProgress() {
        mLoadingView.showLoading(false, R.color.btn_common_color);
    }

    public void hideProgress() {
        mLoadingView.hide();
    }

    /**
     * 返回结果回调
     */
    public static class MyResultCallback implements OnResultCallbackListener<LocalMedia> {
        public static final ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        private WeakReference<GridImageAdapter> mAdapterWeakReference;
        private WeakReference<AddPictureFileViewHolder> mViewHolderWeakReference;
        public List<LocalMedia> list = new ArrayList<>();
        private UploadFileCallback mUpFileCallback;

        public MyResultCallback(GridImageAdapter adapter, AddPictureFileViewHolder viewHolder) {
            super();
            this.mAdapterWeakReference = new WeakReference<>(adapter);
            this.mViewHolderWeakReference = new WeakReference<>(viewHolder);
        }

        public void setUploadFileCallback(UploadFileCallback callback) {
            this.mUpFileCallback = callback;
        }

        @Override
        public void onResult(List<LocalMedia> result) {
            for (LocalMedia media : result) {
                Log.i(TAG, "是否压缩:" + media.isCompressed());
                Log.i(TAG, "压缩:" + media.getCompressPath());
                Log.i(TAG, "原图:" + media.getPath());
                Log.i(TAG, "是否裁剪:" + media.isCut());
                Log.i(TAG, "裁剪:" + media.getCutPath());
                Log.i(TAG, "是否开启原图:" + media.isOriginal());
                Log.i(TAG, "原图路径:" + media.getOriginalPath());
                Log.i(TAG, "Android Q 特有Path:" + media.getAndroidQToPath());
                Log.i(TAG, "宽高: " + media.getWidth() + "x" + media.getHeight());
                Log.i(TAG, "Size: " + media.getSize());
                // TODO 可以通过PictureSelectorExternalUtils.getExifInterface();方法获取一些额外的资源信息，如旋转角度、经纬度等信息
                list.add(media);
                if (mAdapterWeakReference.get() != null) {
                    mAdapterWeakReference.get().setList(list);
                    mAdapterWeakReference.get().notifyDataSetChanged();
                }
                mViewHolderWeakReference.get().showProgress();
                FilesNetManager.INSTANCE.uploadSingleFile(media.getPath(), new UploadFileCallback() {
                    @Override
                    public void uploadSuccss(boolean success) {
                        LifeCycleManager.getInstance().getTopActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (!success) {
                                    list.remove(media);
                                    Toast.makeText(App.getContext(), "上传文件失败，不添加到展示", Toast.LENGTH_SHORT).show();
                                }
                                mViewHolderWeakReference.get().hideProgress();
                                if (mAdapterWeakReference.get() != null) {
                                    mAdapterWeakReference.get().setList(list);
                                    mAdapterWeakReference.get().notifyDataSetChanged();

                                }
                                if (mUpFileCallback != null) {
                                    mUpFileCallback.uploadSuccss(success);
                                }
                            }
                        });
                    }
                });
            }

        }

        @Override
        public void onCancel() {
            Log.i(TAG, "PictureSelector Cancel");
        }
    }

    public interface UploadFileCallback {
        void uploadSuccss(boolean success);
    }


}
