package com.company;

import java.util.Scanner;

public class _07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String [][] m = new String[8][8];

        for (int i = 0; i < 8; i++)
            m[i] = console.nextLine().split("\\s+");

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if ("q".equals(m[i][j]))
                    if (!check(m, i, j)){
                        System.out.println(i + " " + j);
                        break;
                    }
    }

    private static boolean check(String[][] m, int row, int col) {
        boolean fakeQuin = false;
        if (row >=0 && "q".equals(m[row][col]))
            fakeQuin = check(m, row-1, col);

        return fakeQuin;
    }
}
