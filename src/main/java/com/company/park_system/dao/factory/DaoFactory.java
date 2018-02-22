package com.company.park_system.dao.factory;

import com.company.park_system.dao.PlantDao;
import com.company.park_system.dao.TaskDao;
import com.company.park_system.dao.UserDao;

public interface DaoFactory {
    PlantDao getPlantDao();

    TaskDao getTaskDao();

    UserDao getUserDao();
}
