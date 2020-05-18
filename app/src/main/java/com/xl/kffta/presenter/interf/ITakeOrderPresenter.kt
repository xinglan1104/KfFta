package com.xl.kffta.presenter.interf

/**
 * @author zhanghaochen
 * Date: 2020/5/18
 * 描述：领取任务的接口
 */
interface ITakeOrderPresenter {
    /**
     * 查询领取的任务
     * @param pageCode pageIndex
     * @param skip 跳过的数量
     * @param take pageCount
     */
    fun queryTask(pageCode: String, skip: String, take: String)
}