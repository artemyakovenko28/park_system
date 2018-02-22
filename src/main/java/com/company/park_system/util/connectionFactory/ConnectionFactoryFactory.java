package com.company.park_system.util.connectionFactory;

import com.company.park_system.util.ConfigManager;

public class ConnectionFactoryFactory {
    public static ConnectionFactory createConnectionFactory() {
        ConnectionFactory connectionFactory = null;
        try {
            connectionFactory = (ConnectionFactory) Class.forName(ConfigManager.getProperty("connectionFactory"))
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            System.out.println("Can't create instance of ConnectionFactory!");
        }
        return connectionFactory;
    }
}
