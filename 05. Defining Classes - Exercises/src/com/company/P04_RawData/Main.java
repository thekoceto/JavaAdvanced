package com.company.P04_RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(console.readLine());
        List<Car> cars = new ArrayList<>();

        while (repeat-- > 0) {
            String[] token = console.readLine().split(" ");
            cars.add (new Car(  token[0],
                    token[1],Double.parseDouble(token[2]),
                    token[3],token[4],
                    Double.parseDouble(token[5]),Integer.parseInt(token[6]),
                    Double.parseDouble(token[7]),Integer.parseInt(token[8]),
                    Double.parseDouble(token[9]),Integer.parseInt(token[10]),
                    Double.parseDouble(token[11]),Integer.parseInt(token[12])));
        }

        String command = console.readLine();
        switch (command){
            case "fragile":
                cars
                        .stream()
                        .filter(car -> car.isPressureIsLowerThan(1.0))
                        .filter(car -> car.getCargo().getCargoType().equalsIgnoreCase("fragile"))
                        .forEach(car -> System.out.println(car.getModel()));
                break;
            case "flamable":
                cars
                        .stream()
                        .filter(car -> car.getEngine().isPowerBiggerThan(250))
                        .filter(car -> car.getCargo().getCargoType().equalsIgnoreCase("flamable"))
                        .forEach(car -> System.out.println(car.getModel()));
                break;
        }
    }
}
