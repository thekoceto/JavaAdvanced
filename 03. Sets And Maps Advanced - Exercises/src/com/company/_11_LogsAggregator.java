package com.company;

import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class _11_LogsAggregator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, int[]> userAndDuration = new TreeMap<>();
        Map<String, TreeSet<String>> userAndIP = new TreeMap<>();

        int n = Integer.parseInt(console.nextLine());
        while (n-- > 0) {
            String[] token = console.nextLine().split(" "); // •	192.168.0.11 peter 33
            userAndDuration.putIfAbsent(token[1], new int[]{0});
            userAndDuration.get(token[1])[0]+=Integer.parseInt(token[2]);

            userAndIP.putIfAbsent(token[1], new TreeSet<>());
            userAndIP.get(token[1]).add(token[0]);
        }
        userAndDuration
                .forEach((key, value) -> {
                    System.out.print(key + ": " + value[0] + " ");
                    System.out.println(userAndIP.get(key));
                });
    }
}