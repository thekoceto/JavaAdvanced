package com.company.P07_Google;

public class Car {
    //•	"<Name> car <carModel> <carSpeed>"
    String carModel;
    int carSpeed;

    public Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", this.carModel, this.carSpeed);
    }
}
