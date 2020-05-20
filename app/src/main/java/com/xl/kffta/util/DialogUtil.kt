package com.xl.kffta.util

import android.content.Context
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
}