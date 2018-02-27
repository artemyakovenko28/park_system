package com.company.park_system.dao.impl;

import com.company.park_system.dao.PlantDao;
import com.company.park_system.entity.Plant;
import com.company.park_system.util.JdbcUtils;
import com.company.park_system.util.connectionFactory.ConnectionFactoryFactory;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlantDaoJdbc implements PlantDao {
    private static final Logger logger = Logger.getLogger(PlantDaoJdbc.class);

    private static final String SELECT_ALL_SQL = "SELECT name FROM plants";

    private Connection getConnection() throws SQLException {
        return ConnectionFactoryFactory.createConnectionFactory().getConnection();
    }

    @Override
    public List<Plant> getAllPlants() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SELECT_ALL_SQL);
            List<Plant> plants = new ArrayList<>();
            while (rs.next()) {
                Plant plant = new Plant.PlantBuilder()
                        .name(rs.getString("name"))
                        .build();
                plants.add(plant);
            }
            logger.info("Select all plants: " + plants);
            return plants;
        } finally {
            JdbcUtils.closeQuietly(rs, stmt, conn);
        }
    }
}
