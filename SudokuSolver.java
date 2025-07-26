
import java.util.ArrayList;

public class SudokuSolver {
    
    public static void main(String[] args) {
        
        int[][] sudoku = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        sudokuSolver(sudoku, 0, 0);
    }

    public static void sudokuSolver(int[][] matrix, int line, int column) {

        if (line == matrix.length) {

            printSudokuSolver(matrix);
            return;
        }

        if (matrix[line][column] != 0) {
            if (column + 1 == matrix[0].length) {
                sudokuSolver(matrix, line + 1, 0);
            } 
            else {
                sudokuSolver(matrix, line, column + 1);
            }
            return;
        }

        ArrayList<Integer> possibleResults = allPossibilities(matrix, line, column);
        for (int i = 0; i < possibleResults.size(); i++) {
            
            matrix[line][column] = possibleResults.get(i);

            if (column + 1 == matrix[0].length) {
                sudokuSolver(matrix, line + 1, 0);
            }
            else {
                sudokuSolver(matrix, line, column + 1);
            }
            matrix[line][column] = 0;
        }
    }

    public static ArrayList<Integer> allPossibilities(int[][] matrix, int line, 
        int column) {

        ArrayList<Integer> charactersByLine = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {

            if (matrix[line][i] != 0) {
                charactersByLine.add(matrix[line][i]);
            }
        }

        ArrayList<Integer> characterByColumn = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {

            if (matrix[i][column] != 0) {
                characterByColumn.add(matrix[i][column]);
            }
        }

        ArrayList<Integer> characterByBoard = new ArrayList<>();
        if (line <= 2 && column <= 2) {

            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {

                    if (matrix[i][j] != 0) {
                        characterByBoard.add(matrix[i][j]);
                    }
                }
            }
        }
        else if (line <= 2 && column <= 5) {

            for (int i = 0; i <= 2; i++) {
                for (int j = 3; j <= 5; j++) {

                    if (matrix[i][j] != 0) {
                        characterByBoard.add(matrix[i][j]);
                    }
                }
            }
        }
        else if (line <= 2 && column <= 8) {

            for (int i = 0; i <= 2; i++) {
                for (int j = 6; j <= 8; j++) {

                    if (matrix[i][j] != 0) {
                        characterByBoard.add(matrix[i][j]);
                    }
                }
            }
        }
        else if (line <= 5 && column <= 2) {

            for (int i = 3; i <= 5; i++) {
                for (int j = 0; j <= 2; j++) {

                    if (matrix[i][j] != 0) {
                        characterByBoard.add(matrix[i][j]);
                    }
                }
            }
        }
        else if (line <= 5 && column <= 5) {

            for (int i = 3; i <= 5; i++) {
                for (int j = 3; j <= 5; j++) {

                    if (matrix[i][j] != 0) {
                        characterByBoard.add(matrix[i][j]);
                    }
                }
            }
        }
        else if (line <= 5 && column <= 8) {

            for (int i = 3; i <= 5; i++) {
                for (int j = 6; j <= 8; j++) {

                    if (matrix[i][j] != 0) {
                        characterByBoard.add(matrix[i][j]);
                    }
                }
            }
        }
        else if (line <= 8 && column <= 2) {

            for (int i = 6; i <= 8; i++) {
                for (int j = 0; j <= 2; j++) {

                    if (matrix[i][j] != 0) {
                        characterByBoard.add(matrix[i][j]);
                    }
                }
            }
        }
        else if (line <= 8 && column <= 5) {

            for (int i = 6; i <= 8; i++) {
                for (int j = 3; j <= 5; j++) {

                    if (matrix[i][j] != 0) {
                        characterByBoard.add(matrix[i][j]);
                    }
                }
            }
        }
        else if (line <= 8 && column <= 8) {

            for (int i = 6; i <= 8; i++) {
                for (int j = 6; j <= 8; j++) {

                    if (matrix[i][j] != 0) {
                        characterByBoard.add(matrix[i][j]);
                    }
                }
            }
        }

        ArrayList<Integer> possibilities = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {

            if (!hasValue(i, charactersByLine) && !hasValue(i, characterByColumn)
                && !hasValue(i, characterByBoard)) {

                possibilities.add(i);
            }
        }
        
        return possibilities;
    }

    public static boolean hasValue(int value, ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) == value) {
                return true;
            }
        }
        return false;
    }

    public static void printSudokuSolver(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
