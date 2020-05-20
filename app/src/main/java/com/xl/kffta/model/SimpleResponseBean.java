package com.xl.kffta.model;

/**
 * @author created by zhanghaochen
 * @date 2020-05-20 14:10
 * 描述：只有错误代码和信息的实例类
 */
public class SimpleResponseBean {

    private String Error;
    private int ErrorCode;

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int ErrorCode) {
        this.ErrorCode = ErrorCode;
    }
}
