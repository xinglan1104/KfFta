package com.xl.kffta.viewholder

import android.view.View
import android.widget.AutoCompleteTextView
import androidx.recyclerview.widget.RecyclerView
import com.xl.kffta.R
import org.jetbrains.anko.find

/**
 * @author zhanghaochen
 * Date: 2020/6/6
 * 描述：
 */
class SelectBusniessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val busValue = itemView.find<AutoCompleteTextView>(R.id.bus_value)

//    init {
//        Log.d("zhc","init")
//        busValue.doOnTextChanged { text, start, before, count ->
//            Log.d("zhc",text.toString())
//            sendRequest(text.toString())
//        }
//    }
//
//    fun sendRequest(searchStr: String) {
//        LawCaseManager.queryAllBusinesses(searchStr, object : ResponseObjectCallback {
//            override fun onError(msg: String) {
//
//            }
//
//            override fun onSuccess(obj: Any) {
//                itemView.post {
//                    if (obj is BusinessInfoBean) {
//                        Log.d("zhc", "${obj?.data?.values?.size}")
//                    }
//                }
//            }
//        })
//    }
}