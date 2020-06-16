package com.xl.kffta.adapter.warn

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.BusinessInfoBean
import com.xl.kffta.model.DepartmentInfoBean
import com.xl.kffta.model.warn.WarnItemBean
import com.xl.kffta.viewholder.AddPictureFileViewHolder
import com.xl.kffta.viewholder.AutoCompleteViewHolder
import com.xl.kffta.viewholder.SelectBusniessViewHolder
import com.xl.kffta.widget.SelectBusinessLayout
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
        private const val ITEM_DEPARTMENT = 24
        private const val ITEM_BUSINESS = 25
    }

    val mWarnResultMap = LinkedHashMap<String, String>()

    var mIsUploaded = false

    var mDepartmentInfoData: DepartmentInfoBean.DataBean? = null
    var mBusinessInfoData: BusinessInfoBean.DataBean? = null
    var mBusinessStr: String = ""
    var mDepartmentStr: String = ""

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
            ITEM_BUSINESS -> {
                val view = SelectBusinessLayout(parent.context)
                SelectBusniessViewHolder(view)
            }
            ITEM_DEPARTMENT -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_autocomplete, parent, false)
                AutoCompleteViewHolder(view)
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
            is SelectBusniessViewHolder -> {
                val businessView = holder.itemView
                if (businessView is SelectBusinessLayout) {
                    businessView.setMode(true, "企业名称", "请输入企业名称")
                    businessView.mOnBusinessChangeListener = object : SelectBusinessLayout.OnBusinessChangeListener {
                        override fun onBusinessChangeListener(businessData: BusinessInfoBean.DataBean) {
                            mWarnResultMap["企业名称"] = businessData.businessName
                            mBusinessInfoData = businessData
                        }

                        override fun onTextChanged(text: String) {
                            mBusinessStr = text
                        }
                    }
                }
            }
            is AutoCompleteViewHolder -> {
                holder.mAutoCompleteTv.hint = data.editHint
                holder.mAutoCompleteTv.setText(data.value)
                mWarnResultMap[data.label] = data.value
                holder.mOnDepartmentChangeListener = object : AutoCompleteViewHolder.OnDepartmentChangeListener {
                    override fun onDepartmentChangeListener(departmentDataBean: DepartmentInfoBean.DataBean) {
                        mWarnResultMap[data.label] = departmentDataBean.name
                        mDepartmentInfoData = departmentDataBean
                    }

                    override fun onTextChanged(text: String) {
                        mDepartmentStr = text
                    }
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
            warnItem.isBusinessAutoComplete -> ITEM_BUSINESS
            warnItem.isDepartmentAutoComplete -> ITEM_DEPARTMENT
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
     * 获取没有输入的部分
     */
    fun getCommonNoEnterString(): String {
        loop@ for ((key, value) in mWarnResultMap) {
            if (TextUtils.isEmpty(value)) {
                return when (key) {
                    "企业名称", "预警部门" -> {
                        "请正确输入$key"
                    }
                    else -> {
                        "请输入$key"
                    }
                }
            }
        }
        return ""
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