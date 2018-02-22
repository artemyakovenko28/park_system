package com.company.park_system.util.connectionFactory;

import com.company.park_system.util.ConfigManager;
import com.jolbox.bonecp.BoneCPDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static ConnectionPool connectionPool;
    private BoneCPDataSource boneCPDataSource;

    private ConnectionPool() throws ClassNotFoundException {
        Class.forName(ConfigManager.getProperty("jdbc.driverClassName"));
        boneCPDataSource = new BoneCPDataSource();
        boneCPDataSource.setJdbcUrl(ConfigManager.getProperty("jdbc.url"));
        boneCPDataSource.setUsername(ConfigManager.getProperty("jdbc.username"));
        boneCPDataSource.setPassword(ConfigManager.getProperty("jdbc.password"));
    }

    public static synchronized ConnectionPool getInstance() {
        if (connectionPool == null) {
            try {
                connectionPool = new ConnectionPool();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connectionPool;
    }

    public Connection getConnection() throws SQLException {
        return boneCPDataSource.getConnection();
    }

    public void close() {
        boneCPDataSource.close();
    }
}
