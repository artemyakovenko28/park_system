package com.company.park_system.dao;

import com.company.park_system.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void registerUser(User user) throws SQLException;

    boolean validateUser(User user) throws SQLException;

    boolean userExists(String login) throws SQLException;

    List<User> getAllForesters() throws SQLException;
}
