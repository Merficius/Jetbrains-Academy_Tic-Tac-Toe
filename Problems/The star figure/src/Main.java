import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ". ";
            }
        }

        for (int i = 0; i < n; i++) {
            matrix[n / 2][i] = "* ";
            matrix[i][n / 2] = "* ";
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    matrix[i][j] = "* ";
                }
            }
        }

        print(matrix);
    }


    public static void print(String[][] matrix) {
        for (String[] temp : matrix) {
            for (String s : temp) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}