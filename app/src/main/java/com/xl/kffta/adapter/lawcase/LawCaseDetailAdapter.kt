package com.xl.kffta.adapter.lawcase

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
import com.xl.kffta.model.lawcase.LawCaseItemBean
import com.xl.kffta.util.SysUtils
import com.xl.kffta.viewholder.AddPictureFileViewHolder
import com.xl.kffta.viewholder.AutoCompleteViewHolder
import com.xl.kffta.viewholder.SelectBusniessViewHolder
import com.xl.kffta.widget.SelectBusinessLayout
import org.jetbrains.anko.find

/**
 * @author zhanghaochen
 * Date: 2020/5/31
 * 描述：案件二级页面的adapter
 */
class LawCaseDetailAdapter(val context: Context?, private val fileOnlyShow: Boolean) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val ITEM_NORMAL = 10
        private const val ITEM_TITLE = 11
        private const val ITEM_EDITABLE = 12
        private const val ITEM_UPLOAD_FILE = 13
        private const val ITEM_AUTO_DEPARTMENT = 16
        private const val ITEM_BUSINESS = 14
    }

    val mDatas = ArrayList<LawCaseItemBean>()

    val mCommonCaseResultMap = LinkedHashMap<String, String>()

    var mIsUploaded = false
    var mIsDepartmentChanged = false

    var mDepartmentInfoData: DepartmentInfoBean.DataBean? = null
    var mBusinessInfoData: BusinessInfoBean.DataBean? = null
    var mBusinessStr: String = ""
    var mDepartmentStr: String = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_TITLE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_only_title, parent, false)
                CaseDetailTitleHolder(view)
            }
            ITEM_EDITABLE -> {
                val editViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_with_edit, parent, false)
                CaseDetailEditHolder(editViewHolder)
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
            ITEM_AUTO_DEPARTMENT -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_autocomplete, parent, false)
                AutoCompleteViewHolder(view)
            }
            else -> {
                val normalView = LayoutInflater.from(parent.context).inflate(R.layout.item_taskinfo_detail, parent, false)
                CaseDetailNormalHolder(normalView)
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
        when (holder) {
            is CaseDetailTitleHolder -> {
                holder.title.text = mDatas[position].titleName
            }
            is CaseDetailNormalHolder -> {
                val data = mDatas[position]
                holder.label.text = data.label
                holder.value.text = data.value
                mCommonCaseResultMap[data.label] = data.value
            }
            is AutoCompleteViewHolder -> {
                val data = mDatas[position]
                holder.mAutoCompleteTv.hint = data.editHintStr
                holder.mAutoCompleteTv.setText(data.value)
                mCommonCaseResultMap[data.label] = data.value
                mDepartmentStr = data.value
                holder.mOnDepartmentChangeListener = object : AutoCompleteViewHolder.OnDepartmentChangeListener {
                    override fun onDepartmentChangeListener(departmentDataBean: DepartmentInfoBean.DataBean) {
                        mCommonCaseResultMap[data.label] = departmentDataBean.name
                        mDepartmentInfoData = departmentDataBean
                    }

                    override fun onTextChanged(text: String) {
                        mIsDepartmentChanged = true
                        mDepartmentStr = text
                    }
                }
            }
            is CaseDetailEditHolder -> {
                val data = mDatas[position]
                // 设置输入框的高度
                if (data.isSingleLine) {
                    holder.edit.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                } else {
                    holder.edit.layoutParams.height = SysUtils.convertDpToPixel(70f)
                }
                holder.label.text = data.label
                holder.edit.hint = data.editHintStr
                holder.edit.setText(data.value)
                mCommonCaseResultMap[data.label] = data.value
                // 保存输入的内容
                holder.edit.doOnTextChanged { text, start, before, count ->
                    mCommonCaseResultMap[data.label] = text.toString().trim()
                }

            }
            is SelectBusniessViewHolder -> {
                val businessView = holder.itemView
                if (businessView is SelectBusinessLayout) {
                    businessView.setMode(false, "当事企业", "请输入当事企业")
                    businessView.mOnBusinessChangeListener = object : SelectBusinessLayout.OnBusinessChangeListener {
                        override fun onBusinessChangeListener(businessData: BusinessInfoBean.DataBean) {
                            mCommonCaseResultMap["当事企业"] = businessData.businessName
                            mCommonCaseResultMap["统一社会信用代码"] = businessData.businessLicenseRegistrationNumber
                            mBusinessInfoData = businessData
                        }

                        override fun onTextChanged(text: String) {
                            mBusinessStr = text
                        }

                    }
                }
            }
            is AddPictureFileViewHolder -> {
                holder.setUploadFileCallback { success ->
                    this.mIsUploaded = success
                }
                holder.setCommonFiles(mDatas[position].commonFileBean)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val caseItem = mDatas[position]
        return when {
            caseItem.isTitle -> ITEM_TITLE
            caseItem.isEditable -> ITEM_EDITABLE
            caseItem.needUpload -> ITEM_UPLOAD_FILE
            caseItem.isDepartmentAutoComplete -> ITEM_AUTO_DEPARTMENT
            caseItem.isBusinessAutoComplete -> ITEM_BUSINESS
            else -> ITEM_NORMAL
        }
    }

    fun notifyDataChange(lawCaseItemBean: ArrayList<LawCaseItemBean>) {
        if (!lawCaseItemBean.isNullOrEmpty()) {
            mDatas.clear()
            mDatas.addAll(lawCaseItemBean)
            notifyDataSetChanged()
        }
    }

    /**
     * 获取没有输入的部分
     */
    fun getCommonNoEnterString(): String {
        loop@ for ((key, value) in mCommonCaseResultMap) {
            if (TextUtils.isEmpty(value)) {
                return when (key) {
                    "当事企业" -> {
                        "请正确输入$key"
                    }
                    "统一社会信用代码" -> {
                        continue@loop
                    }
                    "部门" -> {
                        "请选择部门"
                    }
                    "提供者地址" -> {
                        continue@loop
                    }
                    "备注" -> {
                        continue@loop
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
    class CaseDetailNormalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label = itemView.find<TextView>(R.id.info_detail_label)
        val value = itemView.find<TextView>(R.id.info_detail_value)
    }

    class CaseDetailTitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.find<TextView>(R.id.item_title)
    }

    /**
     * 编辑框的holder
     */
    class CaseDetailEditHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label = itemView.find<TextView>(R.id.info_detail_et_label)
        val edit = itemView.find<EditText>(R.id.info_detail_et)
    }
}