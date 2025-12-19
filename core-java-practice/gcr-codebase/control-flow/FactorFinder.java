import java.util.Scanner;

// level 2 control flow problem
public class FactorFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number ");
        int number = scanner.nextInt();

        if (number > 0) {
        	System.out.print("Factors of " + number + " are: ");
            // Loop from 1 to the number itself
        	for (int i = 1; i <= number; i++) {
        		// Check if number is perfectly divisible by i
                if (number % i == 0) {
                        System.out.print(i + " ,");
                }
             }
             System.out.println();
            } 
        else {
                System.out.println("Please enter a positive integer.");
        }
         
        scanner.close();
    }}