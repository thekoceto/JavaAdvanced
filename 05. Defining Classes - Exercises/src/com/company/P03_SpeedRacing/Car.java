package com.company.P03_SpeedRacing;

public class Car {
    //Model, fuel amount, fuel cost for 1 kilometer and distance traveled
    private String model;
    private double fuelAmount;
    private double cost;
    private int distance;

    public Car(String model, int fuelAmount, double cost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.cost = cost;
        this.distance = 0;
    }

    public double getFuel() {
        return this.fuelAmount;
    }

    public double getCost() {
        return this.cost;
    }

    public int getDistance() {
        return this.distance;
    }

    public void decreaseFuel(double fuelAmount) {
        this.fuelAmount -= fuelAmount;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void increaseDistance(int distance) {
        this.distance += distance;
    }
}
