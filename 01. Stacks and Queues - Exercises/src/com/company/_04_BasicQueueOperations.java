package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int [] input = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> deque = Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .skip(input[1])
                .limit(input[0]-input[1])
                .collect(Collectors.toCollection(ArrayDeque::new));

        if (deque.contains(input[2]))
            System.out.println("true");
        else
            System.out.println(deque.stream().min(Integer::compare).orElse(0));

    }
}
