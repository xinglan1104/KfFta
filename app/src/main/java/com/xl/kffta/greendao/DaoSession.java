package com.xl.kffta.greendao;

import com.xl.kffta.model.sql.TaskInfo;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.Map;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig taskInfoDaoConfig;

    private final TaskInfoDao taskInfoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        taskInfoDaoConfig = daoConfigMap.get(TaskInfoDao.class).clone();
        taskInfoDaoConfig.initIdentityScope(type);

        taskInfoDao = new TaskInfoDao(taskInfoDaoConfig, this);

        registerDao(TaskInfo.class, taskInfoDao);
    }

    public void clear() {
        taskInfoDaoConfig.clearIdentityScope();
    }

    public TaskInfoDao getTaskInfoDao() {
        return taskInfoDao;
    }

}
