package com.company.P10_test;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";

    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = color;
    }

    public Car(String model, Engine engine,int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        if (weight == -1) {
            return String.format("Weight: n/a%nColor: %s%n", this.color);
        } else {
            return String.format("Weight: %d%nColor: %s%n", this.weight, this.color);
        }
    }

}