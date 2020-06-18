package com.company.P04_RawData2;

class Engine{
    private String engineSpeed;
    private double enginePower;

    Engine(String engineSpeed, double enginePower){
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    boolean isPowerBiggerThan(double power){
        return this.enginePower > power;
    }
}

