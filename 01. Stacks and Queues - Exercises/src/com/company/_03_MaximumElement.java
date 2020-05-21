package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _03_MaximumElement {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int steps = Integer.parseInt(console.nextLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        while (steps-- > 0){
            int [] input = Arrays.stream(console.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            if (input[0] == 1 )
                deque.push(input[1]);
            else if (input[0] == 2) {
                if (!deque.isEmpty())
                    deque.poll();
            }else if (input[0] == 3)
                System.out.println(deque.stream().max(Integer::compare).orElse(0));
        }
    }
}
