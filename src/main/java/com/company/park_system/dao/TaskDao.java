package com.company.park_system.dao;

import com.company.park_system.entity.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskDao {
    // owner
    void addTask(Task task) throws SQLException;

    List<Task> getAllTasks() throws SQLException;

    List<String> getAllTaskTypes() throws SQLException;

    List<Task> getCompletedTasks() throws SQLException;

    void closeTask(int id) throws SQLException;

    // forester
    List<Task> getPersonalTasks(String userLogin) throws SQLException;

    void completeTask(int id) throws SQLException;

}
