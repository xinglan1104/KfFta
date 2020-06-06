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

    init {
        View.inflate(context, R.layout.layout_select_business, this)
        layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        mAdapter = ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, mNames)
        bus_value.setAdapter(mAdapter)
        bus_value.doOnTextChanged { text, start, before, count ->
            sendRequest(text.toString())
        }
        bus_value.setOnItemClickListener { parent, view, position, id ->
            mBusinessInfoBean?.data?.values?.let {
                if (position < it.size) {
                    bus2_value.text = it[position].businessLicenseRegistrationNumber
                }
            }
        }
    }

    fun sendRequest(searchStr: String) {
        LawCaseManager.queryAllBusinesses(searchStr, object : ResponseObjectCallback {
            override fun onError(msg: String) {

            }

            override fun onSuccess(obj: Any) {
                post {
                    if (obj is BusinessInfoBean) {
                        mBusinessInfoBean = obj

                        val values = mBusinessInfoBean?.data?.values
                        if (!values.isNullOrEmpty()) {
                            mNames.clear()
                            values.forEach {
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