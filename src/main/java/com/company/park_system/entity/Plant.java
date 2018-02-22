package com.company.park_system.entity;

public class Plant {
    private String name;

    public Plant() {
    }

    public Plant(int id, String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                '}';
    }
}
