package com.company.P05_CarSalesman;

public class Car {
    private String model;   // mandatory
    private Engine engine;  // mandatory
    private int weight;     // optional
    private String color;   // optional

    public Car(String model, Engine engine){
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }
    public Car(String model, Engine engine, int weight){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";
    }
    public Car(String model, Engine engine, String color){
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = color;
    }
    public Car(String model, Engine engine, int weight, String color){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return  this.model + ":\n"
                + this.engine.toString()
                + "Weight: " + (this.weight == -1 ? "n/a" : this.weight) + "\n"
                + "Color: " + this.color + "\n";
        //<CarModel>:
        //<EngineModel>:
        //Power: <EnginePower>
        //Displacement: <EngineDisplacement>
        //Efficiency: <EngineEfficiency>
        //Weight: <CarWeight>
        //Color: <CarColor>
    }
}
