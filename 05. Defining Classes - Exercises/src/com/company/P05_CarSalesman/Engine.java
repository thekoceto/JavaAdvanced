package com.company.P05_CarSalesman;

public class Engine {
    private String model;       // mandatory
    private int power;          // mandatory
    private int displacement;   // optional
    private String efficiency;  // optional

    public Engine(String model, int power){
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = "n/a";
    }
    public Engine(String model, int power, int displacement){
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = "n/a";
    }
    public Engine(String model, int power, String efficiency){
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = efficiency;
    }
    public Engine(String model, int power, int displacement, String efficiency){
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return this.model + ":\n"
                + "Power: " + this.power + "\n"
                + "Displacement: " + (this.displacement == -1 ? "n/a" : this.displacement) + "\n"
                + "Efficiency: " + this.efficiency + "\n";
        //<EngineModel>:
        //Power: <EnginePower>
        //Displacement: <EngineDisplacement>
        //Efficiency: <EngineEfficiency>
    }
}
