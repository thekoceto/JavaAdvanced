package com.company.P05_CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(console.readLine());
        Map <String, Engine> engines = new LinkedHashMap<>();
        while (n-- > 0){
            String[] token = console.readLine().split("\\s+");
            String model = token[0];
            int power = Integer.parseInt(token[1]);
            if (token.length==2)
                engines.put(token[0], new Engine(model, power));
            else if (token.length == 3){
                try {
                    int displacement = Integer.parseInt(token[2]);
                    engines.put(token[0], new Engine(model, power, displacement));
                }catch (Exception e){
                    String efficiency = token[2];
                    engines.put(token[0], new Engine(model, power, efficiency));
                }
            }else if (token.length == 4){
                int displacement = Integer.parseInt(token[2]);
                String efficiency = token[3];
                engines.put(token[0], new Engine(model, power, displacement, efficiency));
            }

        }

        n = Integer.parseInt(console.readLine());
        List <Car> cars = new ArrayList<>();
        while (n-- > 0){
            String[] token = console.readLine().split("\\s+");
            String model = token[0];
            Engine engine = engines.get(token[1]);

            if (token.length==2)
                cars.add(new Car(model, engine));
            else if (token.length == 3){
                try {
                    int weight = Integer.parseInt(token[2]);
                    cars.add(new Car(model, engine, weight));
                }catch (Exception e){
                    String color = token[2];
                    cars.add(new Car(model, engine, color));
                }
            }else if (token.length == 4){
                int weight = Integer.parseInt(token[2]);
                String color = token[3];
                cars.add(new Car(model, engine, weight, color));
            }
        }
        cars.forEach(car -> System.out.print(car.toString()));
    }
}
