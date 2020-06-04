package com.xl.kffta.model.lawcase

/**
 * @author zhanghaochen
 * Date: 2020/5/31
 * 描述：只是方便用来展示的案件条目信息
 */
data class LawCaseItemBean(
        var label: String = "",
        var value: String = "",
        var isEditable: Boolean = false,
        var isEditAutoComplete: Boolean = false,
        var editHintStr: String = "",
        var editContent: String = "",
        var isShowSelector: Boolean = false,
        var isTitle: Boolean = false,
        var titleName: String = ""
)