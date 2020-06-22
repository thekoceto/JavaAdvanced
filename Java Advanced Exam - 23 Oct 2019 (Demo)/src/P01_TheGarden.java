import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01_TheGarden {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int l = 0;    // Lettuce
        int p = 0;    // Potatoes
        int c = 0;    // Carrots
        int h = 0;    // Harmed

        String [][] garden = new String[n][];

        for (int i = 0; i < garden.length; i++)
            garden[i] = reader.readLine().split("\\s+");

        String input;
        while (!"End of Harvest".equals(input = reader.readLine())){
            String[] token = input.split("\\s+");
            int row = Integer.parseInt(token[1]);
            int col = Integer.parseInt(token[2]);
            switch (token[0]){
                case "Harvest":
                    if (checkIndex(garden, row, col)){
                        switch (garden[row][col]) {
                            case "L": l++; break;
                            case "P": p++; break;
                            case "C": c++; break;
                        }
                        garden[row][col] = " ";
                    }
                    break;
                case "Mole":
                    switch (token[3]){
                        case "up":
                            while(checkIndex(garden, row, col)){
                                h += isEmpty(garden, row, col)  ? 0 : 1;
                                row -= 2;
                            }
                            break;
                        case "down":
                            while(checkIndex(garden, row, col)){
                                h += isEmpty(garden, row, col)  ? 0 : 1;
                                row += 2;
                            }
                            break;
                        case "left":
                            while(checkIndex(garden, row, col)){
                                h += isEmpty(garden, row, col)  ? 0 : 1;
                                col -= 2;
                            }
                            break;
                        case "right":
                            while(checkIndex(garden, row, col)){
                                h += isEmpty(garden, row, col)  ? 0 : 1;
                                col += 2;
                            }
                            break;
                    }
                    break;
            }
        }
        StringBuilder print = new StringBuilder();
        for (String[] row : garden) {
            for (String s : row)
                print.append(s).append(" ");
            print.append(System.lineSeparator());
        }
        print.append("Carrots: ").append(c).append(System.lineSeparator());
        print.append("Potatoes: ").append(p).append(System.lineSeparator());
        print.append("Lettuce: ").append(l).append(System.lineSeparator());
        print.append("Harmed vegetables: ").append(h);

        System.out.println(print.toString());
    }

    private static boolean isEmpty(String[][] garden, int row, int col) {
        if (" ".equals(garden[row][col]))
            return true;
        garden[row][col] = " ";
        return false;
    }

    private static boolean checkIndex(String[][] garden, int row, int col) {
        return row >= 0 && row < garden.length && col >= 0 && col < garden[row].length;
    }
}
