package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int [] n = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String[][] m = new String[n[0]][n[1]];

        for (int i = 0; i < n[0]; i++) {
            m[i] = console.nextLine().split("\\s+");
        }
        String input;

        while (!"END".equals(input = console.nextLine())){
            String[] token = input.split("\\s+");
            if ("swap".equals(token[0]) && token.length == 5){
                try{
                    int [] c = Arrays.stream(input.split("\\s+"))
                            .skip(1).mapToInt(Integer::parseInt).toArray();
                    String temp = m[c[0]][c[1]];
                    m[c[0]][c[1]] = m[c[2]][c[3]];
                    m[c[2]][c[3]] = temp;
                    printMatrix(m, n);
                }catch (IndexOutOfBoundsException iob) {
                    System.out.println("Invalid input!");
                }
            }
            else
                System.out.println("Invalid input!");
        }
    }

    private static void printMatrix(String[][] m, int[] n) {
        for (int i = 0; i < n[0]; i++) {
            for (int j = 0; j < n[1]; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }
    }
}
