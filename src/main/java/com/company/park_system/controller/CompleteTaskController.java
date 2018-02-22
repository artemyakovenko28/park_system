package com.company.park_system.controller;

import com.company.park_system.util.MessageManager;
import com.company.park_system.dao.TaskDao;
import com.company.park_system.dao.factory.DaoFactory;
import com.company.park_system.dao.factory.DaoFactoryFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "completeTaskController", urlPatterns = "/completeTask")
public class CompleteTaskController extends HttpServlet {
    private DaoFactory daoFactory = DaoFactoryFactory.createDaoFactory();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskDao taskDao = daoFactory.getTaskDao();

        Integer taskId = Integer.valueOf(req.getParameter("taskId"));
        try {
            taskDao.completeTask(taskId);
            req.setAttribute("taskCompletedMessage", MessageManager.getProperty("message.taskCompleted"));
            resp.sendRedirect(req.getContextPath() + "/personalTasks");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
