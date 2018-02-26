package com.company.park_system.entity;

public class Task {
    private int id;
    private String userLogin;
    private String plantName;
    private String type;
    private String foresterStatus;
    private String ownerStatus;

    private Task(TaskBuilder builder) {
        this.id = builder.id;
        this.userLogin = builder.userLogin;
        this.plantName = builder.plantName;
        this.type = builder.type;
        this.foresterStatus = builder.foresterStatus;
        this.ownerStatus = builder.ownerStatus;
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

    public static class TaskBuilder {
        private int id;
        private String userLogin;
        private String plantName;
        private String type;
        private String foresterStatus;
        private String ownerStatus;

        public TaskBuilder() {
        }

        public TaskBuilder id(int id) {
            this.id = id;
            return this;
        }

        public TaskBuilder userLogin(String userLogin) {
            this.userLogin = userLogin;
            return this;
        }

        public TaskBuilder plantName(String plantName) {
            this.plantName = plantName;
            return this;
        }

        public TaskBuilder type(String type) {
            this.type = type;
            return this;
        }

        public TaskBuilder foresterStatus(String foresterStatus) {
            this.foresterStatus = foresterStatus;
            return this;
        }

        public TaskBuilder ownerStatus(String ownerStatus) {
            this.ownerStatus = ownerStatus;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
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
