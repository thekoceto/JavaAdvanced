package com.company.P04_RawData2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(console.readLine());
        List<Car> cars = new ArrayList<>();

        while (n-- > 0)
            cars.add (new Car(console.readLine().split(" ")));

        String command = console.readLine();
        switch (command){
            case "fragile":
                cars
                        .stream()
                        .filter(car -> car.isPressureIsLowerThan(1.0))
                        .filter(car -> car.getCargoType().equalsIgnoreCase("fragile"))
                        .forEach(car -> System.out.println(car.getModel()));
                break;
            case "flamable":
                cars
                        .stream()
                        .filter(car -> car.isEnginePowerBiggerThan(250))
                        .filter(car -> car.getCargoType().equalsIgnoreCase("flamable"))
                        .forEach(car -> System.out.println(car.getModel()));
                break;
        }
    }
}
