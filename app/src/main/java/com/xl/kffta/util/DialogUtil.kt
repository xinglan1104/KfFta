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
    fun showCommonDialog(context: Context, message: String) {
        val view: View = LayoutInflater.from(context).inflate(R.layout.dialog_common, null)
        MaterialDialog(context).show {
            customView(view = view, noVerticalPadding = true, dialogWrapContent = true)
            maxWidth(R.dimen.login_left_right_margin)
            val customView = getCustomView()
            this.cornerRadius(0F)
            cancelOnTouchOutside(false)
            customView.find<TextView>(R.id.common_dialog_msg).text = message
            customView.find<TextView>(R.id.common_dialog_cancel).setOnClickListener {
                this.dismiss()
            }
        }
    }
}