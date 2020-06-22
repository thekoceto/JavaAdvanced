package P02_ReVolt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        boolean won = false;
        char [][] matrix = new char[n][n];
        int[] f = new int[]{0,0};
        for (int i = 0; i < n; i++) {
            String row = reader.readLine();
            matrix[i] = row.toCharArray();
            if(row.indexOf('f') != -1){
                f[0] = i;
                f[1] = row.indexOf('f');
            }
        }
        while (c-- > 0){
            int[] t = Arrays.copyOf(f, 2);
            switch (reader.readLine()){
                case "up":
                    if (--t[0] < 0)
                        t[0] = n-1;
                    if (matrix[t[0]][t[1]] == 'B')
                        if (--t[0] < 0)
                            t[0] = n-1;
                    break;
                case "down":
                    if (++t[0] >= n)
                        t[0] = 0;
                    if (matrix[t[0]][t[1]] == 'B')
                        if (++t[0] >= n)
                            t[0] = 0;
                    break;
                case "left":
                    if (--t[1] < 0)
                        t[1] = n-1;
                    if (matrix[t[0]][t[1]] == 'B')
                        if (--t[1] < 0)
                            t[1] = n-1;
                    break;
                case "right":
                    if (++t[1] >= n)
                        t[1] = 0;
                    if (matrix[t[0]][t[1]] == 'B')
                        if (++t[1] >= n)
                            t[1] = 0;
                    break;

            }
            if (matrix[t[0]][t[1]] == 'F'){
                matrix[f[0]][f[1]] = '-';
                matrix[t[0]][t[1]] = 'f';
                won = true;
                break;
            }
            else if (matrix[t[0]][t[1]] == '-'){
                matrix[f[0]][f[1]] = '-';
                matrix[t[0]][t[1]] = 'f';
            }
            if (matrix[t[0]][t[1]] != 'T')
                f = Arrays.copyOf(t, 2);

        }
        if (won)
            System.out.println("Player won!");
        else
            System.out.println("Player lost!");
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char ch : chars) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}