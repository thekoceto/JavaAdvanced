package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _10_PoisonousPlants {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        int [] plants = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).limit(n).toArray();
        int [] days = new int[n];

        ArrayDeque<Integer> previous = new ArrayDeque<>();
        previous.push(0);

        for (int i = 1; i < n; i++) {
            int day = 0;
            while (!previous.isEmpty() && plants[previous.peek()]>=plants[i]){
                day = Math.max(day, days[previous.pop()]);
            }
            if (!previous.isEmpty())
                days[i] = day +1;
            previous.push(i);
        }
        System.out.println(Arrays.stream(days).max().orElse(0));
    }
}
