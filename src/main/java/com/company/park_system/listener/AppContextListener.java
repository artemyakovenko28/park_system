package com.company.park_system.listener;

import com.company.park_system.util.connectionFactory.ConnectionPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        Close ConnectionPool
        ConnectionPool.getInstance().close();

        try {
//            log.info("Calling MySQL AbandonedConnectionCleanupThread shutdown");
            com.mysql.jdbc.AbandonedConnectionCleanupThread.shutdown();

        } catch (InterruptedException e) {
//            log.error("Error calling MySQL AbandonedConnectionCleanupThread shutdown {}", e);
        }

        ClassLoader cl = Thread.currentThread().getContextClassLoader();

        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();

            if (driver.getClass().getClassLoader() == cl) {

                try {
//                    log.info("Deregistering JDBC driver {}", driver);
                    DriverManager.deregisterDriver(driver);

                } catch (SQLException ex) {
//                    log.error("Error deregistering JDBC driver {}", driver, ex);
                }

            } else {
//                log.trace("Not deregistering JDBC driver {} as it does not belong to this webapp's ClassLoader", driver);
            }
        }
    }
}
