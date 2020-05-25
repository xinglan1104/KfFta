package com.xl.kffta.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.xl.kffta.R

/**
 * @author created by zhanghaochen
 * @date 2020-05-25 11:14
 * 描述：通用的loading界面
 */
class LoadingView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.view_loading, this)
        layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        setOnClickListener {
            Log.d("zhc", "仅仅为了不能点击其他区域")
        }
    }

    fun showLoading() {
        visibility = View.VISIBLE
    }

    fun hide() {
        visibility = View.GONE
    }
}
