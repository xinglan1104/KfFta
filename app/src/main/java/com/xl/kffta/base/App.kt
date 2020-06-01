package com.xl.kffta.base

import android.app.Application
import androidx.multidex.MultiDex
import com.xl.kffta.greendao.DaoMaster
import com.xl.kffta.greendao.DaoSession

/**
 * @author created by zhanghaochen
 * @date 2020-05-15 13:50
 * 描述：自定义applcation
 */
class App : Application() {
    companion object {
        @JvmField
        var instance: App? = null
        @JvmField
        var daoSession: DaoSession? = null

        @JvmStatic
        fun getContext() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        MultiDex.install(this)
        initGreenDao()
    }

    private fun initGreenDao() {
        // 创建数据库kf.db
        val help = DaoMaster.DevOpenHelper(instance, "kf.db")
        // 获取可写数据库
        val database = help.writableDatabase
        // 获取数据库对象
        val daoMaster = DaoMaster(database)
        // 获取dao对象管理者
        daoSession = daoMaster.newSession()
    }
}
