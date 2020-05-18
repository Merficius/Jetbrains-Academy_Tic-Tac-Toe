package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[3][3];
        int x = 0;
        int y = 0;
        char playingChar = 'X';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = '_';
            }
        }


        printGame(matrix);
        while (checkState(matrix)) {
            System.out.println("Enter the coordinates: ");
            try {
                x = scanner.nextInt();
                y = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
            if ((x != 1 && x != 2 && x != 3) || (y != 1 && y != 2 && y != 3)) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (matrix[Math.abs(y - 3)][x - 1] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                matrix[Math.abs(y - 3)][x - 1] = playingChar;
                playingChar = playingChar == 'X' ? 'O' : 'X';
                printGame(matrix);
            }
        }
    }


    public static int firstRows(char c, char[][] matrix) {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            if (c == matrix[i][0] && c == matrix[i][1] && c == matrix[i][2]) {
                counter++;
            }
        }
        return counter;
    }


    public static int countColumns(char c, char[][] matrix) {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            if (c == matrix[0][i] && c == matrix[1][i] && c == matrix[2][i]) {
                counter++;
            }
        }
        return counter;
    }


    public static int countDiagonals(char c, char[][] matrix) {
        int counter = 0;
        if (c == matrix[0][0] && c == matrix[1][1] && c == matrix[2][2]) {
            counter++;
        }
        if (c == matrix[2][0] && c == matrix[1][1] && c == matrix[0][2]) {
            counter++;
        }
        return counter;
    }


    public static int countDifference(char[][] matrix) {
        int x = 0;
        int o = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 'X') {
                    x++;
                } else if (matrix[i][j] == 'O') {
                    o++;
                }
            }
        }

        return Math.abs(x - o);
    }


    public static int countSpaces(char[][] matrix) {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == '_') {
                    counter++;
                }
            }
        }

        return counter;
    }


    public static boolean checkState(char[][] matrix) {
        if ((countDifference(matrix) != 1 && countDifference(matrix) != 0) || firstRows('X', matrix) > 1
            || firstRows('O', matrix) > 1 || countColumns('X', matrix) > 1 || countColumns('O', matrix) > 1
            || countDiagonals('X', matrix) > 1 || countDiagonals('O', matrix) > 1) {
            System.out.println("Impossible");
            return false;
        } else if ((firstRows('X', matrix) == 1 && firstRows('O', matrix) == 1)
                   || (countColumns('X', matrix) == 1 && countColumns('O', matrix) == 1)
                   || (countDiagonals('X', matrix) == 1 && countDiagonals('O', matrix) == 1)) {
            System.out.println("Impossible");
            return false;
        } else if (firstRows('X', matrix) == 1 || countColumns('X', matrix) == 1 || countDiagonals('X', matrix) == 1) {
            System.out.println("X wins");
            return false;
        } else if (firstRows('O', matrix) == 1 || countColumns('O', matrix) == 1 || countDiagonals('O', matrix) == 1) {
            System.out.println("O wins");
            return false;
        } else if (countSpaces(matrix) == 0) {
            System.out.println("Draw");
            return false;
        } else {
            System.out.println("Game not finished");
            return true;
        }
    }


    public static void printGame(char[][] matrix) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }


    public static void fillPreUsedMatrix(char[][] matrix, Scanner scanner) {
        System.out.println("Enter cells: ");
        String input = scanner.nextLine();
        int counter = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = input.charAt(counter++);
            }
        }
    }
}
