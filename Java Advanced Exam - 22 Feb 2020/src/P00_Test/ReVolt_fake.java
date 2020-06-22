package P00_Test;

import java.util.Scanner;

public class ReVolt_fake {
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

            if ("up".equals(command)) {
                startRow = decrease(size, startRow);
            } else if ("down".equals(command)) {
                startRow = increase(size, startRow);
            } else if ("left".equals(command)) {
                startCol = decrease(size, startCol);
            } else if ("right".equals(command)) {
                startCol = increase(size, startCol);
            }

            if (matrix[startRow][startCol] == 'B') {
                if ("up".equals(command)) {
                    startRow = decrease(size, startRow);
                } else if ("down".equals(command)) {
                    startRow = increase(size, startRow);
                } else if ("left".equals(command)) {
                    startCol = decrease(size, startCol);
                } else if ("right".equals(command)) {
                    startCol = increase(size, startCol);
                }
            }else if (matrix[startRow][startCol] == 'F') {
                hasWon = true;
                break;
            }else if (matrix[startRow][startCol] == 'T') {
                startRow = previousRow;
                startCol = previousCol;
            }
        }

        System.out.println(hasWon ? "Player won!" : "Player lost!");

        matrix[startRow][startCol] = 'f';

        for (int row = 0; row < size ; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }

    private static int decrease(int size, int index) {
        if (--index < 0)
            index = size - 1;
        return index;
    }

    private static int increase(int size, int index) {
        if (++index > size - 1)
            index = 0;
        return index;
    }
}