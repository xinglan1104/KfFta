package com.xl.kffta.base

import android.app.Application

/**
 * @author created by zhanghaochen
 * @date 2020-05-15 13:50
 * 描述：自定义applcation
 */
class App : Application() {
    companion object {
        @JvmField
        var instance: App? = null

        @JvmStatic
        fun getContext() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
