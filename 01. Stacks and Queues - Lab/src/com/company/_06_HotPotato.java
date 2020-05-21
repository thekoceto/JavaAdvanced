package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _06_HotPotato {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList(console.nextLine().split(" ")));
        int n = Integer.parseInt(console.nextLine());
        console.close();


        while (queue.size() > 1){
            for (int i = 1; i < n; i++)
                queue.offer(queue.poll());

            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}