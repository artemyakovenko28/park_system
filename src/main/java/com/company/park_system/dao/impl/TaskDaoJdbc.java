package com.company.park_system.dao.impl;

import com.company.park_system.dao.TaskDao;
import com.company.park_system.entity.Task;
import com.company.park_system.util.JdbcUtils;
import com.company.park_system.util.connectionFactory.ConnectionFactoryFactory;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoJdbc implements TaskDao {

    private static final Logger logger = Logger.getLogger(TaskDaoJdbc.class);

    private static final String INSERT_TASK_SQL = "INSERT INTO tasks (userLogin, plantName, type, foresterStatus, ownerStatus) " +
            "VALUES (?, ?, ?, ?, ?)";

    private static final String SELECT_ALL_TASKS_SQL = "SELECT * FROM tasks";

    private static final String SELECT_ALL_TASK_TYPES_SQL = "SELECT * FROM tasktypes";

    private static final String SELECT_COMPLETED_TASKS_SQL =
            "SELECT * FROM tasks WHERE foresterStatus = 'done' AND ownerStatus = 'undone'";

    private static final String DELETE_TASK_SQL = "DELETE FROM tasks WHERE id = ?";

    private static final String SELECT_PERSONAL_TASKS_SQL =
            "SELECT * FROM tasks WHERE userLogin = ? AND foresterStatus = 'undone' AND ownerStatus = 'undone'";

    private static final String UPDATE_FORESTER_TASK_STATUS_SQL =
            "UPDATE tasks SET foresterStatus = 'done' WHERE id = ?";

    private Connection getConnection() throws SQLException {
        return ConnectionFactoryFactory.createConnectionFactory().getConnection();
    }

    private List<Task> getTasks(String sql) throws SQLException {
        Connection conn = getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            List<Task> tasks = new ArrayList<>();
            while (rs.next()) {
                Task task = new Task.TaskBuilder()
                        .id(rs.getInt("id"))
                        .userLogin(rs.getString("userLogin"))
                        .plantName(rs.getString("plantName"))
                        .type(rs.getString("type"))
                        .foresterStatus(rs.getString("foresterStatus"))
                        .ownerStatus(rs.getString("ownerStatus"))
                        .build();
                tasks.add(task);
            }
            logger.info("Select tasks: " + tasks);
            return tasks;
        } finally {
            JdbcUtils.closeQuietly(rs, stmt, conn);
        }
    }

    //owner
    @Override
    public void addTask(Task task) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(INSERT_TASK_SQL);
            stmt.setString(1, task.getUserLogin());
            stmt.setString(2, task.getPlantName());
            stmt.setString(3, task.getType());
            stmt.setString(4, "undone");
            stmt.setString(5, "undone");
            stmt.executeUpdate();
            logger.info("Task added: " + task);
        } finally {
            JdbcUtils.closeQuietly(stmt, conn);
        }
    }

    @Override
    public List<Task> getAllTasks() throws SQLException {
        return getTasks(SELECT_ALL_TASKS_SQL);
    }

    @Override
    public List<String> getAllTaskTypes() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SELECT_ALL_TASK_TYPES_SQL);
            List<String> taskTypes = new ArrayList<>();
            while (rs.next()) {
                taskTypes.add(rs.getString("name"));
            }
            logger.info("Select task types: " + taskTypes);
            return taskTypes;
        } finally {
            JdbcUtils.closeQuietly(rs, stmt, conn);
        }
    }

    @Override
    public List<Task> getCompletedTasks() throws SQLException {
        return getTasks(SELECT_COMPLETED_TASKS_SQL);
    }

    @Override
    public void closeTask(int id) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(DELETE_TASK_SQL);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            logger.info("Task closed, task id = " + id);
        } finally {
            JdbcUtils.closeQuietly(stmt, conn);
        }
    }

    // forester
    @Override
    public List<Task> getPersonalTasks(String userLogin) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(SELECT_PERSONAL_TASKS_SQL);
            stmt.setString(1, userLogin);
            rs = stmt.executeQuery();
            List<Task> personalTasks = new ArrayList<>();
            while (rs.next()) {
                Task task = new Task.TaskBuilder()
                        .id(rs.getInt("id"))
                        .userLogin(rs.getString("userLogin"))
                        .plantName(rs.getString("plantName"))
                        .type(rs.getString("type"))
                        .foresterStatus(rs.getString("foresterStatus"))
                        .ownerStatus(rs.getString("ownerStatus"))
                        .build();
                personalTasks.add(task);
            }
            logger.info("Select personal tasks: " + personalTasks);
            return personalTasks;
        } finally {
            JdbcUtils.closeQuietly(rs, stmt, conn);
        }
    }

    @Override
    public void completeTask(int id) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(UPDATE_FORESTER_TASK_STATUS_SQL);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            logger.info("Task completed, task id = " + id);
        } finally {
            JdbcUtils.closeQuietly(stmt, conn);
        }
    }
}
