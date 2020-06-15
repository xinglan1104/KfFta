package com.xl.kffta.model.warn

import com.xl.kffta.model.CommonFileBean

/**
 * @author zhanghaochen
 * Date: 2020/6/13
 * 描述：只是方便用来展示的预警条目信息
 */
data class WarnItemBean(
        var label: String = "",
        var value: String = "",
        var isEditAble: Boolean = false,
        var editHint: String = "",
        var isTimeSelect: Boolean = false,
        var isSelectDepart: Boolean = false,
        var isUploadFile: Boolean = false,
        var commonFileBean: CommonFileBean? = null
)