package com.xl.kffta.model

/**
 * @author created by zhanghaochen
 * @date 2020-05-21 15:22
 * 描述：项目检查任务详情的bean，仅用来展示内容
 */
class JointTaskInfoItem(
    var label: String = "",
    var value: String = "",
    var isClickable: Boolean = false,
    var checkStateName: String = "",
    var deparmentName: String = "",
    var riskInfo: String = ""
)
