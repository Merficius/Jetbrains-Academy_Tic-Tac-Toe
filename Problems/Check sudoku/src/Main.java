import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n * n][n * n];
        ArrayList<String> check = new ArrayList<String>();
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int l = 1; l <= n * n; l++) {
            check.add(Integer.toString(l));
        }

        int counter = 0;
        for (int i = 0; i < n * n; i += n) {
            for (int j = i % n + i; j < n * n + i; j++) {
                for (int k = j / n * n; k < j / n * n + n; k++) {
                    if (counter == n * n) {
//                        System.out.println("hello");
                        for (int l = 1; l <= n * n; l++) {
                            check.add(Integer.toString(l));
                        }
                        counter = 0;
                    }
                    if (check.contains(Integer.toString(matrix[j % n + i][k % (n * n)]))) {
                        check.remove(Integer.toString(matrix[j % n + i][k % (n * n)]));
                    } else {
                        System.out.println("NO");
                        return;
                    }
//                    System.out.print("(" + (j % n + i) + ", " + (k % (n * n)) + ")");
                    counter++;
                }
//                System.out.println();
            }
        }

        for (int l = 1; l <= n * n; l++) {
            check.add(Integer.toString(l));
        }
        //check rows
        for (int[] array : matrix) {
            for (int number : array) {
                if (check.contains(Integer.toString(number))) {
                    check.remove(Integer.toString(number));
                } else {
                    System.out.println("NO");
                    return;
                }
            }
            for (int l = 1; l <= n * n; l++) {
                check.add(Integer.toString(l));
            }
        }

        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++) {
                if (check.contains(Integer.toString(matrix[j][i]))) {
                    check.remove(Integer.toString(matrix[j][i]));
                } else {
                    System.out.println("NO");
                    return;
                }
            }
            for (int l = 1; l <= n * n; l++) {
                check.add(Integer.toString(l));
            }
        }

        System.out.println("YES");
    }

}
