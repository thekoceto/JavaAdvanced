package com.company;

import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class _04_CountSymbols {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();
        Map<Character, int[]> map = new TreeMap<>();

        for (char ch : input.toCharArray()){
            map.putIfAbsent(ch, new int []{0});
            map.get(ch)[0]++;
        }

        map.forEach((k,v) -> System.out.println(k + ": " + v[0] + " time/s"));
    }
}
