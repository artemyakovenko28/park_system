package com.company.park_system.entity;

public class Task {
    private int id;
    private String userLogin;
    private String plantName;
    private String type;
    private String foresterStatus;
    private String ownerStatus;

    public Task() {
    }

    public Task(int id, String userLogin, String plantName,
                String type, String foresterStatus, String ownerStatus) {
        this.id = id;
        this.userLogin = userLogin;
        this.plantName = plantName;
        this.type = type;
        this.foresterStatus = foresterStatus;
        this.ownerStatus = ownerStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForesterStatus() {
        return foresterStatus;
    }

    public void setForesterStatus(String foresterStatus) {
        this.foresterStatus = foresterStatus;
    }

    public String getOwnerStatus() {
        return ownerStatus;
    }

    public void setOwnerStatus(String ownerStatus) {
        this.ownerStatus = ownerStatus;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", userLogin='" + userLogin + '\'' +
                ", plantName='" + plantName + '\'' +
                ", type='" + type + '\'' +
                ", foresterStatus='" + foresterStatus + '\'' +
                ", ownerStatus='" + ownerStatus + '\'' +
                '}';
    }
}
