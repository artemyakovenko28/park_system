package com.company.park_system.util.connectionFactory;

import com.company.park_system.dao.impl.PlantDaoJdbc;
import com.company.park_system.dao.impl.TaskDaoJdbc;

import java.sql.*;

public class Test {
    public static void main(String[] args) throws SQLException {
        // test ConnectionFactory
        Connection conn = ConnectionFactoryFactory.createConnectionFactory().getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM plants");
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        // test PlantDaoJdbc
        System.out.println(new PlantDaoJdbc().getAllPlants());

        // testTaskDaoJdbc
        System.out.println(new TaskDaoJdbc().getAllTasks());

        System.out.println();
        long time = System.nanoTime();
        long seconds = time / 1_000_000_000;
        long remainSeconds = seconds % 60;
        long minutes = seconds / 60;
        long remainMinutes = minutes % 60;
        long hours = minutes / 60;
        long remainHours = hours % 60;
        long days = hours / 24;

        System.out.println("Time from starting the PC: ");
        System.out.println(days + " days " + remainHours + " hours " +
                remainMinutes + " minutes " + remainSeconds + " seconds.");


    }
}
