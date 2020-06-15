package com.xl.kffta.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnItemClickListener;
import com.luck.picture.lib.tools.DateUtils;
import com.xl.kffta.R;
import com.xl.kffta.base.App;
import com.xl.kffta.base.LifeCycleManager;
import com.xl.kffta.net.taskmanager.FilesNetManager;
import com.xl.kffta.viewholder.AddPictureFileViewHolder;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author：luck
 * @date：2016-7-27 23:02
 * @describe：GridImageAdapter
 */
public class GridImageAdapter extends
        RecyclerView.Adapter<GridImageAdapter.ViewHolder> {
    public static final String TAG = "PictureSelector";
    public static final int TYPE_CAMERA = 1;
    public static final int TYPE_PICTURE = 2;
    private LayoutInflater mInflater;
    private List<LocalMedia> list = new ArrayList<>();
    private Map<String, String> storePathMap = new HashMap<>();
    private int selectMax = 9;
    private int showType;

    /**
     * 点击添加图片跳转
     */
    private onAddPicClickListener mOnAddPicClickListener;

    public interface onAddPicClickListener {
        void onAddPicClick();
    }

    /**
     * 删除
     */
    public void delete(int position) {
        try {

            if (position != RecyclerView.NO_POSITION && list.size() > position) {
                list.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, list.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GridImageAdapter(Context context, onAddPicClickListener mOnAddPicClickListener, int type) {
        this.mInflater = LayoutInflater.from(context);
        this.mOnAddPicClickListener = mOnAddPicClickListener;
        this.showType = type;
    }

    public void setSelectMax(int selectMax) {
        this.selectMax = selectMax;
    }

    public void setList(List<LocalMedia> list) {
        this.list = list;
    }

    public List<LocalMedia> getData() {
        return list == null ? new ArrayList<>() : list;
    }

    public void setStorePathList(Map<String, String> list) {
        this.storePathMap = list;
    }

    public Map<String, String> getStorePathMap() {
        return storePathMap == null ? new HashMap<>() : storePathMap;
    }

    public void remove(int position) {
        if (list != null && position < list.size()) {
            list.remove(position);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImg;
        ImageView mIvDel;
        TextView tvDuration;

        public ViewHolder(View view) {
            super(view);
            mImg = view.findViewById(R.id.fiv);
            mIvDel = view.findViewById(R.id.iv_del);
            tvDuration = view.findViewById(R.id.tv_duration);
        }
    }

    @Override
    public int getItemCount() {
        if (list.size() < selectMax && showType == AddPictureFileViewHolder.TYPE_SELECT) {
            return list.size() + 1;
        } else {
            return list.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isShowAddItem(position)) {
            return TYPE_CAMERA;
        } else {
            return TYPE_PICTURE;
        }
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_add_file_item,
                viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    private boolean isShowAddItem(int position) {
        int size = list.size() == 0 ? 0 : list.size();
        return position == size;
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        //少于8张，显示继续添加的图标
        if (getItemViewType(position) == TYPE_CAMERA && showType == AddPictureFileViewHolder.TYPE_SELECT) {
            viewHolder.mImg.setImageResource(R.drawable.feedback_ft_add_img);
            viewHolder.mImg.setOnClickListener(v -> mOnAddPicClickListener.onAddPicClick());
        } else {
            LocalMedia media = list.get(position);
            if (media == null
                    || TextUtils.isEmpty(media.getPath())) {
                return;
            }
            if (showType == AddPictureFileViewHolder.TYPE_SELECT) {
                viewHolder.mIvDel.setVisibility(View.VISIBLE);
                viewHolder.mIvDel.setOnClickListener(view -> {
                    int index = viewHolder.getAdapterPosition();
                    // 这里有时会返回-1造成数据下标越界,具体可参考getAdapterPosition()源码，
                    // 通过源码分析应该是bindViewHolder()暂未绘制完成导致，知道原因的也可联系我~感谢
                    if (index != RecyclerView.NO_POSITION && list.size() > index) {
                        FilesNetManager.INSTANCE.deleteUploadSingleFile(storePathMap.get(media.getPath()), media.isCompressed() ? media.getCompressPath() : media.getPath(), new AddPictureFileViewHolder.DeleteUploadFileCallback() {
                            @Override
                            public void deleteSuccss(boolean success) {
                                LifeCycleManager.getInstance().getTopActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (success) {
                                            list.remove(index);
                                            storePathMap.remove(media.getPath());
                                            notifyItemRemoved(index);
                                            notifyItemRangeChanged(index, list.size());
                                        } else {
                                            Toast.makeText(App.getContext(), "删除文件失败，不删除展示", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        });

                    }
                });
            }
            int chooseModel = media.getChooseModel();
            String path = "";
            if (showType == AddPictureFileViewHolder.TYPE_SELECT) {
                if (media.isCut() && !media.isCompressed()) {
                    // 裁剪过
                    path = media.getCutPath();
                } else if (media.isCompressed() || (media.isCut() && media.isCompressed())) {
                    // 压缩过,或者裁剪同时压缩过,以最终压缩过图片为准
                    path = media.getCompressPath();
                } else {
                    // 原图
                    path = media.getPath();
                }

                Log.i(TAG, "原图地址::" + media.getPath());

                if (media.isCut()) {
                    Log.i(TAG, "裁剪地址::" + media.getCutPath());
                }
                if (media.isCompressed()) {
                    Log.i(TAG, "压缩地址::" + media.getCompressPath());
                    Log.i(TAG, "压缩后文件大小::" + new File(media.getCompressPath()).length() / 1024 + "k");
                }
                if (!TextUtils.isEmpty(media.getAndroidQToPath())) {
                    Log.i(TAG, "Android Q特有地址::" + media.getAndroidQToPath());
                }
                if (media.isOriginal()) {
                    Log.i(TAG, "是否开启原图功能::" + true);
                    Log.i(TAG, "开启原图功能后地址::" + media.getOriginalPath());
                }

                long duration = media.getDuration();
                viewHolder.tvDuration.setVisibility(PictureMimeType.isHasVideo(media.getMimeType())
                        ? View.VISIBLE : View.GONE);
                if (chooseModel == PictureMimeType.ofAudio()) {
                    viewHolder.tvDuration.setVisibility(View.VISIBLE);
                    viewHolder.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds
                            (R.drawable.picture_icon_audio, 0, 0, 0);

                } else {
                    viewHolder.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds
                            (R.drawable.picture_icon_video, 0, 0, 0);
                }
                viewHolder.tvDuration.setText(DateUtils.formatDurationTime(duration));
            }

            if (chooseModel == PictureMimeType.ofAudio()) {
                viewHolder.mImg.setImageResource(R.drawable.picture_audio_placeholder);
            } else {
                if (showType == AddPictureFileViewHolder.TYPE_SHOW) {
                    path = media.getPath();
                }
                Glide.with(viewHolder.itemView.getContext())
                        .load((PictureMimeType.isContent(path) && !media.isCut() && !media.isCompressed()) ? Uri.parse(path)
                                : path)
                        .centerCrop()
                        .placeholder(R.color.app_color_f6)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(viewHolder.mImg);
            }
            //itemView 的点击事件
            if (mItemClickListener != null) {
                viewHolder.itemView.setOnClickListener(v -> {
                    int adapterPosition = viewHolder.getAdapterPosition();
                    mItemClickListener.onItemClick(v, adapterPosition);
                });
            }

        }
    }

    private OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(OnItemClickListener l) {
        this.mItemClickListener = l;
    }
}
