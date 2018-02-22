package com.company.park_system.controller;

import com.company.park_system.util.ConfigManager;
import com.company.park_system.dao.TaskDao;
import com.company.park_system.dao.factory.DaoFactory;
import com.company.park_system.dao.factory.DaoFactoryFactory;
import com.company.park_system.entity.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "allTasksController", urlPatterns = "/allTasks")
public class AllTasksController extends HttpServlet {
    private DaoFactory daoFactory = DaoFactoryFactory.createDaoFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskDao taskDao = daoFactory.getTaskDao();

        try {
            List<Task> allTasks = taskDao.getAllTasks();
            req.setAttribute("allTasks", allTasks);
            req.getRequestDispatcher(ConfigManager.getProperty("path.page.allTasks")).forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
