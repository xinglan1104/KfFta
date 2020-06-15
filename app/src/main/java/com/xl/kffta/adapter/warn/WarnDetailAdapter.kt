package com.xl.kffta.adapter.warn

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.warn.WarnItemBean
import com.xl.kffta.viewholder.AddPictureFileViewHolder
import org.jetbrains.anko.find

/**
 * @author zhanghaochen
 * Date: 2020/6/13
 * 描述：预警详情页的适配器
 */
class WarnDetailAdapter(val context: Context?, private val fileOnlyShow: Boolean) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val ITEM_NORMAL = 20
        private const val ITEM_EDITABLE = 22
        private const val ITEM_UPLOAD_FILE = 23
    }

    val mWarnResultMap = LinkedHashMap<String, String>()

    var mIsUploaded = false

    private var mDatas = ArrayList<WarnItemBean>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_EDITABLE -> {
                val editViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_with_edit, parent, false)
                WarnEditHolder(editViewHolder)
            }
            ITEM_UPLOAD_FILE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_add_file, parent, false)
                AddPictureFileViewHolder(view, if (fileOnlyShow) {
                    AddPictureFileViewHolder.TYPE_SHOW
                } else {
                    AddPictureFileViewHolder.TYPE_SELECT
                })
            }
            else -> {
                val normalView = LayoutInflater.from(parent.context).inflate(R.layout.item_taskinfo_detail, parent, false)
                WarnNormalHolder(normalView)
            }
        }
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position >= mDatas.size) {
            return
        }
        val data = mDatas[position]
        when (holder) {
            is WarnNormalHolder -> {
                holder.label.text = data.label
                holder.value.text = data.value
                mWarnResultMap[data.label] = data.value
            }
            is WarnEditHolder -> {
                holder.label.text = data.label
                holder.edit.hint = data.editHint
                holder.edit.setText(data.value)
                mWarnResultMap[data.label] = data.value
                // 保存输入的内容
                holder.edit.doOnTextChanged { text, start, before, count ->
                    mWarnResultMap[data.label] = text.toString().trim()
                }
            }
            is AddPictureFileViewHolder -> {
                holder.setUploadFileCallback { success ->
                    this.mIsUploaded = success
                }
                holder.setCommonFiles(data.commonFileBean)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val warnItem = mDatas[position]
        return when {
            warnItem.isEditAble -> ITEM_EDITABLE
            warnItem.isUploadFile -> ITEM_UPLOAD_FILE
            else -> ITEM_NORMAL
        }
    }

    fun notifyDataChange(warnItems: ArrayList<WarnItemBean>) {
        if (!warnItems.isNullOrEmpty()) {
            mDatas.clear()
            mDatas.addAll(warnItems)
            notifyDataSetChanged()
        }
    }

    /**
     * 普通的条目holder
     */
    class WarnNormalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label = itemView.find<TextView>(R.id.info_detail_label)
        val value = itemView.find<TextView>(R.id.info_detail_value)
    }

    /**
     * 编辑框的holder
     */
    class WarnEditHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label = itemView.find<TextView>(R.id.info_detail_et_label)
        val edit = itemView.find<EditText>(R.id.info_detail_et)
    }
}