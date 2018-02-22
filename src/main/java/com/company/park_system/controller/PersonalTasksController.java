package com.company.park_system.controller;

import com.company.park_system.util.ConfigManager;
import com.company.park_system.util.MessageManager;
import com.company.park_system.dao.TaskDao;
import com.company.park_system.dao.factory.DaoFactory;
import com.company.park_system.dao.factory.DaoFactoryFactory;
import com.company.park_system.entity.Task;
import com.company.park_system.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "personalTasksController", urlPatterns = "/personalTasks")
public class PersonalTasksController extends HttpServlet {

    private DaoFactory daoFactory = DaoFactoryFactory.createDaoFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskDao taskDao = daoFactory.getTaskDao();

        User forester = (User) req.getSession().getAttribute("user");
        try {
            List<Task> personalTasks = taskDao.getPersonalTasks(forester.getLogin());
            req.setAttribute("personalTasks", personalTasks);
            req.getRequestDispatcher(ConfigManager.getProperty("path.page.personalTasks")).forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            // установка страницы c cообщением об ошибке
            String page = ConfigManager.getProperty("path.page.index");
            req.setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
            resp.sendRedirect(req.getContextPath() + page);
        }
    }
}
