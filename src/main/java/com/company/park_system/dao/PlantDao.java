package com.company.park_system.dao;

import com.company.park_system.entity.Plant;

import java.sql.SQLException;
import java.util.List;

public interface PlantDao {
    List<Plant> getAllPlants() throws SQLException;
}
