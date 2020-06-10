package com.xl.kffta.net

import android.util.Log
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import java.io.File
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

        Log.d("NetManager", request.toString())
        Log.d("NetManager", formBody.toString())
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


    fun sendRequestWithHeader(req: RequestBuilder, filePath: String) {
        if (req.params == null) {
            req.callback?.onError("没有入参")
            return
        }
        val builder = MultipartBody.Builder()
        builder.setType(MultipartBody.FORM)

        // 获取文件的body
        val file = File(filePath)
        if (file == null || !file.exists()) {
            req.callback?.onError("无法获取文件")
        }
        val fileBody = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), file)
        // 追加表单信息
        for ((key, value) in req.params) {
            builder.addFormDataPart(key, value)
        }
        // 追加文件信息
        builder.addFormDataPart("file", file.name, fileBody)
        val request = Request.Builder()
                .url(req.url)
                .post(builder.build())
                .build()

        Log.d("NetManager", request.toString())
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
