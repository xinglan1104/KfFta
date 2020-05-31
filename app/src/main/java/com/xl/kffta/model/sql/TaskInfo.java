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
    @Id(autoincrement = false)
    private long id;

    @NotNull
    private String executeTime;

    @NotNull
    private String codeName;

    @NotNull
    private int excutionStatus;

    @Generated(hash = 1707636330)
    public TaskInfo(long id, @NotNull String executeTime, @NotNull String codeName,
                    int excutionStatus) {
        this.id = id;
        this.executeTime = executeTime;
        this.codeName = codeName;
        this.excutionStatus = excutionStatus;
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
}
