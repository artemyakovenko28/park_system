package com.company.park_system.controller;

import com.company.park_system.util.ConfigManager;
import com.company.park_system.util.MessageManager;
import com.company.park_system.dao.UserDao;
import com.company.park_system.dao.factory.DaoFactory;
import com.company.park_system.dao.factory.DaoFactoryFactory;
import com.company.park_system.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "loginController", urlPatterns = "/home")
public class LoginController extends HttpServlet {
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";

    private DaoFactory daoFactory = DaoFactoryFactory.createDaoFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String status = user.getStatus();
        if (status.equals("forester")) {
            req.getRequestDispatcher(ConfigManager.getProperty("path.page.homeForester")).forward(req, resp);
        }
        if (status.equals("owner")) {
            req.getRequestDispatcher(ConfigManager.getProperty("path.page.homeOwner")).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = daoFactory.getUserDao();

        User user = new User();
        user.setLogin(req.getParameter(PARAM_LOGIN));
        user.setPassword(req.getParameter(PARAM_PASSWORD));

        try {
            if (userDao.validateUser(user)) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                String status = user.getStatus();
                if (status.equals("forester")) {
                    req.getRequestDispatcher(ConfigManager.getProperty("path.page.homeForester")).forward(req, resp);
                }
                if (status.equals("owner")) {
                    req.getRequestDispatcher(ConfigManager.getProperty("path.page.homeOwner")).forward(req, resp);
                }
            } else {
                req.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
                req.getRequestDispatcher(ConfigManager.getProperty("path.page.index")).forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // установка страницы c cообщением об ошибке
            String page = ConfigManager.getProperty("path.page.index");
            req.setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
            resp.sendRedirect(req.getContextPath() + page);
        }
    }
}
