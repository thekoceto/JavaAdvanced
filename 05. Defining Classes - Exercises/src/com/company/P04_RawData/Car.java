package com.company.P04_RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire1;
    private Tire tire2;
    private Tire tire3;
    private Tire tire4;

    Car(String model,
        String engineSpeed,
        double enginePower,
        String cargoWeight,
        String cargoType,
        double tire1Pressure,
        int tire1Age,
        double tire2Pressure,
        int tire2Age,
        double tire3Pressure,
        int tire3Age,
        double tire4Pressure,
        int tire4Age){
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tire1 = new Tire(tire1Pressure, tire1Age);
        this.tire2 = new Tire(tire2Pressure, tire2Age);
        this.tire3 = new Tire(tire3Pressure, tire3Age);
        this.tire4 = new Tire(tire4Pressure, tire4Age);
    }
    boolean isPressureIsLowerThan(double pressure){
        return (this.tire1.isPressureIsLowerThan(pressure) ||
                this.tire2.isPressureIsLowerThan(pressure) ||
                this.tire3.isPressureIsLowerThan(pressure) ||
                this.tire4.isPressureIsLowerThan(pressure));

    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }
}
class Engine{
    private String engineSpeed;
    private double enginePower;
    Engine(String engineSpeed,double enginePower){
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }
    boolean isPowerBiggerThan(double power){
        return this.enginePower > power;
    }
}
class Cargo{
    private String cargoWeight;
    private String cargoType;
    Cargo(String cargoWeight, String cargoType){
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return cargoType;
    }
}
class Tire{
    private double tirePressure;
    private int tireAge;

    Tire(double tirePressure,int tireAge){
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    boolean isPressureIsLowerThan(double pressure) {
        return this.tirePressure < pressure;
    }
}

