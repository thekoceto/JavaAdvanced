package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _02_PositionsOf {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int [] n = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int [][] matrix = new int[n[0]][n[1]];
        for (int i = 0; i < n[0]; i++) {
            int[] current = Arrays.stream(console.nextLine().split("\\s+"))
                    .limit(n[1]).mapToInt(Integer::parseInt).toArray();
            matrix[i] = current;
        }
        int number = Integer.parseInt(console.nextLine());
        System.out.println(check(matrix, number) ? "" : "not found");
    }

    private static boolean check(int[][] matrix, int number) {
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == number){
                    System.out.println(i + " " + j);
                    flag = true;
                }
            }
        }
        return flag;
    }
}
