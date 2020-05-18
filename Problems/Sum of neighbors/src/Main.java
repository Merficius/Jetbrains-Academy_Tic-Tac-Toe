import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix;
        int[][] postMatrix;
        int rows = 0;
        int columns = 0;
        StringBuilder preMatrix = new StringBuilder();

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            } else {
                preMatrix.append(input).append(" ");
                Scanner string = new Scanner(input);
                while (string.hasNextInt()) {
                    string.nextInt();
                    columns++;
                }
                string.close();
            }
            rows++;
        }

        scanner.close();
        columns /= rows;
        scanner = new Scanner(preMatrix.toString());
        matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        postMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int first = matrix[i == 0 ? rows - 1 : i - 1][j];
                int second = matrix[i == rows - 1 ? 0 : i + 1][j];
                int third = matrix[i][j == 0 ? columns - 1 : j - 1];
                int fourth = matrix[i][j == columns - 1 ? 0 : j + 1];
                System.out.print(first + second + third + fourth + " ");
            }
            System.out.println();
        }
    }
}