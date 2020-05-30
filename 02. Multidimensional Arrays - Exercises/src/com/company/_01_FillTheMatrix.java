package com.company;

import java.util.Scanner;

public class _01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split(",\\s+");
        int index = 0, n = Integer.parseInt(input[0]);
        int[][] m = new int[n][n];

        for (int i = 0; i < n; i++) {
            boolean flag = !"A".equals(input[1]) && i%2==1;
            for (int j = 0; j < n; j++) {
                m[flag ? n - j - 1 : j][i] = ++index;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }
    }
}
