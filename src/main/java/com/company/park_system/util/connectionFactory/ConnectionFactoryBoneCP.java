package com.company.park_system.util.connectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryBoneCP implements ConnectionFactory {

    @Override
    public Connection getConnection() throws SQLException {
        return ConnectionPool.getInstance().getConnection();
    }
}
