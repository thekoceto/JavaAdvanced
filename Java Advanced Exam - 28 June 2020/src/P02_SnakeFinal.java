import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_SnakeFinal {
    private static final char head = 'S';
    private static final char tail = '.';
    private static final char burrow = 'B';

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        int[] bomb = new int[2];

        char[][] matrix = new char[size][size];
        int eaten = 0;
        for (int i = 0; i < size; i++) {
            String row = reader.readLine();
            matrix[i] = row.toCharArray();
            if (row.indexOf(head) != -1)
                bomb = new int[]{i, row.indexOf(head)};
        }
        matrix[bomb[0]][bomb[1]] = tail;

        boolean validIndex = true;

        while (eaten < 10) {

            switch (reader.readLine()) {
                case "up":
                    if (validIndex = checkForValidIndex(size, bomb[0] - 1, bomb[1]))
                        bomb[0]--;
                    break;
                case "down":
                    if (validIndex = checkForValidIndex(size, bomb[0] + 1, bomb[1]))
                        bomb[0]++;
                    break;
                case "left":
                    if (validIndex = checkForValidIndex(size, bomb[0], bomb[1] - 1))
                        bomb[1]--;
                    break;
                case "right":
                    if (validIndex = checkForValidIndex(size, bomb[0], bomb[1] + 1))
                        bomb[1]++;
                    break;
            }
            if (!validIndex)
                break;
            if (matrix[bomb[0]][bomb[1]] == burrow) {
                matrix[bomb[0]][bomb[1]] = tail;
                for (int i = 0; i < matrix.length; i++)
                    for (int j = 0; j < matrix[i].length; j++)
                        if (matrix[i][j] == burrow)
                            bomb = new int[]{i, j};

            }else if (matrix[bomb[0]][bomb[1]] == '*'){
                eaten++;
            }
            matrix[bomb[0]][bomb[1]] = tail;
        }
        StringBuilder print = new StringBuilder();
        if (validIndex)
            matrix[bomb[0]][bomb[1]] = head;
        else
            print.append("Game over!").append(System.lineSeparator());

        if (eaten == 10)
            print.append("You won! You fed the snake.").append(System.lineSeparator());

        print.append("Food eaten: ").append(eaten).append(System.lineSeparator());

        for (char[] row : matrix) {
            for (char ch : row)
                print.append(ch);
            print.append(System.lineSeparator());
        }
        System.out.println(print.toString());
    }

    private static boolean checkForValidIndex(int size, int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
}
