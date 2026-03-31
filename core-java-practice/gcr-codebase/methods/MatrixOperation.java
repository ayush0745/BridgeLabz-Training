public class MatrixProcessor {

    public static void main(String[] args) {
       
        int size2 = 2;
        int size3 = 3;

        // Create random matrices
        double[][] matrix2x2 = createRandomMatrix(size2, size2);
        double[][] matrix3x3 = createRandomMatrix(size3, size3);

        System.out.println(" 2x2 Matrix ");
        displayMatrix(matrix2x2);
        processMatrix(matrix2x2, size2);

        System.out.println("\n 3x3 Matrix Analysis");
        displayMatrix(matrix3x3);
        processMatrix(matrix3x3, size3);
    }

   
    public static double[][] createRandomMatrix(int rows, int columns) {
        double[][] matrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int) (Math.random() * 9) + 1;
            }
        }
        return matrix;
    }

    
     //Finds the transpose of a matrix
    public static double[][] findTranspose(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        double[][] transposed = new double[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    // Determinant of a 2x2 matrix
    
    public static double findDeterminant2x2(double[][] m) {
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }

   // Determinant of a 3x3 matrix
    
    public static double findDeterminant3x3(double[][] m) {
        double a = m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1]);
        double b = m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0]);
        double c = m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
        return a - b + c;
    }

   // Inverse of a 2x2 matrix
    
    public static double[][] findInverse2x2(double[][] m) {
        double det = findDeterminant2x2(m);
        if (det == 0) return null;
        double[][] inv = {{m[1][1] / det, -m[0][1] / det}, 
                          {-m[1][0] / det, m[0][0] / det}};
        return inv;
    }

   //Inverse of a 3x3 matrix 
     
    public static double[][] findInverse3x3(double[][] m) {
        double det = findDeterminant3x3(m);
        if (det == 0) return null;
        double[][] inv = new double[3][3];
        inv[0][0] = (m[1][1] * m[2][2] - m[1][2] * m[2][1]) / det;
        inv[0][1] = (m[0][2] * m[2][1] - m[0][1] * m[2][2]) / det;
        inv[0][2] = (m[0][1] * m[1][2] - m[0][2] * m[1][1]) / det;
        inv[1][0] = (m[1][2] * m[2][0] - m[1][0] * m[2][2]) / det;
        inv[1][1] = (m[0][0] * m[2][2] - m[0][2] * m[2][0]) / det;
        inv[1][2] = (m[1][0] * m[0][2] - m[0][0] * m[1][2]) / det;
        inv[2][0] = (m[1][0] * m[2][1] - m[1][1] * m[2][0]) / det;
        inv[2][1] = (m[2][0] * m[0][1] - m[0][0] * m[2][1]) / det;
        inv[2][2] = (m[0][0] * m[1][1] - m[0][1] * m[1][0]) / det;
        return inv;
    }

     //Displays the matrix in tabular format
     
    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%8.2f ", value);
            }
            System.out.println();
        }
    }

    private static void processMatrix(double[][] matrix, int size) {
        System.out.println("Transpose:");
        displayMatrix(findTranspose(matrix));
        
        double det = (size == 2) ? findDeterminant2x2(matrix) : findDeterminant3x3(matrix);
        System.out.println("Determinant: " + det);

        if (det != 0) {
            System.out.println("Inverse:");
            displayMatrix((size == 2) ? findInverse2x2(matrix) : findInverse3x3(matrix));
        } else {
            System.out.println("Determinant is 0");
        }
    }
}