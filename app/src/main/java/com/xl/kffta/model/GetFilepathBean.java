package com.xl.kffta.model;

import java.io.Serializable;

/**
 * @author zhanghaochen
 * Date: 2020/6/6
 * 描述：请求文件的上传路径
 */
public class GetFilepathBean implements Serializable {
    private String Data;
    private Object Error;
    private int ErrorCode;
    private Object ResponseStatus;
    private Object EncryptionData;
    private Object AESEncryptionKey;

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public Object getError() {
        return Error;
    }

    public void setError(Object Error) {
        this.Error = Error;
    }

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public Object getResponseStatus() {
        return ResponseStatus;
    }

    public void setResponseStatus(Object ResponseStatus) {
        this.ResponseStatus = ResponseStatus;
    }

    public Object getEncryptionData() {
        return EncryptionData;
    }

    public void setEncryptionData(Object EncryptionData) {
        this.EncryptionData = EncryptionData;
    }

    public Object getAESEncryptionKey() {
        return AESEncryptionKey;
    }

    public void setAESEncryptionKey(Object AESEncryptionKey) {
        this.AESEncryptionKey = AESEncryptionKey;
    }
}
