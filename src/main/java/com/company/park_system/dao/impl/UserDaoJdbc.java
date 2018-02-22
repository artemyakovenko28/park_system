package com.company.park_system.dao.impl;

import com.company.park_system.dao.UserDao;
import com.company.park_system.entity.User;
import com.company.park_system.util.JdbcUtils;
import com.company.park_system.util.connectionFactory.ConnectionFactoryFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbc implements UserDao {
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
                return true;
            }
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
                User user = new User();
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setStatus(rs.getString("status"));
                foresters.add(user);
            }
            return foresters;
        } finally {
            JdbcUtils.closeQuietly(rs, stmt, conn);
        }
    }
}