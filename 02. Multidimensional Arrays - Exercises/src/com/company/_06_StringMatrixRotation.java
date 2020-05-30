package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Pattern pattern = Pattern.compile("Rotate\\((?<degree>[\\d]+)\\)");
        Matcher matcher = pattern.matcher(console.nextLine());

        if (matcher.find()) {
            int degree = Integer.parseInt(matcher.group("degree"))%360;
            List<char[]> chars = new ArrayList<>();
            int maxLengtht = 0;
            String input;

            while (!"END".equals(input = console.nextLine())) {
                char[] c = input.toCharArray();
                chars.add(c);
                maxLengtht = maxLengtht < c.length ? c.length : maxLengtht;
            }
            char[][] m = new char[chars.size()][maxLengtht];
            for (int i = 0; i < chars.size(); i++) {
                char[] newMatr = new char[maxLengtht];
                Arrays.fill(newMatr, ' ');
                System.arraycopy(chars.get(i), 0, newMatr, 0, chars.get(i).length);
                m[i]=newMatr;
            }
            switch (degree){
                case 0: print0(m, m.length, maxLengtht);
                    break;
                case 90: print90(m, m.length, maxLengtht);
                    break;
                case 180: print180(m, m.length, maxLengtht);
                    break;
                case 270: print270(m, m.length, maxLengtht);
                    break;
                default:
                    break;
            }
        }
    }

    private static void print0(char[][] m, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(m[i][j]);
            System.out.println();
        }
    }

    private static void print90(char[][] m, int row, int col) {
        for (int i = 0; i < col; i++) {
            for (int j = row-1; j >= 0; j--)
                System.out.print(m[j][i]);
            System.out.println();
        }
    }

    private static void print180(char[][] m, int row, int col) {
        for (int i = row-1; i >= 0; i--) {
            for (int j = col-1; j >= 0; j--)
                System.out.print(m[i][j]);
            System.out.println();
        }
    }

    private static void print270(char[][] m, int row, int col) {
        for (int i = col-1; i >=0; i--){
            for (int j = 0; j < row; j++)
                System.out.print(m[j][i]);
            System.out.println();
        }
    }
}
