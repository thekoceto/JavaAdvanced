package com.company;

import java.util.Scanner;

public class _07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String [][] m = new String[8][8];

        for (int i = 0; i < 8; i++)
            m[i] = console.nextLine().split("\\s+");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ("q".equals(m[i][j])) {
                    if (!checkDiagonals(m, i, j) && !checkRowCol(m, i, j)) {
                        System.out.println(i + " " + j);
                        break;
                    }
                }
            }
        }
    }

    private static boolean checkDiagonals(String[][] m, int row, int col) {
        boolean fakeQuin = true;
        for (int i = 0; i < 8; i++) {
            if (("q".equals(m[i][i]) && i != row) || ("q".equals(m[7-i][i])&& i != col)){
                fakeQuin = false;
                break;
            }
        }

        return fakeQuin;
    }
    private static boolean checkRowCol(String[][] m, int row, int col) {
        boolean fakeQuin = true;
        for (int i = 0; i < 8; i++) {
            if (("q".equals(m[row][i]) && i != row) || ("q".equals(m[i][col])&& i != col)){
                fakeQuin = false;
                break;
            }
        }

        return fakeQuin;
    }
    private static boolean check(String[][] m, int row, int col) {
        boolean fakeQuin = true;
        for (int i = 0; i < 8; i++) {
            if (i != row){
                if ("q".equals(m[i][i]) || "q".equals(m[row][i])){
                    fakeQuin = false;
                    break;
                }
            }
            if (i != col) {
                if ("q".equals(m[i][col]) || "q".equals(m[7-i][i])) {
                    fakeQuin = false;
                    break;
                }
            }
        }

        return fakeQuin;
    }
}
