import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_SnakeDebug {
    private static final char snakeHead = 'S';
    private static final char snakeTail = '.';
    private static final char burrow = 'B';
    private static final char food = '*';

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        int[] bomb = new int[2]; // {row, col}

        char[][] matrix = new char[size][size];
        int eatenFood = 0;
        for (int i = 0; i < size; i++) {
            String row = reader.readLine();
            matrix[i] = row.toCharArray();
            if (row.indexOf(snakeHead) != -1)
                bomb = new int[]{i, row.indexOf(snakeHead)};
        }
        matrix[bomb[0]][bomb[1]] = snakeTail;
        int steps = 1;
        boolean isValidIndex = true;

        while (eatenFood < 10) {

            switch (reader.readLine()) {
                case "up":
                    if (isValidIndex = indexValidation(size, bomb[0] - 1, bomb[1]))
                        bomb[0]--;
                    System.out.println(steps++ + ") up   ");
                    break;
                case "down":
                    if (isValidIndex = indexValidation(size, bomb[0] + 1, bomb[1]))
                        bomb[0]++;
                    System.out.println(steps++ + ") down ");
                    break;
                case "left":
                    if (isValidIndex = indexValidation(size, bomb[0], bomb[1] - 1))
                        bomb[1]--;
                    System.out.println(steps++ + ") left ");

                    break;
                case "right":
                    if (isValidIndex = indexValidation(size, bomb[0], bomb[1] + 1))
                        bomb[1]++;
                    System.out.println(steps++ + ") right");
                    break;
            }
            if (!isValidIndex)
                break;
            if (matrix[bomb[0]][bomb[1]] == burrow) {
                matrix[bomb[0]][bomb[1]] = snakeTail;
                for (int i = 0; i < matrix.length; i++)
                    for (int j = 0; j < matrix[i].length; j++)
                        if (matrix[i][j] == burrow) {
                            bomb = new int[]{i, j};
                            break;
                        }
            }else if (matrix[bomb[0]][bomb[1]] == food)
                eatenFood++;

            matrix[bomb[0]][bomb[1]] = snakeTail;
            System.out.println(print(matrix));
        }

        StringBuilder print = new StringBuilder();

        if (isValidIndex)
            matrix[bomb[0]][bomb[1]] = snakeHead;
        else
            print.append("Game over!").append(System.lineSeparator());

        if (eatenFood == 10)
            print.append("You won! You fed the snake.").append(System.lineSeparator());

        print.append("Food eaten: ").append(eatenFood).append(System.lineSeparator());

        for (char[] row : matrix) {
            for (char ch : row)
                print.append(ch);
            print.append(System.lineSeparator());
        }
        System.out.println(print.toString());
    }
    private static String print (char[][]matrix){
        StringBuilder print = new StringBuilder();

        for (char[] row : matrix) {
            for (char ch : row)
                print.append(ch);
            print.append(System.lineSeparator());
        }
        return print.toString();
    }
    private static boolean indexValidation(int size, int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
}
