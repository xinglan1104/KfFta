package com.xl.kffta.util

/**
 * @author created by zhanghaochen
 * @date 2020-05-16 15:01
 * 描述：
 */
object ApplicationParams {
    public var TOKEN: String by SpUtil("TOKEN", "")
    public var USER_ID: Long = 0L
    var USER_NAME: String = ""
    var USER_PHONE: String = ""
    var USER_ADDRESS: String = ""
    var USER_DEPARTMENTS: String by SpUtil(USER_ID.toString(), "")

    /**
     * 方便起见，文件的路径直接保存全局变量
     */
    var TEMP_FILE_PATH: String = ""
}
