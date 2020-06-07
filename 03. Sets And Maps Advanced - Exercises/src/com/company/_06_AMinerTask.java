package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_AMinerTask {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, int[]> map = new LinkedHashMap<>();
        String input;

        while (!"stop".equals(input = console.nextLine())){
            map.putIfAbsent(input, new int[]{0});
            map.get(input)[0]+=Integer.parseInt(console.nextLine());
        }
        map.forEach((k,v) -> System.out.println(k + " -> " + v[0]));
    }
}
