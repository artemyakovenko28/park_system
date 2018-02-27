package com.company.park_system.controller;

import com.company.park_system.entity.User;
import com.company.park_system.util.ConfigManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "logoutController", urlPatterns = "/logout")
public class LogOutController extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LogOutController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(SessionAttributes.USER);
        logger.info("User logged out: " + user);
        session.invalidate();
        resp.sendRedirect(req.getContextPath() + ConfigManager.getProperty("page.index"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
