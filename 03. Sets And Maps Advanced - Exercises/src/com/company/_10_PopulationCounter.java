package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _10_PopulationCounter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Long[]>> map = new LinkedHashMap<>();
        String input;

        while (!"report".equals(input = console.nextLine())) {
            String[] token = input.split("\\|"); // city|country|population
            map.putIfAbsent(token[1], new LinkedHashMap<>());
            map.get(token[1]).putIfAbsent(token[0], new Long[]{0L});
            map.get(token[1]).get(token[0])[0] += Long.parseLong(token[2]);
        }
        map
                .entrySet()
                .stream()
                .sorted((v1,v2) -> {
                    Long[] sum1 = new Long[] {0L};
                    Long[] sum2 = new Long[] {0L};
                    v1.getValue().forEach((key, value) -> sum1[0] += value[0]);
                    v2.getValue().forEach((key, value) -> sum2[0] += value[0]);
                    return sum2[0].compareTo(sum1[0]);
                })
                .forEach(e -> {
                    long[] sum = {0};
                    e.getValue().forEach((k,v)-> sum[0] += v[0]);
                    System.out.println(e.getKey() + " (total population: " + sum[0] + ")");
                    e.getValue()
                            .entrySet()
                            .stream()
                            .sorted((c1,c2) -> c2.getValue()[0].compareTo(c1.getValue()[0]))
                            .forEach((c) -> System.out.println("=>" + c.getKey() + ": " + c.getValue()[0]));
                });
    }
}
//UK (total population: 4)
//=>London: 4
//Bulgaria (total population: 3)
//=>Veliko Tarnovo: 2
//=>Sofia: 1
//Italy (total population: 3)
//=>Rome: 3