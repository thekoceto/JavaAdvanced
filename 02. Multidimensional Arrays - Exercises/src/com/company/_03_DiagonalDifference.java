package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int sum = 0, n = Integer.parseInt(console.nextLine());
        int[][] m = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] current = Arrays.stream(console.nextLine().split("\\s+"))
                    .limit(n).mapToInt(Integer::parseInt).toArray();
            m[i] = current;
        }
        for (int i = 0; i < n; i++) {
            sum += m[i][i] - m[n-i-1][i];
        }
        System.out.println(sum < 0 ? -sum : sum);
    }
}
