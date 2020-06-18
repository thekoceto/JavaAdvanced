package com.company.P04_RawData2;

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

