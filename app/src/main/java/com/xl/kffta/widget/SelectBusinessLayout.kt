package com.xl.kffta.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.core.widget.doOnTextChanged
import com.xl.kffta.R
import com.xl.kffta.model.BusinessInfoBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.LawCaseManager
import kotlinx.android.synthetic.main.layout_select_business.view.*

/**
 * @author zhanghaochen
 * Date: 2020/6/6
 * 描述：选择企业的自定义view
 */
class SelectBusinessLayout : LinearLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var mBusinessInfoBean: BusinessInfoBean? = null
    private var mAdapter: ArrayAdapter<String>? = null
    private val mNames = mutableListOf<String>()

    interface OnBusinessChangeListener {
        fun onBusinessChangeListener(businessData: BusinessInfoBean.DataBean)
    }

    var mOnBusinessChangeListener: OnBusinessChangeListener? = null

    init {
        View.inflate(context, R.layout.layout_select_business, this)
        layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        mAdapter = ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, mNames)
        bus_value.setAdapter(mAdapter)
        bus_value.doOnTextChanged { text, start, before, count ->
            postDelayed({
                sendRequest(text.toString())
            }, 200)
        }
        bus_value.setOnItemClickListener { parent, view, position, id ->
            mBusinessInfoBean?.data?.let { dataItem ->
                if (position < dataItem.size) {
                    // 选择完了，直接给社会代码赋值
                    bus2_value.text = dataItem[position].businessLicenseRegistrationNumber
                    mOnBusinessChangeListener?.onBusinessChangeListener(dataItem[position])
                }
            }
        }
    }

    /**
     * 是否显示第二行的公司代码
     */
    fun setMode(isSingleLine: Boolean, label1: String, hint1: String) {
        if (isSingleLine) {
            bus_layout2.visibility = View.GONE
        } else {
            bus_layout2.visibility = View.VISIBLE
        }
        bus_label.text = label1
        bus_value.hint = hint1
    }

    fun sendRequest(searchStr: String) {
        LawCaseManager.queryAllBusinesses(searchStr, object : ResponseObjectCallback {
            override fun onError(msg: String) {

            }

            override fun onSuccess(obj: Any) {
                post {
                    if (obj is BusinessInfoBean) {
                        mBusinessInfoBean = obj

                        val data = mBusinessInfoBean?.data
                        if (!data.isNullOrEmpty()) {
                            mNames.clear()
                            data.forEach {
                                mNames.add(it.businessName)
                            }
                            mAdapter = ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, mNames)
                            bus_value.setAdapter(mAdapter)
                            mAdapter?.setNotifyOnChange(true)
                        }
                    }
                }
            }
        })
    }
}