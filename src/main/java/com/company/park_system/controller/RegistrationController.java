package com.company.park_system.controller;

import com.company.park_system.dao.UserDao;
import com.company.park_system.dao.factory.DaoFactory;
import com.company.park_system.dao.factory.DaoFactoryFactory;
import com.company.park_system.entity.User;
import com.company.park_system.util.ConfigManager;
import com.company.park_system.util.MessageManager;
import com.company.park_system.validator.UserValidator;
import com.company.park_system.validator.Validator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "registrationController", urlPatterns = "/registration")
public class RegistrationController extends HttpServlet {

    private DaoFactory daoFactory = DaoFactoryFactory.createDaoFactory();

    private Validator<User> validator = new UserValidator();

    private static final Logger logger = Logger.getLogger(RegistrationController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(ConfigManager.getProperty("page.registration")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = daoFactory.getUserDao();

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String status = req.getParameter("status");

        User user = new User.UserBuilder()
                .login(login)
                .password(password)
                .status(status)
                .build();
        Map<String, String> errorMap = validator.validate(user);
        logger.info("Validation of user with login " + user.getLogin() + " completed, errorMap: " + errorMap);
        if (!errorMap.isEmpty()) {
            req.setAttribute("errorMap", errorMap);
            req.getRequestDispatcher(ConfigManager.getProperty("page.registration")).forward(req, resp);
        } else {
            try {
                if (userDao.userExists(login)) {
                    req.setAttribute("userExists", MessageManager.getProperty("message.userExists"));
                    req.getRequestDispatcher(ConfigManager.getProperty("page.registration")).forward(req, resp);
                } else {
                    userDao.registerUser(user);
                    req.setAttribute("registrationCompleted", MessageManager.getProperty("message.registrationCompleted"));
                    req.getRequestDispatcher(ConfigManager.getProperty("page.registration")).forward(req, resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}