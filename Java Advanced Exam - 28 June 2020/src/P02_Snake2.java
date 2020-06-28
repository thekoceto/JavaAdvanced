import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_Snake2 {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        int[] position = new int[2];
        int[][] burrows = new int [2][2];
        boolean flag = false, goOut = false;
        char[][] matrix = new char[size][size];
        int foodЕaten = 10;
        for (int i = 0; i < size; i++) {
            String row = reader.readLine();
            matrix[i] = row.toCharArray();
            if (row.indexOf('S') != -1) {
                position[0] = i;
                position[1] = row.indexOf('S');

            }
            if (row.indexOf('B') != -1) {
                burrows[flag ? 1 : 0][0] = i;
                burrows[flag ? 1 : 0][1] = row.indexOf('B');
                flag = true;
            }
        }
        matrix[position[0]][position[1]] = '.';

        while (foodЕaten != 0) {

            switch (reader.readLine()) {
                case "up":
                    if (outOfBounds(size, position[0] - 1, position[1]))
                        goOut = true;
                    else
                        position[0]--;
                    break;
                case "down":
                    if (outOfBounds(size, position[0] + 1, position[1]))
                        goOut = true;
                    else
                        position[0]++;
                    break;
                case "left":
                    if (outOfBounds(size, position[0], position[1] - 1))
                        goOut = true;
                    else
                        position[1]--;
                    break;
                case "right":
                    if (outOfBounds(size, position[0], position[1] + 1))
                        goOut = true;
                    else
                        position[1]++;
                    break;
            }
            if (goOut)
                break;
            if (matrix[position[0]][position[1]] == 'B') {
                matrix[position[0]][position[1]] = '.';
                if (position[0] == burrows[0][0] && position[1] == burrows[0][1]){
                    position[0] = burrows[1][0];
                    position[1] = burrows[1][1];
                }else{
                    position[0] = burrows[0][0];
                    position[1] = burrows[0][1];
                }
            }else if (matrix[position[0]][position[1]] == '*'){
                foodЕaten--;
            }
            matrix[position[0]][position[1]] = '.';
        }

        StringBuilder print = new StringBuilder();
        if (goOut)
            print.append("Game over!").append(System.lineSeparator());
        else
            matrix[position[0]][position[1]] = 'S';

        if (foodЕaten == 0)
            print.append("You won! You fed the snake.").append(System.lineSeparator());

        print.append("Food foodЕaten: ").append(10 - foodЕaten).append(System.lineSeparator());

        for (char[] row : matrix) {
            for (char ch : row)
                print.append(ch);
            print.append(System.lineSeparator());
        }

        System.out.println(print.toString());
    }

    private static boolean outOfBounds(int size, int row, int col) {
        return row < 0 || row >= size || col < 0 || col >= size;
    }
}
