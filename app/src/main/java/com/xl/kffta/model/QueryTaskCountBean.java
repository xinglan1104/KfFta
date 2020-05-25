package com.xl.kffta.model;

import java.io.Serializable;

/**
 * @author created by zhanghaochen
 * @date 2020-05-25 16:10
 * 描述：查询首页各个任务数量的实例类
 */
public class QueryTaskCountBean implements Serializable {

    /**
     * PendingClaimedEnforcementTaskCount : 0
     * PendingExcutedEnforcementTaskCount : 1
     * ExcutedEnforcementTaskCount : 1
     * PendingClaimedProjectTaskCount : 0
     * PendingExcutedProjectTaskCount : 0
     * ExcutedProjectTaskCount : 0
     * Error : null
     * ErrorCode : 0
     * ResponseStatus : null
     * EncryptionData : null
     * AESEncryptionKey : null
     */

    private int PendingClaimedEnforcementTaskCount;
    private int PendingExcutedEnforcementTaskCount;
    private int ExcutedEnforcementTaskCount;
    private int PendingClaimedProjectTaskCount;
    private int PendingExcutedProjectTaskCount;
    private int ExcutedProjectTaskCount;
    private String Error;
    private int ErrorCode;

    public int getPendingClaimedEnforcementTaskCount() {
        return PendingClaimedEnforcementTaskCount;
    }

    public void setPendingClaimedEnforcementTaskCount(int PendingClaimedEnforcementTaskCount) {
        this.PendingClaimedEnforcementTaskCount = PendingClaimedEnforcementTaskCount;
    }

    public int getPendingExcutedEnforcementTaskCount() {
        return PendingExcutedEnforcementTaskCount;
    }

    public void setPendingExcutedEnforcementTaskCount(int PendingExcutedEnforcementTaskCount) {
        this.PendingExcutedEnforcementTaskCount = PendingExcutedEnforcementTaskCount;
    }

    public int getExcutedEnforcementTaskCount() {
        return ExcutedEnforcementTaskCount;
    }

    public void setExcutedEnforcementTaskCount(int ExcutedEnforcementTaskCount) {
        this.ExcutedEnforcementTaskCount = ExcutedEnforcementTaskCount;
    }

    public int getPendingClaimedProjectTaskCount() {
        return PendingClaimedProjectTaskCount;
    }

    public void setPendingClaimedProjectTaskCount(int PendingClaimedProjectTaskCount) {
        this.PendingClaimedProjectTaskCount = PendingClaimedProjectTaskCount;
    }

    public int getPendingExcutedProjectTaskCount() {
        return PendingExcutedProjectTaskCount;
    }

    public void setPendingExcutedProjectTaskCount(int PendingExcutedProjectTaskCount) {
        this.PendingExcutedProjectTaskCount = PendingExcutedProjectTaskCount;
    }

    public int getExcutedProjectTaskCount() {
        return ExcutedProjectTaskCount;
    }

    public void setExcutedProjectTaskCount(int ExcutedProjectTaskCount) {
        this.ExcutedProjectTaskCount = ExcutedProjectTaskCount;
    }

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
