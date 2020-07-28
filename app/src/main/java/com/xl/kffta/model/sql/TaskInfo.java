package com.xl.kffta.model.sql;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * @author zhanghaochen
 * Date: 2020/5/31
 * 描述：普通任务实体类，保存简单信息
 */
@Entity
public class TaskInfo {
    /**
     * 主键id
     */
    @Id(autoincrement = true)
    private Long id = null;

    /**
     * 任务的id
     */
    @NotNull
    private long objectId;

    /**
     * 任务执行时间
     */
    @NotNull
    private long executeTime;

    /**
     * 任务分类，是任务还是执法任务
     */
    @NotNull
    private String codeName;

    /**
     * 任务的执行状态，0是未执行，1是执行完成
     */
    @NotNull
    private int excutionStatus;

    /**
     * 公司编号
     */
    private int companyId;

    /**
     * 传0就行
     */
    @NotNull
    private int pageCode;

    @NotNull
    private String token;

    @Generated(hash = 2110125038)
    public TaskInfo(Long id, long objectId, long executeTime,
                    @NotNull String codeName, int excutionStatus, int companyId,
                    int pageCode, @NotNull String token) {
        this.id = id;
        this.objectId = objectId;
        this.executeTime = executeTime;
        this.codeName = codeName;
        this.excutionStatus = excutionStatus;
        this.companyId = companyId;
        this.pageCode = pageCode;
        this.token = token;
    }

    @Generated(hash = 2022720704)
    public TaskInfo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getObjectId() {
        return this.objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public long getExecuteTime() {
        return this.executeTime;
    }

    public void setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
    }

    public String getCodeName() {
        return this.codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public int getExcutionStatus() {
        return this.excutionStatus;
    }

    public void setExcutionStatus(int excutionStatus) {
        this.excutionStatus = excutionStatus;
    }

    public int getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getPageCode() {
        return this.pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
