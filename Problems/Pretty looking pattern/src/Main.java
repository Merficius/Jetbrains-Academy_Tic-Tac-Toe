import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[4][4];

        for (int i = 0; i < 4; i++) {
            String temp = scanner.nextLine();
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = temp.charAt(j);
            }
        }

        for (int i = 0; i < 3; i++) {
            char c;
            for (int j = 0; j < 3; j++) {
                c = matrix[i][j];
                if (matrix[i + 1][j] == c && matrix[i][j + 1] == c && matrix[i + 1][j + 1] == c) {

                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
//        for (char[] c :matrix ) {
//            System.out.println(Arrays.toString(c));
//        }
    }
}
