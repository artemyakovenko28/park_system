package com.company.park_system.controller;

import com.company.park_system.util.ConfigManager;
import com.company.park_system.dao.PlantDao;
import com.company.park_system.dao.TaskDao;
import com.company.park_system.dao.UserDao;
import com.company.park_system.dao.factory.DaoFactory;
import com.company.park_system.dao.factory.DaoFactoryFactory;
import com.company.park_system.entity.Plant;
import com.company.park_system.entity.Task;
import com.company.park_system.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "addTaskController", urlPatterns = "/addTask")
public class AddTaskController extends HttpServlet {
    private DaoFactory daoFactory = DaoFactoryFactory.createDaoFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskDao taskDao = daoFactory.getTaskDao();
        UserDao userDao = daoFactory.getUserDao();
        PlantDao plantDao = daoFactory.getPlantDao();

        try {
            List<User> foresters = userDao.getAllForesters();
            List<Plant> plants = plantDao.getAllPlants();
            List<String> taskTypes = taskDao.getAllTaskTypes();

            req.setAttribute("foresters", foresters);
            req.setAttribute("plants", plants);
            req.setAttribute("taskTypes", taskTypes);

            req.getRequestDispatcher(ConfigManager.getProperty("path.page.addTask")).forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskDao taskDao = daoFactory.getTaskDao();

        String userLogin = req.getParameter("userLogin");
        String plantName = req.getParameter("plantName");
        String taskType = req.getParameter("taskType");
//        if (userLogin == null || plantName == null || taskType == null) {
//            // send redirect -> error page
//        }
        PrintWriter writer = resp.getWriter();
        writer.println(userLogin);
        writer.println((plantName));
        writer.println(taskType);
        Task task = new Task.TaskBuilder()
                .userLogin(userLogin)
                .plantName(plantName)
                .type(taskType)
                .build();
        task.setUserLogin(userLogin);
        task.setPlantName(plantName);
        task.setType(taskType);
        try {
            taskDao.addTask(task);
            resp.sendRedirect(req.getContextPath() + "/addTask");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
