package com.company.P10_test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countEngines = Integer.parseInt(scan.nextLine());
        Engine engine = null;
        Car car;
        HashMap<String, Engine> engines = new HashMap();
        HashMap<String, Car> cars = new LinkedHashMap<>();

        while (countEngines-- != 0) {
            String[] enginesInformation = scan.nextLine().split("\\s+");
            String engineModel = enginesInformation[0];
            int power = Integer.parseInt(enginesInformation[1]);

            if (enginesInformation.length == 2) {
                engine = new Engine(engineModel, power);
                engines.put(engineModel, engine);
            } else if (enginesInformation.length == 4) {
                int displacement = Integer.parseInt(enginesInformation[2]);
                String efficiency = enginesInformation[3];
                engine = new Engine(engineModel, power, displacement, efficiency);
                engines.put(engineModel, engine);

            } else {
                try {
                    int displacement = Integer.parseInt(enginesInformation[2]);
                    engine = new Engine(engineModel, power, displacement);
                    engines.put (engineModel, engine);
                } catch (NumberFormatException ex) {
                    String efficiency = enginesInformation[2];
                    engine = new Engine(engineModel, power, efficiency);
                    engines.put(engineModel, engine);
                }
            }
        }

        int numberOfCars = Integer.parseInt(scan.nextLine());

        while (numberOfCars-- != 0) {
            String[] carInformation = scan.nextLine().split("\\s+");
            String model = carInformation[0];
            String currEngine = carInformation[1];

            if (carInformation.length == 2) {
                car = new Car(model, engine);
                cars.put(model, car);
            } else if (carInformation.length == 4) {
                int weight = Integer.parseInt(carInformation[2]);
                String color = carInformation[3];
                car = new Car(model, engine, weight, color);
                cars.put(model, car);
            } else {
                try {
                    int weight = Integer.parseInt(carInformation[2]);
                    car = new Car(model, engine, weight);
                    cars.put(model, car);

                } catch (NumberFormatException ex) {
                    String color = carInformation[2];
                    car = new Car(model, engine, color);
                    cars.put(model, car);

                }
            }

            System.out.println(String.format("%s:", cars.get(model).getModel()));
            System.out.print(engines.get(currEngine).toString());
            System.out.print(cars.get(model).toString());

        }
    }
}