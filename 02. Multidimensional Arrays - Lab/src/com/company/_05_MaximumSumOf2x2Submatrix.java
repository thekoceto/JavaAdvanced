package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _05_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int [] n = Arrays.stream(console.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int [][] matrix = new int[n[0]][n[1]];
        for (int i = 0; i < n[0]; i++) {
            int[] current = Arrays.stream(console.nextLine().split(",\\s+"))
                    .limit(n[1]).mapToInt(Integer::parseInt).toArray();
            matrix[i] = current;
        }
        check(matrix);
    }

    private static void check(int[][] m) {
        int maxSum = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < m.length-1; i++) {
            for (int j = 0; j < m[i].length-1; j++) {
                int sum = m[i][j] + m[i+1][j] + m[i][j+1] +m[i+1][j+1];
                if (sum > maxSum){
                    maxSum = sum;
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println(m[row][col] + " " + m[row][col+1]);
        System.out.println(m[row+1][col] + " " + m[row+1][col+1]);
        System.out.println(maxSum);
    }
}
