package com.company;

import java.util.Scanner;

public class _03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int row = Integer.parseInt(console.nextLine());
        int col = Integer.parseInt(console.nextLine());

        String [][] m1 = new String[row][col];
        String [][] m2 = new String[row][col];

        for (int i = 0; i < row; i++)
            m1[i] = console.nextLine().split("\\s+");
        for (int i = 0; i < row; i++)
            m2[i] = console.nextLine().split("\\s+");

        check(m1, m2);
    }

    private static void check(String[][] m1, String[][] m2) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++)
                System.out.print(m1[i][j].equals(m2[i][j]) ? m1[i][j] + " " : "* " );
            System.out.println();
        }
    }
}
