package com.xl.kffta.view

import com.xl.kffta.model.TaskInfoBean

/**
 * @author created by zhanghaochen
 * @date 2020-05-19 16:38
 * 描述：
 */
interface ITaskInfoDetailView {
    fun loadViewSuccess(taskInfoBean: TaskInfoBean)
    fun loadViewFail(msg: String)
}