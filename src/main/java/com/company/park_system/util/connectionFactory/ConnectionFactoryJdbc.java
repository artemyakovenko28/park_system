package com.company.park_system.util.connectionFactory;

import com.company.park_system.util.ConfigManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryJdbc implements ConnectionFactory {
    private static final String JDBC_URL = ConfigManager.getProperty("jdbc.url");
    private static final String DATABASE_LOGIN = ConfigManager.getProperty("jdbc.username");
    private static final String DATABASE_PASSWORD = ConfigManager.getProperty("jdbc.password");

    public ConnectionFactoryJdbc() throws ClassNotFoundException {
        Class.forName(ConfigManager.getProperty("jdbc.driverClassName"));
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, DATABASE_LOGIN, DATABASE_PASSWORD);
    }
}
