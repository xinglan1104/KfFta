package com.xl.kffta.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.afollestad.materialdialogs.list.ItemListener
import com.afollestad.materialdialogs.list.listItems
import com.xl.kffta.R
import org.jetbrains.anko.find

/**
 * @author zhanghaochen
 * Date: 2020/5/19
 * 描述：dialog工具类
 */
object DialogUtil {
    interface OnDialogOkClick {
        // 点击了ok的监听
        fun onDialogOkClick()
    }

    fun showCommonDialog(context: Context, message: String, dialogOkClick: OnDialogOkClick) {
        val view: View = LayoutInflater.from(context).inflate(R.layout.dialog_common, null)
        MaterialDialog(context).show {
            customView(view = view, noVerticalPadding = true, dialogWrapContent = true)
            maxWidth(R.dimen.common_dialog_width)
            val customView = getCustomView()
            this.cornerRadius(10F)
            cancelOnTouchOutside(false)
            customView.find<TextView>(R.id.common_dialog_msg).text = message
            customView.find<TextView>(R.id.common_dialog_cancel).setOnClickListener {
                this.dismiss()
            }
            // 确认的时候，需要发送个请求
            customView.find<TextView>(R.id.common_dialog_ok).setOnClickListener {
                dialogOkClick.onDialogOkClick()
                this.dismiss()
            }
        }
    }

    /**
     * 事件清单详情的dialog
     */
    fun showCheckListDialog(context: Context, title: String, provide: String, detail: String) {
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.dialog_checklist, null)
        MaterialDialog(context).show {
            customView(view = dialogView, noVerticalPadding = true)
            this.cornerRadius(10f)
            cancelOnTouchOutside(false)
            val customView = getCustomView()
            customView.find<TextView>(R.id.dialog_check_title).text = title
            customView.find<TextView>(R.id.dialog_check_provide).text = provide
            customView.find<TextView>(R.id.dialog_check_content).text = detail
            customView.find<TextView>(R.id.dialog_check_close).setOnClickListener {
                this.dismiss()
            }
        }
    }

    /**
     * 检查阶段的详情弹窗
     */
    fun showJointRiskDialog(context: Context, stage: String, department: String, riskInfo: String) {
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.dialog_joint_riskinfo, null)
        MaterialDialog(context).show {
            customView(view = dialogView, noVerticalPadding = true)
            this.cornerRadius(10f)
            cancelOnTouchOutside(false)

            val customView = getCustomView()
            customView.find<TextView>(R.id.dialog_joint_risk_stage).text = stage
            customView.find<TextView>(R.id.dialog_joint_department).text = department
            customView.find<TextView>(R.id.dialog_joint_risk_info).text = riskInfo
            customView.find<TextView>(R.id.dialog_joint_close).setOnClickListener {
                this.dismiss()
            }
        }
    }

    /**
     * 企业信息的弹窗
     */
    fun showBusinessInfoDialog(context: Context, code: String, name: String, time: String) {
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.dialog_bussns_info, null)
        MaterialDialog(context).show {
            customView(view = dialogView, noVerticalPadding = true)
            this.cornerRadius(10f)
            cancelOnTouchOutside(false)

            val customView = getCustomView()
            customView.find<TextView>(R.id.dialog_buss_code).text = code
            customView.find<TextView>(R.id.dialog_buss_people).text = name
            customView.find<TextView>(R.id.dialog_buss_time).text = time
            customView.find<TextView>(R.id.dialog_buss_close).setOnClickListener {
                this.dismiss()
            }
        }
    }

    fun showSelectedDialog(context: Context, callback: ItemListener) {
        // 处理字符串
        val listStr = ApplicationParams.USER_DEPARTMENTS
        if (!listStr.isNullOrEmpty()) {
            val strs = listStr.split("|")
            val items = strs.toList()
            MaterialDialog(context).show {
                this.cornerRadius(10f)
                title(text = "请选择部门")
                listItems(items = items, selection = callback)
            }
        }
    }
}