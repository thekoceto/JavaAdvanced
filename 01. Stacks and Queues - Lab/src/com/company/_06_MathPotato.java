package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _06_MathPotato {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList(console.nextLine().split(" ")));
        int n = Integer.parseInt(console.nextLine());
        console.close();
        int cycle = 1;
        while (queue.size() > 1){
            for (int i = 1; i < n; i++)
                queue.offer(queue.poll());

            if(isPrime(cycle))
                System.out.println("Prime " + queue.peek());
            else
                System.out.println("Removed " + queue.poll());

            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cycle) {
        if (cycle == 1)
            return false;

        for (int i = 2; i < cycle; i++)
            if (cycle % i == 0)
                return false;

        return true;
    }
}