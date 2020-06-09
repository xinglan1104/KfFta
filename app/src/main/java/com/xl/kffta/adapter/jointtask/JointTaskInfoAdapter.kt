package com.xl.kffta.adapter.jointtask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.JointTaskInfoItem
import com.xl.kffta.util.DialogUtil
import com.xl.kffta.util.SysUtils
import com.xl.kffta.viewholder.AddPictureFileViewHolder
import org.jetbrains.anko.find
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author created by zhanghaochen
 * @date 2020-05-21 15:39
 * 描述：项目检查任务详情的适配器
 */
class JointTaskInfoAdapter(val context: Context, private val fileOnlyShow: Boolean) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val ITEM_EDITABLE = 6
    private val ITEM_NORMAL = 7
    private val ITEM_ADD_FILE = 8

    private val mDatas = ArrayList<JointTaskInfoItem>()

    var mCheckResult: String = ""
    var mNote: String = ""
    var mDateSelected: String = ""
    var mHasAddFile = false


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_EDITABLE) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_jointtast_et, parent, false)
            return JointTaskInfoDetailEditHolder(view)
        } else if (viewType == ITEM_ADD_FILE) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_add_file, parent, false)
            return AddPictureFileViewHolder(view, if (fileOnlyShow) {
                AddPictureFileViewHolder.TYPE_SHOW
            } else {
                AddPictureFileViewHolder.TYPE_SELECT
            })
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_jointtast_info, parent, false)
            return JointTaskInfoNormalHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position < mDatas.size) {
            val jointTaskInfoItem = mDatas[position]

            when (holder) {
                is JointTaskInfoNormalHolder -> {
                    holder.label.text = jointTaskInfoItem.label
                    holder.value.text = jointTaskInfoItem.value

                    // 根据是否可点击给予不同颜色
                    // 如果是事件清单，还是需要特殊处理
                    if (jointTaskInfoItem.isClickable) {
                        holder.value.setTextColor(context.resources.getColorStateList(R.color.btn_common_color))
                        holder.value.setOnClickListener {
                            // 点击了,搞个弹窗
                            DialogUtil.showJointRiskDialog(context, jointTaskInfoItem.checkStateName, jointTaskInfoItem.deparmentName, jointTaskInfoItem.riskInfo)
                        }
                    } else if (jointTaskInfoItem.isDatePicker) {
                        // 时间选择器
                        // 如果是时间选择器
                        holder.value.text = "请选择日期"
                        holder.value.setTextColor(context.resources.getColorStateList(R.color.text_value))
                        holder.value.doOnTextChanged { text, start, before, count ->
                            mDateSelected = text.toString().trim()
                        }
                        holder.value.setOnClickListener {
                            SysUtils.showDatePickerDialog(context, holder.value, Calendar.getInstance(Locale.CHINA))
                        }
                    } else {
                        holder.value.setTextColor(context.resources.getColorStateList(R.color.text_value))
                        holder.value.setOnClickListener(null)
                    }
                }
                is JointTaskInfoDetailEditHolder -> {
                    // 编辑框的holder
                    holder.label.text = jointTaskInfoItem.label
                    holder.edit.hint = "添加${jointTaskInfoItem.label}"
                    holder.edit.setTextColor(context.resources.getColorStateList(R.color.text_value))

                    holder.edit.doOnTextChanged { text, start, before, count ->
                        if (jointTaskInfoItem.label == "检查结果") {
                            mCheckResult = text.toString().trim()
                        } else if (jointTaskInfoItem.label == "备注") {
                            mNote = text.toString().trim()
                        }
                    }
                }
                is AddPictureFileViewHolder -> {
                    holder.setUploadFileCallback { success ->
                        mHasAddFile = success
                    }
                    holder.setCommonFiles(jointTaskInfoItem.commonFileBean)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val jointTaskItem = mDatas[position]
        return if (jointTaskItem.isEditable) {
            ITEM_EDITABLE
        } else {
            if (jointTaskItem.needUpLoad) {
                ITEM_ADD_FILE
            } else {
                ITEM_NORMAL
            }
        }
    }

    fun notifyDataChange(jointTaskItem: ArrayList<JointTaskInfoItem>) {
        if (!jointTaskItem.isNullOrEmpty()) {
            mDatas.clear()
            mDatas.addAll(jointTaskItem)
            notifyDataSetChanged()
        }
    }

    /**
     * 普通的条目holder
     */
    class JointTaskInfoNormalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label = itemView.findViewById<TextView>(R.id.joint_info_label)
        val value = itemView.findViewById<TextView>(R.id.joint_info_value)
    }

    class JointTaskInfoTitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    /**
     * 编辑框的holder
     */
    class JointTaskInfoDetailEditHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label = itemView.find<TextView>(R.id.joint_info_label_et)
        val edit = itemView.find<EditText>(R.id.joint_info_value_et)
    }
}
