import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int copyN = n;
        int[][] matrix = new int[n][n];
        int counter1 = 1;
        int counter2 = counter1 + n;
        int counter3 = counter2 + n - 1;
        int counter4 = counter3 + n - 1;
        int adjust = n - 1;
//        System.out.println(counter1);
//        System.out.println(counter2);
//        System.out.println(counter3);
//        System.out.println(counter4);
        for (int i = copyN - n; i < n; i++) {
            for (int j = copyN - n; j < n; j++) {
                matrix[i][j] = counter1++;
//                System.out.print(matrix[i][j] + "(" + i + ", " + j + ") ");
                if (matrix[i][j] == copyN * copyN) {
//                    System.out.println(copyN * copyN + " 1");
                    break;
                }

                matrix[j][n - 1] = j == 0 ? counter1 + n - 2 : counter2++;
//                System.out.print(matrix[j][n - 1] + "(" + j + ", " + (n - 1) + ") ");
                if (matrix[j][n - 1] == copyN * copyN) {
//                    System.out.println(copyN * copyN + " 2");
                    break;
                }


                matrix[n - 1][copyN - j - 1] = copyN - j - 1 == copyN - 1 ? counter2 + n - 2 : counter3++;
//                System.out.print(matrix[n - 1][copyN - j - 1] + "(" + (n - 1) + ", " + (copyN - j - 1) + ") ");
                if (matrix[n - 1][copyN - j - 1] == copyN * copyN) {
//                    System.out.println(copyN * copyN + " 3");
                    break;
                }


                if (j == n - 1) {
                    matrix[copyN - j - 1][i] = matrix[copyN - n][i];
//                    System.out.println(matrix[copyN - j - 1][i] + "(" + (copyN - n) + ", " + (i) + ") ");
                } else {
                    matrix[copyN - j - 1][i] = n - j - 1 == n - 1 ? counter3 + n - 2 : counter4++;
//                    System.out.println(matrix[copyN - j - 1][i] + "(" + (copyN - j - 1) + ", " + (i) + ") ");
                }
                if (matrix[copyN - j - 1][i] == copyN * copyN) {
//                    System.out.println(copyN * copyN + " 4");
                    break;
                }

            }
            n--;
            adjust -= 2;
            counter1 = counter4;
//            System.out.println("counter1 = " + counter1);
            counter2 = counter4 + adjust;
//            System.out.println("counter2 = " + counter2);
            counter3 = counter2 + adjust;
//            System.out.println("counter3 = " + counter3);
            counter4 = counter3 + adjust;
//            System.out.println("counter4 = " + counter4);
//            System.out.println("----------------------------------------");
        }
//        System.out.println();
        for (int[] temp : matrix) {
            for (int number : temp) {
                System.out.printf("%4s ", number);
            }
            System.out.println();
        }
    }
}
