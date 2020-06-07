package com.company;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class _08_HandsOfCards {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, Integer> power = new LinkedHashMap<String, Integer>(){{
            put("2", 2); put("3", 3); put("4", 4); put("5", 5); put("6", 6);
            put("7", 7); put("8", 8); put("9", 9); put("10", 10);
            put("J", 11); put("Q", 12); put("K", 13); put("A", 14);
        }};
        Map<String, Integer> type = new LinkedHashMap<String, Integer>(){{
            put("S", 4); put("H", 3); put("D", 2); put("C", 1);
        }};
        Map<String, LinkedHashSet<String>> map = new LinkedHashMap<>();
        String input;

        while (!"JOKER".equals(input = console.nextLine())){
            String[] token = input.split(": ");
            map.putIfAbsent(token[0], new LinkedHashSet<>());
            String[] cards = token[1].split(", ");
            for (String card : cards)
                map.get(token[0]).add(card);
        }
        map.forEach((k, v) -> System.out.println(k + ": "
                +  calculateValue(v, power, type)));
    }

    private static int calculateValue(
            LinkedHashSet<String> input,
            Map<String, Integer> power,
            Map<String, Integer> type) {

        int sum = 0;
        for (String card : input) {
            int p = power.get(card.substring(0,card.length()==2? 1 : 2));
            int t = type.get(card.substring(card.length()==2? 1 : 2, card.length()==2? 2 : 3));
            sum += p*t;
        }
        return sum;
    }
}
