public class NKnights {
    
    public static void main(String[] args) {
        
        System.out.println(nKnights(new boolean[4][4], 0));
    }

    public static int nKnights(boolean[][] matrix, int line) {

        if (line == matrix.length) {

            printMatrix(matrix);
            System.out.println();
            return 1;
        }

        int count = 0;

        for (int j = 0; j < matrix[0].length; j++) {

            if (safe(matrix, line, j)) {

                matrix[line][j] = true;
                count += nKnights(matrix, line + 1);
                matrix[line][j] = false;
            }
        }

        return count;
    }

    public static boolean safe(boolean[][] matrix, int line, int column) {
 
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (line - 2 >= 0) {
                    if (column - 1 >= 0 && matrix[line - 2][column - 1]) {
                        return false;
                    }
                    if (column + 1 < matrix[0].length && matrix[line - 2][column + 1]) {
                        return false;
                    }
                }

                if (line - 1 >= 0) {
                    if (column - 2 >= 0 && matrix[line - 1][column - 2]) {
                        return false;
                    }
                    if (column + 2 < matrix[0].length && matrix[line - 1][column + 2]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void printMatrix(boolean[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j]) {
                    System.out.print("K");
                }
                else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
