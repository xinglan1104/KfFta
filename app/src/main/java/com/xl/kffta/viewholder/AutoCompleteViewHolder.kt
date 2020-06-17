package com.xl.kffta.viewholder

import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import com.xl.kffta.model.DepartmentInfoBean
import com.xl.kffta.net.ResponseObjectCallback
import com.xl.kffta.net.taskmanager.LawCaseManager
import org.jetbrains.anko.find

/**
 * @author created by zhanghaochen
 * @date 2020-06-15 16:46
 * 描述：主要用于选择部门
 */
class AutoCompleteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mAutoCompleteTv = itemView.find<AutoCompleteTextView>(R.id.department_value)
    val mLabelTv = itemView.find<TextView>(R.id.department_label)

    private var mDepartmentInfoBean: DepartmentInfoBean? = null
    private var mAdapter: ArrayAdapter<String>? = null
    private val mNames = mutableListOf<String>()

    interface OnDepartmentChangeListener {
        fun onDepartmentChangeListener(departmentDataBean: DepartmentInfoBean.DataBean)
        fun onTextChanged(text: String)
    }

    var mOnDepartmentChangeListener: OnDepartmentChangeListener? = null

    init {
        mAdapter = ArrayAdapter<String>(itemView.context, android.R.layout.simple_dropdown_item_1line, mNames)
        mAutoCompleteTv.setAdapter(mAdapter)
        mAutoCompleteTv.doOnTextChanged { text, start, before, count ->
            mOnDepartmentChangeListener?.onTextChanged(text.toString())
            itemView.postDelayed({
                sendRequest(text.toString())
            }, 200)

        }
        mAutoCompleteTv.setOnItemClickListener { parent, view, position, id ->
            mDepartmentInfoBean?.data?.let {
                if (position < it.size) {
                    mOnDepartmentChangeListener?.onDepartmentChangeListener(it[position])
                }
            }
        }
    }

    fun setLabelText(label: String) {
        mLabelTv.text = label
    }

    fun sendRequest(searchStr: String) {
        LawCaseManager.queryAllDepartment(searchStr, object : ResponseObjectCallback {
            override fun onError(msg: String) {

            }

            override fun onSuccess(obj: Any) {
                itemView.post {
                    if (obj is DepartmentInfoBean) {
                        mDepartmentInfoBean = obj

                        val values = mDepartmentInfoBean?.data
                        if (!values.isNullOrEmpty()) {
                            mNames.clear()
                            values.forEach {
                                mNames.add(it.name)
                            }
                            mAdapter = ArrayAdapter<String>(itemView.context, android.R.layout.simple_dropdown_item_1line, mNames)
                            mAutoCompleteTv.setAdapter(mAdapter)
                            mAdapter?.setNotifyOnChange(true)
                        }
                    }
                }
            }

        })
    }
}
