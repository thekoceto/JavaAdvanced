package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int [] n = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String[][] m = new String[n[0]][n[1]];
        char ch = 'a';
        for (int i = 0; i < n[1]; i++) {
            for (int j = 0; j < n[0]; j++) {
                m[j][i] = "" + (char)(ch + j) + (char)(ch + i + j) + (char)(ch + j);
            }
        }
        for (int i = 0; i < n[0]; i++) {
            for (int j = 0; j < n[1]; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }
    }
}
