package P02_BookWorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_BookWorm {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder text = new StringBuilder(reader.readLine());
        int size = Integer.parseInt(reader.readLine());
        int[] position = new int[2];
        char [][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            String row = reader.readLine();
            matrix[i] = row.toCharArray();
            if(row.indexOf('P') != -1){
                position[0] = i;
                position[1] = row.indexOf('P');
            }
        }
        matrix[position[0]][position[1]] = '-';

        String input;
        while (!"end".equals(input = reader.readLine())) {
            boolean isPunished = false;
            switch (input) {
                case "up":
                    isPunished = decrease(size, position[0]);
                    if (!isPunished)
                        --position[0];
                    break;
                case "down":
                    isPunished = increase(size, position[0]);
                    if (!isPunished)
                        ++position[0];
                    break;
                case "left":
                    isPunished = decrease(size, position[1]);
                    if (!isPunished)
                        --position[1];
                    break;
                case "right":
                    isPunished = increase(size, position[1]);
                    if (!isPunished)
                        ++position[1];
                    break;
            }
            if (isPunished && text.length()>0)
                text.setLength(text.length() - 1);  //text.deleteCharAt(sb.length() - 1);
            else if (Character.isAlphabetic(matrix[position[0]][position[1]])){
                text.append(matrix[position[0]][position[1]]);
                matrix[position[0]][position[1]] = '-';
            }
        }

        matrix[position[0]][position[1]] = 'P';

        text.append(System.lineSeparator());
        for (int row = 0; row < size ; row++) {
            for (int col = 0; col < size; col++)
                text.append(matrix[row][col]);
            text.append(System.lineSeparator());
        }
        System.out.println(text.toString().trim());
    }

    private static boolean decrease(int size, int index) {
        return --index < 0;
    }

    private static boolean increase(int size, int index) {
        return ++index > size - 1;
    }
}
