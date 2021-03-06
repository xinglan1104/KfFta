package com.xl.kffta.model

/**
 * @author created by zhanghaochen
 * @date 2020-05-19 17:31
 * 描述：专门用于任务信息单个条目的实例类
 */
data class TaskItemInfo(
        var label: String = "",
        var value: String = "",
        var isTitle: Boolean = false,
        var isCheckList: Boolean = false,
        var checkListId: Int = 0,
        var isBusinessTv: Boolean = false,
        var businessCode: String = "",
        var businessPeople: String = "",
        var businessCreateTime: String = "",
        var isEditable: Boolean = false,
        var isDatePicker: Boolean = false,
        var isLocationAble: Boolean = false,
        var needUpLoadFile: Boolean = false,
        var upLoadFileEnable: Boolean = false,
        var commonFileBean: CommonFileBean? = null,
        var isSingleLine: Boolean = true //是否显示单行
)