package com.company.park_system.controller;

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

@WebServlet(name = "closeTaskController", urlPatterns = "/closeTask")
public class CloseTaskController extends HttpServlet {
    private DaoFactory daoFactory = DaoFactoryFactory.createDaoFactory();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskDao taskDao = daoFactory.getTaskDao();

        Integer id = Integer.valueOf(req.getParameter("taskId"));
        try {
            taskDao.closeTask(id);
            resp.sendRedirect(req.getContextPath() + "/completedTasks");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
