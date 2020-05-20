package com.xl.kffta.model

/**
 * @author created by zhanghaochen
 * @date 2020-05-19 17:31
 * 描述：
 */
data class TaskItemInfo(
        var label: String = "",
        var value: String = "",
        var isTitle: Boolean = false,
        var isCheckList: Boolean = false,
        var checkListId: Int = 0
)