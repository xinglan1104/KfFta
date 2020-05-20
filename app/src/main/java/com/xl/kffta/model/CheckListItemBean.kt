package com.xl.kffta.model

/**
 * @author created by zhanghaochen
 * @date 2020-05-20 12:37
 * 描述：专门用于事件清单单个条目的实例类
 */
data class CheckListItemBean(
        var label: String = "",
        var value: String = "",
        var title: String = "",// 如果是标题，显示标题字段
        var isTitle: Boolean = false,//是否是标题
        var isClickable: Boolean = true,//是否可点击，true为可点击
        var dialogName: String = "",
        var dialogValue: String = ""
)