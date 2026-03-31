
// Creating Class with name Abundant indicating the purpose is to 
// check sum of all the divisors of the number is greater than the number itself

import java.util.Scanner;

public class AbundantChecker {
	public static void main(String[] args) {
		// Create a Scanner Object
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a number : ");
		
		//Get the input for the number variable
		int number = scanner.nextInt();
		
		//Create an integer variable sum with initial value 0
		int sum = 0;
		
		// Create a for loop to find divisors of number
		for(int i = 1; i < number; i++ ) {
			
			// Find the divisor of the number 
			if( number % i == 0) {
				// adding the divisors to the sum
				sum += i; 
			}
		}
		
		// Check if  sum of all the divisors of the number is greater than the number itself
		if( sum > number ) {
			System.out.println("Abundant Number");
		}
		else {
			System.out.println("Not an Abundant Number");
		}

	}
}
