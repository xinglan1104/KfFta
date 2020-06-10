package com.xl.kffta.net.taskmanager

import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import com.xl.kffta.base.App
import com.xl.kffta.greendao.TaskInfoDao
import com.xl.kffta.model.LocationUploadBean
import com.xl.kffta.model.SimpleResponseBean
import com.xl.kffta.model.sql.TaskInfo
import com.xl.kffta.net.NetManager
import com.xl.kffta.net.RequestBuilder
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.util.ApplicationParams

/**
 * @author created by zhanghaochen
 * @date 2020-06-05 14:55
 * 描述：地图相关的请求和工具类
 */
object LocationManager {
    const val TAG = "LocationManager"

    fun uploadLocationInfo(uploadLacation: LocationUploadBean) {
        val requestBuilder = RequestBuilder()
        requestBuilder.url = "https://test.dynamictier.com/services2/serviceapi/web/AddOrUpdateObject?format=json"
        val paramsMap = hashMapOf<String, String>()
        paramsMap["Token"] = ApplicationParams.TOKEN
        paramsMap["Codename"] = "CloudEasy.ERP.BL.Model.Common.ObjectPosition"
        paramsMap["PageCode"] = "0"
        paramsMap["IsUpdateReference"] = "false"
        paramsMap["Data"] = Gson().toJson(uploadLacation)
        requestBuilder.addParams(paramsMap)
        requestBuilder.callback = object : ResponseCallback {
            override fun onError(msg: String?) {
                Log.e(TAG, msg ?: "执行出错")
            }

            override fun onSuccess(jsonString: String) {
                if (!TextUtils.isEmpty(jsonString)) {
                    // 直接把Json转换成javaBean
                    try {
                        val simpleResponse: SimpleResponseBean? = Gson().fromJson(jsonString, SimpleResponseBean::class.java)
                        if (simpleResponse == null) {
                            Log.e(TAG, "解析错误")
                        } else {
                            // 获取ErrorCode,<0时错误
                            if (simpleResponse.errorCode < 0) {
                                Log.e(TAG, "解析错误")
                            } else {
                                // success
                                Log.e(TAG, "Success")
                            }
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "解析错误")
                    }
                } else {
                    Log.e(TAG, "解析错误")
                }
            }
        }
        NetManager.manager.sendRequest(requestBuilder)
    }

    /**
     * 开始执行任务，插入或者更新数据库
     */
    fun executeTaskInSql(id: Long, codeName: String, startTaskTime: Long) {
        // 先插入一条数据
        try {
            val taskInfo = TaskInfo()
            taskInfo.codeName = codeName
            taskInfo.executeTime = startTaskTime
            taskInfo.excutionStatus = 0
            taskInfo.pageCode = 0
            taskInfo.objectId = id

            // 首先查询有没有改数据
            val result = App.daoSession?.taskInfoDao?.queryBuilder()?.where(TaskInfoDao.Properties.ObjectId.eq(id),
                    TaskInfoDao.Properties.CodeName.eq(codeName))?.build()?.list()
            if (!result.isNullOrEmpty()) {
                // 有数据，那就update
                App.daoSession?.taskInfoDao?.update(taskInfo)
            } else {
                // 没有数据，插入
                App.daoSession?.taskInfoDao?.insert(taskInfo)
            }
        } catch (ignored: Exception) {
        }
    }

    /**
     * 结束或取消任务，把状态改成1
     */
    fun finishOrCancelTask(id: Long, codeName: String) {
        // 查询有没有对应数据
        try {
            val taskInfo = TaskInfo()
            taskInfo.objectId = id
            taskInfo.codeName = codeName
            taskInfo.excutionStatus = 1

            val result = App.daoSession?.taskInfoDao?.queryBuilder()?.where(TaskInfoDao.Properties.ObjectId.eq(id),
                    TaskInfoDao.Properties.CodeName.eq(codeName))?.build()?.list()
            if (!result.isNullOrEmpty()) {
                // 有数据，那就update
                App.daoSession?.taskInfoDao?.update(taskInfo)
            }
        } catch (ignored: Exception) {
        }
    }
}