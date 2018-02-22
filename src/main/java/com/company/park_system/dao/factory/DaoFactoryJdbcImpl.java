package com.company.park_system.dao.factory;

import com.company.park_system.dao.PlantDao;
import com.company.park_system.dao.TaskDao;
import com.company.park_system.dao.UserDao;
import com.company.park_system.dao.impl.PlantDaoJdbc;
import com.company.park_system.dao.impl.TaskDaoJdbc;
import com.company.park_system.dao.impl.UserDaoJdbc;

public class DaoFactoryJdbcImpl implements DaoFactory{

    @Override
    public PlantDao getPlantDao() {
        return new PlantDaoJdbc();
    }

    @Override
    public TaskDao getTaskDao() {
        return new TaskDaoJdbc();
    }

    @Override
    public UserDao getUserDao() {
        return new UserDaoJdbc();
    }
}
