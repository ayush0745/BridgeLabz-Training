import java.util.Scanner;

public class SumComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a positive integer : ");
        int n = sc.nextInt();

        //  Check if it's a natural number
        if (n <= 0) {
            System.out.println("Invalid input. Please enter a natural number.");
        } else {
            // Compute using recursion
            long recursiveResult = sumRecursive(n);
            
            // Compute using formula
            long formulaResult = sumFormula(n);

            // Compare and display results
            System.out.println(" Results ");
            System.out.println("Sum using Recursion: " + recursiveResult);
            System.out.println("Sum using Formula:    " + formulaResult);
            
            if (recursiveResult == formulaResult) {
                System.out.println("Comparison: Both results are identical. Calculation is correct!");
            } else {
                System.out.println("Comparison: Results do not match.");
            }
        }
        sc.close();
    }

    
     // Method to find sum of n natural numbers using recursion
    
    public static long sumRecursive(int n) {
        if (n == 1) {
            return 1; 
        }
        return n + sumRecursive(n - 1);
    }

  
     // Method to find sum of n natural numbers using formula n*(n+1)/2
     
    public static long sumFormula(int n) {
        return (long) n * (n + 1) / 2;
    }
}