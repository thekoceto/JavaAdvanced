import java.util.Scanner;

public class P02_Snake {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
        int[] bomb = new int[2];
        int[][] burrows = new int [2][2];
        boolean flag = false;
        char[][] matrix = new char[size][size];
        int eaten = 10;
        for (int i = 0; i < size; i++) {
            String row = sc.nextLine();
            matrix[i] = row.toCharArray();
            if (row.indexOf('S') != -1) {
                bomb[0] = i;
                bomb[1] = row.indexOf('S');

            }
            if (row.indexOf('B') != -1) {
                burrows[flag ? 1 : 0][0] = i;
                burrows[flag ? 1 : 0][1] = row.indexOf('B');
                flag = true;
            }
        }
        matrix[bomb[0]][bomb[1]] = '.';
        flag = false;

        while (eaten != 0) {

            switch (sc.nextLine()) {
                case "up":
                    if (outOfBounds(size, bomb[0] - 1, bomb[1]))
                        flag = true;
                    else
                        bomb[0]--;
                    break;
                case "down":
                    if (outOfBounds(size, bomb[0] + 1, bomb[1]))
                        flag = true;
                    else
                        bomb[0]++;
                    break;
                case "left":
                    if (outOfBounds(size, bomb[0], bomb[1] - 1))
                        flag = true;
                    else
                        bomb[1]--;
                    break;
                case "right":
                    if (outOfBounds(size, bomb[0], bomb[1] + 1))
                        flag = true;
                    else
                        bomb[1]++;
                    break;
            }
            if (flag)
                break;
            if (matrix[bomb[0]][bomb[1]] == 'B') {
                matrix[bomb[0]][bomb[1]] = '.';
                if (bomb[0] == burrows[0][0] && bomb[1] == burrows[0][1]){
                    bomb[0] = burrows[1][0];
                    bomb[1] = burrows[1][1];
                }else{
                    bomb[0] = burrows[0][0];
                    bomb[1] = burrows[0][1];
                }
            }else if (matrix[bomb[0]][bomb[1]] == '*'){
                eaten--;
            }
            matrix[bomb[0]][bomb[1]] = '.';
        }

        if (flag)
            System.out.println("Game over!");
        else
            matrix[bomb[0]][bomb[1]] = 'S';

        if (eaten == 0)
            System.out.println("You won! You fed the snake.");

        System.out.println("Food eaten: " + (10 - eaten));

        for (char[] row : matrix) {
            for (char ch : row)
                System.out.print(ch);
            System.out.println();
        }

    }

    private static boolean outOfBounds(int size, int row, int col) {
        return row < 0 || row >= size || col < 0 || col >= size;
    }
}
