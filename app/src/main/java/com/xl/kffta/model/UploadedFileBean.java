package com.xl.kffta.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author wangyuefei
 */

public class UploadedFileBean implements Serializable {
    private String Error;
    private int ErrorCode;
    private ArrayList<String> FileNames = new ArrayList<>();


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

    public ArrayList<String> getFileNames() {
        return FileNames;
    }

    public void setFileNames(ArrayList<String> Data) {
        this.FileNames = Data;
    }
}
