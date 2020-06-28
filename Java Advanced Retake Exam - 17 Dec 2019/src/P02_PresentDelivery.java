import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_PresentDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int presents = Integer.parseInt(reader.readLine());
        int size = Integer.parseInt(reader.readLine());
        int allNiceKids = 0, niceKidsWithoutPresent = 0;
        StringBuilder out = new StringBuilder();

        char [][] matrix = new char[size][size];
        int[] santa = new int[2];

        for (int i = 0; i < size; i++) {
            String row = reader.readLine().replaceAll(" ", "");
            matrix[i] = row.toCharArray();
            allNiceKids += row.chars().filter(ch -> ch == 'V').count();
            if(row.indexOf('S') != -1){
                santa[0] = i;
                santa[1] = row.indexOf('S');
            }
        }

        matrix[santa[0]][santa[1]] = '-';

        String input;
        while (!"Christmas morning".equals(input = reader.readLine())) {

            switch (input) {
                case "up":    --santa[0]; break;
                case "down":  ++santa[0]; break;
                case "left":  --santa[1]; break;
                case "right": ++santa[1]; break;
            }
            if (matrix[santa[0]][santa[1]] == 'V'){
                if (--presents <= 0){
                    matrix[santa[0]][santa[1]] = '-';
                    out.append("Santa ran out of presents!").append(System.lineSeparator());
                    break;
                }
            }else if (matrix[santa[0]][santa[1]] == 'C'){
                presents -= happySanta(matrix, santa, presents);
            }
            matrix[santa[0]][santa[1]] = '-';
            if (presents <= 0 && getNiceKids(size, matrix) > 0){
                out.append("Santa ran out of presents!").append(System.lineSeparator());
                break;
            }
            if (getNiceKids(size, matrix) == 0)
                break;
        }
        matrix[santa[0]][santa[1]] = 'S';

        for (int row = 0; row < size ; row++) {
            for (int col = 0; col < size; col++)
                out.append(matrix[row][col]).append(' ');
            out.append(System.lineSeparator());
        }
        niceKidsWithoutPresent = getNiceKids(size, matrix);

        if (niceKidsWithoutPresent > 0)
            out.append("No presents for ").append(niceKidsWithoutPresent).append(" nice kid/s.");
        else
            out.append("Good job, Santa! ").append(allNiceKids).append(" happy nice kid/s.");

        System.out.println(out.toString());
    }

    private static int getNiceKids(int size, char[][] matrix) {
        int niceKids = 0;
        for (int row = 0; row < size ; row++) {
            for (int col = 0; col < size; col++)
                niceKids += matrix[row][col] == 'V' ? 1 : 0;
        }
        return niceKids;
    }

    private static int happySanta(char[][] matrix, int[] santa, int presents){
        int gifted = 0;

        if ( "VX".indexOf(matrix[santa[0] - 1][santa[1]]) != -1){
            matrix[santa[0] - 1][santa[1]] = '-';
            gifted++;
            if (--presents == 0) return gifted;
        }
        if ( "VX".indexOf(matrix[santa[0] + 1][santa[1]]) != -1){
            matrix[santa[0] + 1][santa[1]] = '-';
            gifted++;
            if (--presents == 0) return gifted;
        }
        if ( "VX".indexOf(matrix[santa[0]][santa[1] - 1]) != -1){
            matrix[santa[0]][santa[1] - 1] = '-';
            gifted++;
            if (--presents == 0) return gifted;
        }
        if ( "VX".indexOf(matrix[santa[0]][santa[1] + 1]) != -1){
            matrix[santa[0]][santa[1] + 1] = '-';
            gifted++;
            if (--presents == 0) return gifted;
        }
        return gifted;
    }
}