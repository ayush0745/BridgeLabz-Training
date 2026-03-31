import java.util.Scanner;

public class MatrixOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define dimensions
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        // Create two random matrices
        int[][] matrixA = createRandomMatrix(rows, cols);
        int[][] matrixB = createRandomMatrix(rows, cols);

        System.out.println("\nMatrix A:");
        displayMatrix(matrixA);
        System.out.println("\nMatrix B:");
        displayMatrix(matrixB);

        // Addition
        System.out.println("\nResult of Addition (A + B):");
        displayMatrix(addMatrices(matrixA, matrixB));

        //Subtraction
        System.out.println("\nResult of Subtraction (A - B):");
        displayMatrix(subtractMatrices(matrixA, matrixB));

        //  Multiplication 
        if (rows == cols) {
            System.out.println("\nResult of Multiplication:");
            displayMatrix(multiplyMatrices(matrixA, matrixB));
        } else {
            System.out.println(" Rows must equal columns");
        }

        sc.close();
    }

   
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 9) + 1;
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

  
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}