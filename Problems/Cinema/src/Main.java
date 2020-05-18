import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        int consecutiveSeatsWanted;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        consecutiveSeatsWanted = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int consecutiveSeatsAvailable = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    consecutiveSeatsAvailable++;
                } else {
                    consecutiveSeatsAvailable = 0;
                }
                if (consecutiveSeatsAvailable == consecutiveSeatsWanted) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}
