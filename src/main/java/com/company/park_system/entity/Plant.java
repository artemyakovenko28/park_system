package com.company.park_system.entity;

public class Plant {
    private String name;

    private Plant(PlantBuilder builder) {
        this.name = builder.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final class PlantBuilder {
        private String name;

        public PlantBuilder() {
        }

        public PlantBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Plant build() {
            return new Plant(this);
        }
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                '}';
    }
}
