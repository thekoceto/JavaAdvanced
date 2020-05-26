package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int [] n = Arrays.stream(console.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int sum = 0;

        //int [][] matrix = new int[n[0]][n[1]];
        for (int i = 0; i < n[0]; i++) {
            int[] current = Arrays.stream(console.nextLine().split(",\\s+"))
                    .limit(n[1]).mapToInt(Integer::parseInt).toArray();
            //matrix[i] = current;
            sum += Arrays.stream(current).sum();
        }
        System.out.println(n[0]);
        System.out.println(n[1]);
        System.out.println(sum);
    }
}
