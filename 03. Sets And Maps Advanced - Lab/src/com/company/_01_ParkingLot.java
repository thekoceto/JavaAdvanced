package com.company;

import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;

public class _01_ParkingLot {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Set<String> set = new LinkedHashSet<>();
        String input;

        while (!"END".equals(input = console.nextLine())){
            String[] token = input.split(",\\s+");
            if ("IN".equals(token[0]))
                set.add(token[1]);
            else
                set.remove(token[1]);
        }
        if (set.isEmpty())
            System.out.println("Parking Lot is Empty");
        else
            set.forEach(System.out::println);
    }
}
