package com.company.P04_RawData2;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire1;
    private Tire tire2;
    private Tire tire3;
    private Tire tire4;

    Car(String[] input){
        this.model = input[0];                                                              // model
        this.engine = new Engine(input[1], Double.parseDouble(input[2]));                   // engineSpeed, enginePower
        this.cargo = new Cargo(input[3], input[4]);                                         // cargoWeight, cargoType
        this.tire1 = new Tire(Double.parseDouble(input[5]),Integer.parseInt(input[6]));     // tire1Pressure, tire1Age
        this.tire2 = new Tire(Double.parseDouble(input[7]),Integer.parseInt(input[8]));     // tire2Pressure, tire2Age
        this.tire3 = new Tire(Double.parseDouble(input[9]),Integer.parseInt(input[10]));    // tire3Pressure, tire3Age
        this.tire4 = new Tire(Double.parseDouble(input[11]),Integer.parseInt(input[12]));   // tire4Pressure, tire4Age
    }

    boolean isPressureIsLowerThan(double pressure){
        return (this.tire1.isPressureIsLowerThan(pressure) ||
                this.tire2.isPressureIsLowerThan(pressure) ||
                this.tire3.isPressureIsLowerThan(pressure) ||
                this.tire4.isPressureIsLowerThan(pressure));

    }
    public String getCargoType() {
        return this.cargo.getCargoType();
    }
    boolean isEnginePowerBiggerThan(double power){
        return this.engine.isPowerBiggerThan(power);
    }

    public String getModel() {
        return model;
    }

}
