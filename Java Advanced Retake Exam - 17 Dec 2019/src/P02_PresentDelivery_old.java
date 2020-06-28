import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_PresentDelivery_old {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int present = Integer.parseInt(reader.readLine());
        int size = Integer.parseInt(reader.readLine());
        int niceKidsWithPresent = 0, allNiceKids = 0;

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
                case "up":
                    santa[0] = decrease(size, santa[0]);
                    break;
                case "down":
                    santa[0] = increase(size, santa[0]);
                    break;
                case "left":
                    santa[1] = decrease(size, santa[1]);
                    break;
                case "right":
                    santa[1] = increase(size, santa[1]);
                    break;
            }
            if (matrix[santa[0]][santa[1]] == 'V'){
                matrix[santa[0]][santa[1]] = '-';
                ++niceKidsWithPresent;
                if (--present <= 0){
                    System.out.println("Santa ran out of presents!");
                    break;
                }
            }else if (matrix[santa[0]][santa[1]] == 'X'){
                matrix[santa[0]][santa[1]] = '-';
            }else if (matrix[santa[0]][santa[1]] == 'C'){
                matrix[santa[0]][santa[1]] = '-';
                // ------------------------
                if (matrix[decrease(size, santa[0])][santa[1]] == 'V' || matrix[decrease(size, santa[0])][santa[1]] == 'X' ){
                    if (matrix[decrease(size, santa[0])][santa[1]] == 'V')
                        ++niceKidsWithPresent;
                    matrix[decrease(size, santa[0])][santa[1]] = '-';
                    if (--present <= 0) break;
                }
                // ------------------------
                if (matrix[increase(size, santa[0])][santa[1]] == 'V' || matrix[increase(size, santa[0])][santa[1]] == 'X'){
                    if (matrix[increase(size, santa[0])][santa[1]] == 'V')
                        ++niceKidsWithPresent;
                    matrix[increase(size, santa[0])][santa[1]] = '-';
                    if (--present <= 0) break;
                }
                // ------------------------
                if (matrix[santa[0]][decrease(size, santa[1])] == 'V' || matrix[santa[0]][decrease(size, santa[1])] == 'X'){
                    if (matrix[santa[0]][decrease(size, santa[1])] == 'V')
                        ++niceKidsWithPresent;
                    matrix[santa[0]][decrease(size, santa[1])] = '-';
                    if (--present <= 0) break;
                }
                // ------------------------
                if (matrix[santa[0]][increase(size, santa[1])] == 'V' || matrix[santa[0]][increase(size, santa[1])] == 'X'){
                    if (matrix[santa[0]][increase(size, santa[1])] == 'V')
                        ++niceKidsWithPresent;
                    matrix[santa[0]][increase(size, santa[1])] = '-';
                    if (--present <= 0) break;
                }
            }
        }
        matrix[santa[0]][santa[1]] = 'S';

        for (int row = 0; row < size ; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
                System.out.print(' ');
            }
            System.out.println();
        }
        if (allNiceKids > niceKidsWithPresent)
            System.out.println("No presents for " + (allNiceKids - niceKidsWithPresent) + " nice kid/s.");
        else
            System.out.println("Good job, Santa! " + niceKidsWithPresent + " happy nice kid/s.");

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