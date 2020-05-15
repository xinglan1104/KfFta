package com.xl.kffta.net

import android.util.Log
import okhttp3.*
import java.io.IOException

/**
 * @author created by zhanghaochen
 * @date 2020-05-15 16:30
 * 描述：
 */
class NetManager private constructor() {
    private val client by lazy {
        OkHttpClient()
    }

    companion object {
        val manager by lazy {
            NetManager()
        }
    }

    fun sendRequest(req: RequestBuilder) {
        val paramsMap = hashMapOf<String, String>()
        paramsMap["CompanyCode"] = "kaifeng"
        paramsMap["Username"] = "admin"
        paramsMap["Password"] = "111111"
        val builder = FormBody.Builder()
        // 追加表单信息
        for ((key, value) in paramsMap) {
            builder.add(key, value)
        }
        val formBody = builder.build()
        val request = Request.Builder()
            .url("https://test.dynamictier.com/services2/serviceapi/web/AccountSignIn?format=json")
            .post(formBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                val result = response.body?.string()
                Log.e("NetManager", "{$result}")
            }

        })
    }
}
