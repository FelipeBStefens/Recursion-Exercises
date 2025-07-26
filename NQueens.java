public class NQueens {
    
    public static void main(String[] args) {

        System.out.println(nQueens(new boolean[5][5], 0));
    }

    public static int nQueens(boolean[][] matrix, int line) {

        if (line == matrix.length) {
            printMatrix(matrix);
            return 1;
        }

        int count = 0;
        for (int j = 0; j < matrix[0].length; j++) {

            if (safe(matrix, line, j)) {

                matrix[line][j] = true;
                count += nQueens(matrix, line + 1);
                matrix[line][j] = false;
            }
        }

        return count;
    }

    private static boolean safe(boolean[][] matrix, int line, int column) {
        
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] && (j == column 
                    || i + j == line + column || i - j == line - column)) {

                    return false;
                }
            }
        }
        return true;
    }

    private static void printMatrix(boolean[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j]) {
                    System.out.print("Q");
                }
                else {
                    System.out.print("*");
                }
            } 
            System.out.println();
        }
        System.out.println();
    }
}