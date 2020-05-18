package com.xl.kffta.view

import com.xl.kffta.model.TakeOrderBean

interface ITakeOrderView {
    fun refreshAllSuccess(takeOrderBean: TakeOrderBean)
    fun refreshAllFail(msg: String)

    fun loadMoreSuccess(takeOrderBean: TakeOrderBean)
    fun loadMoreFail(msg: String)
}