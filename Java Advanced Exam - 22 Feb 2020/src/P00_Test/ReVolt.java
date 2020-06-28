package P00_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReVolt {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        int command = Integer.parseInt(reader.readLine());

        int[] position = new int[2];
        boolean hasWon = false;

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String line = reader.readLine();
            matrix[row] = line.toCharArray();
            if(line.indexOf('f') != -1){
                position[0] = row; position[1] = line.indexOf('f');
            }
        }

        matrix[position[0]][position[1]] = '-';

        while (command-- > 0){
            int[] previous = Arrays.copyOf(position, 2);

            switch (reader.readLine()) {
                case "up":
                    position[0] = decrease(size, position[0]);
                    if (matrix[position[0]][position[1]] == 'B')
                        position[0] = decrease(size, position[0]);
                    break;
                case "down":
                    position[0] = increase(size, position[0]);
                    if (matrix[position[0]][position[1]] == 'B')
                        position[0] = increase(size, position[0]);
                    break;
                case "left":
                    position[1] = decrease(size, position[1]);
                    if (matrix[position[0]][position[1]] == 'B')
                        position[1] = decrease(size, position[1]);
                    break;
                case "right":
                    position[1] = increase(size, position[1]);
                    if (matrix[position[0]][position[1]] == 'B')
                        position[1] = increase(size, position[1]);
                    break;
            }
            if (matrix[position[0]][position[1]] == 'F') {
                hasWon = true;
                break;
            }else if (matrix[position[0]][position[1]] == 'T') {
                position = Arrays.copyOf(previous, 2);
            }
        }
        matrix[position[0]][position[1]] = 'f';

        System.out.println(hasWon ? "Player won!" : "Player lost!");

        System.out.print(printMatrix(size, matrix));
    }

    private static String printMatrix(int size, char[][] matrix) {
        StringBuilder print = new StringBuilder();
        for (int row = 0; row < size ; row++) {
            for (int col = 0; col < size; col++)
                print.append(matrix[row][col]);
            print.append(System.lineSeparator());
        }
        return print.toString();
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