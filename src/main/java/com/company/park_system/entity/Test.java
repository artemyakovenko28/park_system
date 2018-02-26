package com.company.park_system.entity;

public class Test {
    public static void main(String[] args) {
        Plant plant = new Plant.PlantBuilder()
                .name("name")
                .build();
        System.out.println(plant);

        Task task = new Task.TaskBuilder()
                .id(0)
                .userLogin("userLogin")
                .plantName("plantName")
                .type("type")
                .foresterStatus("foresterStatus")
                .ownerStatus("ownerStatus")
                .build();
        System.out.println(task);

        User user = new User.UserBuilder()
                .login("login")
                .password("password")
                .status("status")
                .build();
        System.out.println(user);
    }
}
