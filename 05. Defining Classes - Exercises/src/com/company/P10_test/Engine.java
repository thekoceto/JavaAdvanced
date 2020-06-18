package com.company.P10_test;

public class Engine {
    private String engineModel;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.engineModel = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power, displacement);
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        if (this.displacement == -1) {
            return String.format("%s:%nPower: %d%nDisplacement: n/a%nEfficiency: %s%n",
                    this.engineModel, this.power, this.efficiency);
        } else {
            return String.format("%s:%nPower: %d%nDisplacement: %d%nEfficiency: %s%n",
                    this.engineModel, this.power, this.displacement, this.efficiency);
        }
    }
}