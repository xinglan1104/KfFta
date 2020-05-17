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
        if (req.params == null) {
            req.callback?.onError("没有入参")
            return
        }
        val builder = FormBody.Builder()
        // 追加表单信息
        for ((key, value) in req.params) {
            builder.add(key, value)
        }
        val formBody = builder.build()
        val request = Request.Builder()
                .url(req.url)
                .post(formBody)
                .build()

        Log.d("net", request.toString())
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                req.callback?.onError(e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                val result = response.body?.string()
                Log.e("NetManager", "{$result}")
                if (result == null) {
                    req.callback?.onError("返回内容为空")
                } else {
                    req.callback?.onSuccess(result)
                }
            }

        })
    }
}
