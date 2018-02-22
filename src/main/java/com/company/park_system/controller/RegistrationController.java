package com.company.park_system.controller;

import com.company.park_system.dao.UserDao;
import com.company.park_system.dao.factory.DaoFactory;
import com.company.park_system.dao.factory.DaoFactoryFactory;
import com.company.park_system.entity.User;
import com.company.park_system.util.ConfigManager;
import com.company.park_system.util.MessageManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "registrationController", urlPatterns = "/registration")
public class RegistrationController extends HttpServlet {

    private DaoFactory daoFactory = DaoFactoryFactory.createDaoFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(ConfigManager.getProperty("path.page.registration")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = daoFactory.getUserDao();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String status = req.getParameter("status");

        boolean emptyField = false;
        if (login == null || login.equals("")) {
            req.setAttribute("emptyLogin", MessageManager.getProperty("message.emptyLogin"));
            emptyField = true;
        }
        if (password == null || password.equals("")) {
            req.setAttribute("emptyPassword", MessageManager.getProperty("message.emptyPassword"));
            emptyField = true;
        }
        if (status == null || status.equals("")) {
            req.setAttribute("emptyPassword", MessageManager.getProperty("message.emptyStatus"));
            emptyField = true;
        }
        if (emptyField) {
            req.getRequestDispatcher(ConfigManager.getProperty("path.page.registration")).forward(req, resp);
        } else {
            try {
                if (userDao.userExists(login)) {
                    req.setAttribute("userExists", MessageManager.getProperty("message.userExists"));
                    req.getRequestDispatcher(ConfigManager.getProperty("path.page.registration")).forward(req, resp);
                } else {
                    User user = new User();
                    user.setLogin(login);
                    user.setPassword(password);
                    user.setStatus(status);
                    userDao.registerUser(user);
                    req.setAttribute("registrationCompleted", MessageManager.getProperty("message.registrationCompleted"));
                    req.getRequestDispatcher(ConfigManager.getProperty("path.page.registration")).forward(req, resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
