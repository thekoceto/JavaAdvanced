package com.company.P07_CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static <T extends Comparable<T>> void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<T> customList = new CustomList<>();
        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] commands = line.split("\\s+");
            switch (commands[0]) {
                case "Add":
                    customList.add((T)commands[1]);
                    break;

                case "Remove":
                    customList.remove(Integer.parseInt(commands[1]));
                    break;

                case "Contains":
                    System.out.println((customList.contains((T)commands[1]) ? "true" : "false"));
                    break;

                case "Swap":
                    customList.swap(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                    break;

                case "Greater":
                    System.out.println(customList.countGreaterThat((T)commands[1]));
                    break;

                case "Max":
                    System.out.println(customList.getMax());
                    break;

                case "Min":
                    System.out.println(customList.getMin());
                    break;

                case "Print":
                    for (T t : customList.getList()) {
                        System.out.println(t);
                    }
                    break;
            }
        }
    }
}