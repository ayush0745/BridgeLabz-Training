import java.util.Scanner;

// Generate math table and store it in an array
// creating the class Multiplication Table
public class MultiplicationTable {
    public static void main(String[] args) {
    	
    	// create scanner object
        Scanner scanner = new Scanner(System.in);
        
        // taking the input 
        System.out.print("Table for: ");
        int n = scanner.nextInt();
        int[] table = new int[10];

        // logic to multiply and save to array
        for (int i = 0; i < 10; i++) {
            table[i] = n * (i + 1);
        }

        // display results in requested format
        for (int i = 0; i < 10; i++) {
            System.out.println(n + " * " + (i + 1) + " = " + table[i]);
        }
        scanner.close();
    }
}