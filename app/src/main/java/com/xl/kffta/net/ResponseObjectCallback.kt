package com.xl.kffta.net

/**
 * @author created by zhanghaochen
 * @date 2020-05-21 09:40
 * 描述：网络请求，返回对应的实例类
 */
interface ResponseObjectCallback {
    fun onError(msg: String)
    fun onSuccess(obj: Any)
}
