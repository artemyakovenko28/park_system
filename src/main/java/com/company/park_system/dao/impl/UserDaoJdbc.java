package com.company.park_system.dao.impl;

import com.company.park_system.dao.UserDao;
import com.company.park_system.entity.User;
import com.company.park_system.util.JdbcUtils;
import com.company.park_system.util.connectionFactory.ConnectionFactoryFactory;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbc implements UserDao {

    private static final Logger logger = Logger.getLogger(UserDaoJdbc.class);

    private static final String INSERT_USER_SQL = "INSERT INTO users (login, password, status) " +
            "VALUES (?, ?, ?)";

    private static final String SELECT_BY_LOGIN_AND_PASSWORD_SQL = "SELECT * FROM users WHERE login = ? AND password = ?";

    private static final String SELECT_BY_LOGIN_SQL = "SELECT * FROM users WHERE login = ?";

    private static final String SELECT_BY_STATUS_SQL = "SELECT * FROM users WHERE status = ?";

    private Connection getConnection() throws SQLException {
        return ConnectionFactoryFactory.createConnectionFactory().getConnection();

    }
    @Override
    public void registerUser(User user) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(INSERT_USER_SQL);
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getStatus());
            stmt.executeUpdate();
            logger.info("User registered: " + user);
        } finally {
            JdbcUtils.closeQuietly(stmt, conn);
        }
    }

    @Override
    public boolean validateUser(User user) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(SELECT_BY_LOGIN_AND_PASSWORD_SQL);
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            rs = stmt.executeQuery();
            if (rs.next()) {
                user.setStatus(rs.getString("status"));
                logger.info("User with login '" + user.getLogin() +
                        "' and password '" + user.getPassword() + "' logged in");
                return true;
            }
            logger.info("No user for login '" + user.getLogin() +
                    "' and password '" + user.getPassword() + "'");
            return false;
        } finally {
            JdbcUtils.closeQuietly(conn, stmt, rs);
        }
    }

    @Override
    public boolean userExists(String login) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(SELECT_BY_LOGIN_SQL);
            stmt.setString(1, login);
            rs = stmt.executeQuery();
            if (rs.next()) {
                logger.info("User with login " + login + "already exists");
                return true;
            }
            return false;
        } finally {
            JdbcUtils.closeQuietly(rs, stmt, conn);
        }
    }

    @Override
    public List<User> getAllForesters() throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(SELECT_BY_STATUS_SQL);
            stmt.setString(1, "forester");
            rs = stmt.executeQuery();
            List<User> foresters = new ArrayList<>();
            while (rs.next()) {
                User user = new User.UserBuilder()
                        .login(rs.getString("login"))
                        .password(rs.getString("password"))
                        .status(rs.getString("status"))
                        .build();
                foresters.add(user);
            }
            logger.info("Select all foresters: " + foresters);
            return foresters;
        } finally {
            JdbcUtils.closeQuietly(rs, stmt, conn);
        }
    }
}
