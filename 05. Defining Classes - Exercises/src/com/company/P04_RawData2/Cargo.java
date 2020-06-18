package com.company.P04_RawData2;

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

