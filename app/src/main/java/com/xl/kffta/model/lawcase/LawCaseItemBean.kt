package com.xl.kffta.model.lawcase

import com.xl.kffta.model.CommonFileBean

/**
 * @author zhanghaochen
 * Date: 2020/5/31
 * 描述：只是方便用来展示的案件条目信息
 */
data class LawCaseItemBean(
        var label: String = "",
        var value: String = "",
        var isEditable: Boolean = false,
        var isBusinessAutoComplete: Boolean = false,// 企业的自动完成文本
        var editAutoCompleteSingleLine: Boolean = true,// 企业自动文本是否单行，第二行是企业代码
        var editHintStr: String = "",
        var editContent: String = "",
        var isDepartmentAutoComplete: Boolean = false,// 部门的自动完成文本
        var isTitle: Boolean = false,
        var titleName: String = "",
        var needUpload: Boolean = false,
        var uploadPath: String = "",
        var businessName: String = "",
        var businessCode: String = "",
        var isLocationAble: Boolean = false,
        var isSingleLine: Boolean = true,// 是否显示单行的高度
        var commonFileBean: CommonFileBean? = null
)