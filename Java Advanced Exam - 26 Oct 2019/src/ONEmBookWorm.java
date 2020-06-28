import java.util.Scanner;

public class ONEmBookWorm {

    public static int playerRow = 0;
    public static int playerCol = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String initialString = sc.nextLine();
        int sizeSquareM = Integer.parseInt(sc.nextLine());

        String[][] matrix = new String[sizeSquareM][sizeSquareM];

        readMatrix(matrix, sc);

        matrix[playerRow][playerCol] = "-";

        String powerBook;
        while (!(powerBook = sc.nextLine()).equals("end")) {
//            String currentLetter;
            switch (powerBook) {
                case "up":
                    if (checkIndex(matrix, playerRow - 1, playerCol)) {
                        playerRow -= 1;
                        if (!matrix[playerRow][playerCol].equals("-")) {
                            String toAdd = matrix[playerRow][playerCol];
                            initialString += toAdd;
                            matrix[playerRow][playerCol] = "-";
//                        } else {
//                            initialString += "";
//                            //matrix[playerRow][playerCol] = "P";
                        }
                    } else if (initialString.length() > 0) {
                        int end = initialString.length() - 1;
                        initialString = initialString.substring(0, end);
                    }
                    break;
                case "down":
                    if (checkIndex(matrix, playerRow + 1, playerCol)) {
                        playerRow += 1;
                        if (!matrix[playerRow][playerCol].equals("-")) {
                            String toAdd = matrix[playerRow][playerCol];
                            initialString += toAdd;
                            matrix[playerRow][playerCol] = "-";
//                        } else {
//                            initialString += "";
//                            //matrix[playerRow][playerCol] = "P";
                        }
                    } else if (initialString.length() > 0) {
                        int end = initialString.length() - 1;
                        initialString = initialString.substring(0, end);
                    }
                    break;
                case "left":
                    if (checkIndex(matrix, playerRow, playerCol-1) ) {
                        playerCol -= 1;
                        if (!matrix[playerRow][playerCol].equals("-")) {
                            String toAdd = matrix[playerRow][playerCol];
                            initialString += toAdd;
                            matrix[playerRow][playerCol] = "-";
//                        } else {
//                            initialString += "";
//                            //matrix[playerRow][playerCol] = "P";
                        }
                    } else if (initialString.length() > 0) {
                        int end = initialString.length() - 1;
                        initialString = initialString.substring(0, end);
                    }
                    break;
                case "right":
                    if (checkIndex(matrix, playerRow, playerCol+1)) {
                        playerCol += 1;
                        if (!matrix[playerRow][playerCol].equals("-")) {
                            String toAdd = matrix[playerRow][playerCol];
                            initialString += toAdd;
                            matrix[playerRow][playerCol] = "-";
//                        } else {
//                            initialString += "";
//                            //matrix[playerRow][playerCol] = "P";
                        }
                    } else if (initialString.length() > 0) {
                        int end = initialString.length() - 1;
                        initialString = initialString.substring(0, end);
                    }
                    break;
            }
        }
        matrix[playerRow][playerCol] = "P";

        System.out.println(initialString);
        printMatrix(matrix);
    }

    private static void readMatrix(String[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            String input = scanner.nextLine();
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = input.charAt(c) + "";
                if (matrix[r][c].equals("P")) {
                    playerRow = r;
                    playerCol = c;
                    matrix[r][c]="-";//TODO check
                }
            }
        }
    }
    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + "");
            }
            System.out.println();
        }
    }
    private static boolean checkIndex(String[][] matrix, int a, int b) {
        return a >= 0 && a < matrix.length && b >= 0 && b < matrix[a].length;
    }
}