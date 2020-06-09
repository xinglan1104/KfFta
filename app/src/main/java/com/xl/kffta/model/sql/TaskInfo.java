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
    private long id;

    /**
     * 任务的id
     */
    @NotNull
    private long objectId;

    /**
     * 任务执行时间
     */
    @NotNull
    private String executeTime;

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
    @NotNull
    private int companyId;

    /**
     *
     */
    @NotNull
    private int pageCode;

    @Generated(hash = 165688077)
    public TaskInfo(long id, long objectId, @NotNull String executeTime,
            @NotNull String codeName, int excutionStatus, int companyId,
            int pageCode) {
        this.id = id;
        this.objectId = objectId;
        this.executeTime = executeTime;
        this.codeName = codeName;
        this.excutionStatus = excutionStatus;
        this.companyId = companyId;
        this.pageCode = pageCode;
    }

    @Generated(hash = 2022720704)
    public TaskInfo() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExecuteTime() {
        return this.executeTime;
    }

    public void setExecuteTime(String executeTime) {
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

    public long getObjectId() {
        return this.objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }
}
