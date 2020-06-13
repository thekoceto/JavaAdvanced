package com.company.P07_Google;

public class Car {
    //•	"<Name> car <carModel> <carSpeed>"
    private String carModel;
    private int carSpeed;

    Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", this.carModel, this.carSpeed);
    }
}
