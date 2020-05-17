package com.xl.kffta.net

/**
 * @author created by zhanghaochen
 * @date 2020-05-06 15:43
 * 描述：请求回调
 */
interface ResponseCallback {
    fun onError(msg: String?)
    fun onSuccess(jsonString: String)
}
