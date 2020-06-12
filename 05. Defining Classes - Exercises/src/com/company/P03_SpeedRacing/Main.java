package com.company.P03_SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(console.readLine());
        Map <String, Car> cars = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] token = console.readLine().split("\\s+");
            cars.put(token[0], new Car (token[0], Integer.parseInt(token[1]), Double.parseDouble(token[2])));
        }
        String line;
        while (!"End".equals(line = console.readLine())){
            String[] token = line.split("\\s+");
            String car = token[1];
            int amount = Integer.parseInt(token[2]);
            double fuel = cars.get(car).getFuel();
            double cost = cars.get(car).getCost();
            if (amount*cost <= fuel){
                cars.get(car).increaseDistance(amount);
                cars.get(car).decreaseFuel(amount*cost);
            }else
                System.out.println("Insufficient fuel for the drive");

        }
        for (Map.Entry<String, Car> car : cars.entrySet()) {
            System.out.printf("%s %.2f %d%n",
                    car.getKey(),
                    car.getValue().getFuel(),
                    car.getValue().getDistance());
        }
    }
}
