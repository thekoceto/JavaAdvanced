package P00_Test;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        int countOfComands = Integer.parseInt(scan.nextLine());



        int startRow = 0;
        int startCol = 0;

        boolean hasWon = false;

        for (int row = 0; row < size; row++) {
            char[] rows = scan.nextLine().toCharArray();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = rows[col];

                if (matrix[row][col] == 'f') {
                    startRow = row;
                    startCol = col;

                }
            }
        }

        matrix[startRow][startCol] = '-';

        while (countOfComands-- > 0){
            String command = scan.nextLine();
            int previousRow = startRow;
            int previousCol = startCol;

            char field;

            switch (command) {
                case "up":
                    startRow--;
                    if (startRow < 0) {
                        startRow = matrix.length - 1;
                    }
                    break;

                case "down":
                    startRow++;
                    if (startRow > matrix.length - 1) {
                        startRow = 0;
                    }
                    break;

                case "left":
                    startCol--;
                    if (startCol < 0) {
                        startCol = matrix.length - 1;
                    }
                    break;

                case "right":
                    startCol++;
                    if (startCol > matrix.length - 1) {
                        startCol = 0;
                    }
                    break;
            }

            field = matrix[startRow][startCol];

            if (field == 'B') {
                if (command.equals("up")) {
                    startRow--;
                    if (startRow < 0) {
                        startRow = matrix.length - 1;
                    }
                }else if (command.equals("down")) {
                    startRow++;
                    if (startRow > matrix.length - 1) {
                        startRow = 0;
                    }
                }else if (command.equals("left")) {
                    startCol--;
                    if (startCol < 0) {
                        startCol = matrix.length - 1;
                    }
                }else {
                    startCol++;
                    if (startCol > matrix.length - 1) {
                        startCol = 0;
                    }
                }
            }
            field = matrix[startRow][startCol];
            if (field == 'F') {
                System.out.println("Player won!");
                hasWon = true;
                break;
            }else if (field == 'T') {
                startRow = previousRow;
                startCol = previousCol;

            }


        }

        if (!hasWon) {
            System.out.println("Player lost!");
        }

        matrix[startRow][startCol] = 'f';

        for (int row = 0; row < size ; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }

            System.out.println();

        }

    }
}