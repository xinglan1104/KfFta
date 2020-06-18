package com.xl.kffta.widget

import android.content.Context
import android.os.Message
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
import com.xl.kffta.util.MySafeHandler
import kotlinx.android.synthetic.main.layout_select_business.view.*

/**
 * @author zhanghaochen
 * Date: 2020/6/6
 * 描述：选择企业的自定义view
 */
class SelectBusinessLayout : LinearLayout, MySafeHandler.HandlerUser {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    companion object {
        private const val HANDLER_SEND_ET = 0x678
        private const val HANDLER_REFRESH_ADAPTER = 0x677
    }

    private var mBusinessInfoBean: BusinessInfoBean? = null
    private var mAdapter: ArrayAdapter<String>? = null
    private val mNames = mutableListOf<String>()

    private val mHandler: MySafeHandler = MySafeHandler(this)

    interface OnBusinessChangeListener {
        fun onBusinessChangeListener(businessData: BusinessInfoBean.DataBean)
        fun onTextChanged(text: String)
    }

    var mOnBusinessChangeListener: OnBusinessChangeListener? = null

    init {
        View.inflate(context, R.layout.layout_select_business, this)
        layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        mAdapter = ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, mNames)
        bus_value.setAdapter(mAdapter)
        bus_value.doOnTextChanged { text, start, before, count ->
            mOnBusinessChangeListener?.onTextChanged(text.toString())
            // 避免频繁操作输入框，先把之前的消息都remove掉
            mHandler.removeMessages(HANDLER_SEND_ET)
            mHandler.sendEmptyMessageDelayed(HANDLER_SEND_ET, 300)
//            postDelayed({
//                sendRequest(text.toString())
//            }, 200)
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

    override fun handleMessage(msg: Message?) {
        when (msg?.what) {
            HANDLER_SEND_ET -> {
                // 根据搜索内容查询
                sendRequest(bus_value.text.toString())
                mHandler.removeMessages(HANDLER_SEND_ET)
            }
            HANDLER_REFRESH_ADAPTER -> {
                val obj = msg.obj
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
                        mAdapter?.notifyDataSetChanged()
                    }
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
                mHandler.obtainMessage(HANDLER_REFRESH_ADAPTER, obj).sendToTarget()
            }
        })
    }
}