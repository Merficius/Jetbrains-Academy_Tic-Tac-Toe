import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int m;
        int[][] matrix;
        int i;
        int j;

        n = scanner.nextInt();
        m = scanner.nextInt();
        matrix = new int[n][m];

        for (int rows = 0; rows < n; rows++) {
            for (int columns = 0; columns < m; columns++) {
                matrix[rows][columns] = scanner.nextInt();
            }
        }

        i = scanner.nextInt();
        j = scanner.nextInt();

        for (int rows = 0; rows < n; rows++) {
            int temp = matrix[rows][i];
            matrix[rows][i] = matrix[rows][j];
            matrix[rows][j] = temp;
        }

        for (int rows = 0; rows < n; rows++) {
            for (int columns = 0; columns < m; columns++) {
                System.out.print(matrix[rows][columns] + " ");
            }
            System.out.println();
        }
    }
}