package com.company;

import java.util.Scanner;

public class _01_CompareMatrices {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean flag = false;

        int n1 = console.nextInt();
        int m1 = console.nextInt();
        int [][] firstMatrix = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                firstMatrix[i][j] = console.nextInt();
            }
        }

        int n2 = console.nextInt();
        int m2 = console.nextInt();
        int [][] secondMatrix = new int[n2][m2];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                secondMatrix[i][j] = console.nextInt();
            }
        }
        System.out.println(check(firstMatrix, secondMatrix) ? "equal" : "not equal");
    }

    private static boolean check(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length)
            return false;
        for (int i = 0; i < firstMatrix.length; i++) {
            if (firstMatrix[i].length != secondMatrix[i].length)
                return false;
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j])
                    return false;
            }
        }
        return true;
    }
}
