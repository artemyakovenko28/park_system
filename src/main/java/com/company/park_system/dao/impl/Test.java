package com.company.park_system.dao.impl;

import com.company.park_system.dao.PlantDao;
import com.company.park_system.dao.TaskDao;
import com.company.park_system.dao.UserDao;
import com.company.park_system.dao.factory.DaoFactory;
import com.company.park_system.dao.factory.DaoFactoryFactory;
import com.company.park_system.entity.Task;
import com.company.park_system.entity.User;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        DaoFactory daoFactory = DaoFactoryFactory.createDaoFactory();
        UserDao userDao = daoFactory.getUserDao();
        TaskDao taskDao = daoFactory.getTaskDao();
        PlantDao plantDao = daoFactory.getPlantDao();

        // Test UserDao
        User user = new User.UserBuilder()
                .login("owner1")
                .password("owner1")
                .build();
        user.setLogin("owner1");
        user.setPassword("owner1");
        System.out.println(userDao.validateUser(user));

        // Test TaskDao
        // getPersonalTasks()
        List<Task> personalTasks = taskDao.getPersonalTasks("f0");
        System.out.println(personalTasks);
        for (Task task : personalTasks) {
            System.out.println(task);
        }

        //completeTask(int id)
        taskDao.completeTask(8);

        //getAllTaskTypes()
        System.out.println(taskDao.getAllTaskTypes());

        //closeTask()
    }
}
