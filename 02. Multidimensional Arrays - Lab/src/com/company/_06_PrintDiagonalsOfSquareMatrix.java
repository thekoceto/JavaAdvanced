package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine())

        int [][] m = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] current = Arrays.stream(console.nextLine().split("\\s+"))
                    .limit(n).mapToInt(Integer::parseInt).toArray();
            m[i] = current;
        }
        for (int i = 0; i < n; i++)
            System.out.print(m[i][i] + " ");

        System.out.println();

        for (int i = 0; i < n; i++)
            System.out.print(m[n-i-1][i] + " ");
    }
}
