package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _04_MaximalSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int [] n = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int row = n[0], col = n[1];
        int[][] m = new int[row][col];

        for (int i = 0; i < row; i++) {
            int[] current = Arrays.stream(console.nextLine().split("\\s+"))
                    .limit(col).mapToInt(Integer::parseInt).toArray();
            m[i] = current;
        }
        int maxSum = 0, maxSumRow = 0, maxSumCol = 0;
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++){
                int sum = m[i][j] +   m[i][j+1] +   m[i][j+2] +
                          m[i+1][j] + m[i+1][j+1] + m[i+1][j+2] +
                          m[i+2][j] + m[i+2][j+1] + m[i+2][j+2];
                if (maxSum < sum){
                    maxSum = sum;
                    maxSumRow = i;
                    maxSumCol = j;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int i = maxSumRow; i < maxSumRow + 3; i++) {
            for (int j = maxSumCol; j < maxSumCol + 3; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }
    }
}
