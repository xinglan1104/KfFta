package com.xl.kffta.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.method.ScrollingMovementMethod
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
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

    interface OnLawCaseOrWarnClickListener {
        fun onLawCaseClick()
        fun onWarnClick()
        fun onCancelClick()
    }

    fun showCommonDialog(context: Context, message: String, dialogOkClick: OnDialogOkClick) {
        context.setTheme(R.style.AppTheme_NoActionBar)
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
                this.dismiss()
                dialogOkClick.onDialogOkClick()
            }
        }
    }

    /**
     * 事件清单详情的dialog
     */
    fun showCheckListDialog(context: Context, title: String, provide: String, detail: String) {
        context.setTheme(R.style.AppTheme_NoActionBar)
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.dialog_checklist, null)
        MaterialDialog(context).show {
            customView(view = dialogView, noVerticalPadding = true)
            this.cornerRadius(10f)
            cancelOnTouchOutside(false)
            val customView = getCustomView()
            customView.find<TextView>(R.id.dialog_check_content).movementMethod = object : ScrollingMovementMethod() {}
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
        context.setTheme(R.style.AppTheme_NoActionBar)
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.dialog_joint_riskinfo, null)
        MaterialDialog(context).show {
            customView(view = dialogView, noVerticalPadding = true)
            this.cornerRadius(10f)
            cancelOnTouchOutside(false)

            val customView = getCustomView()
            customView.find<TextView>(R.id.dialog_joint_risk_info).movementMethod = object : ScrollingMovementMethod() {}
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
        context.setTheme(R.style.AppTheme_NoActionBar)
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

    /**
     * 选择立案还是预警
     */
    fun showCaseOrWarnDialog(context: Context, callback: OnLawCaseOrWarnClickListener) {
        context.setTheme(R.style.Dialog_Trans_Background)
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.dialog_select_case_or_warn, null)
        MaterialDialog(context).show {
            customView(view = dialogView, noVerticalPadding = true)
            cornerRadius(0f)

            val customView = getCustomView()
            customView.find<TextView>(R.id.dialog_lian).setOnClickListener {
                this.dismiss()
                callback.onLawCaseClick()
            }
            customView.find<TextView>(R.id.dialog_warn).setOnClickListener {
                this.dismiss()
                callback.onWarnClick()
            }
            customView.find<TextView>(R.id.dialog_cancel).setOnClickListener {
                this.dismiss()
                callback.onCancelClick()
            }
        }
    }

    /**
     * 选择拨号界面
     */
    fun showBottomCallDialog(context: Context) {
        context.setTheme(R.style.Dialog_Trans_Background)
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.dialog_bottom_call, null)
        MaterialDialog(context).show {
            customView(view = dialogView, noVerticalPadding = true)
            cornerRadius(0f)

            window?.setGravity(Gravity.BOTTOM)
            val customView = getCustomView()
            customView.find<TextView>(R.id.dialog_call_cancel).setOnClickListener {
                this.dismiss()
            }
            customView.find<TextView>(R.id.dialog_call_1).setOnClickListener {
                this.dismiss()
                call(context, (it as TextView).text.toString().trim())
            }
        }
    }

    fun showSingleCommonDialog(context: Context?, title: String = "系统提示", msg: String) {
        context?.setTheme(R.style.AppTheme_NoActionBar)
        context?.let {
            MaterialDialog(context).show {
                title(text = title)
                message(text = msg)
                positiveButton(text = "确定")
            }
        }
    }

    /**
     * 调用拨号功能
     * @param phone 电话号码
     */
    fun call(context: Context, phoneNumber: String) {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
        context.startActivity(intent)
    }
}