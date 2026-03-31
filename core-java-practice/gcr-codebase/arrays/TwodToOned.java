import java.util.Scanner;

// program to flatten a 2D matrix into a single 1D array
public class TwodToOned {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get dimensions for the matrix
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        
        // input for the 2D array
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // create 1D array with total size (rows * columns)
        int[] flatArray = new int[rows * cols];
        int index = 0;

        // nested loop to copy elements into the 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flatArray[index] = matrix[i][j];
                index++; 
            }
        }

        // display the results
        System.out.println("\nFinal 1D Array:");
        for (int i = 0; i < flatArray.length; i++) {
            System.out.print(flatArray[i] + " ");
        }

        scanner.close();
    }
}