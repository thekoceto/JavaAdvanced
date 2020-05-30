package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _04_MaximalSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int [] n = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] m = new int[n[0]][n[1]];

        for (int i = 0; i < n[0]; i++) {
            int[] current = Arrays.stream(console.nextLine().split("\\s+"))
                    .limit(n[1]).mapToInt(Integer::parseInt).toArray();
            m[i] = current;
        }
        int maxSum = 0, row = 0, col = 0;
        for (int i = 0; i < n[0] - 2; i++) {
            for (int j = 0; j < n[1] - 2; j++){
                int sum = m[i][j] +   m[i][j+1] +   m[i][j+2] +
                          m[i+1][j] + m[i+1][j+1] + m[i+1][j+2] +
                          m[i+2][j] + m[i+2][j+1] + m[i+2][j+2];
                if (maxSum < sum){
                    maxSum = sum;
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(m[i + row][j + col] + " ");
            System.out.println();
        }
    }
}
