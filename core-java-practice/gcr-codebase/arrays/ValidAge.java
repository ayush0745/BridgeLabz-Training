import java.util.Scanner;

// creating Class name ValidAge which indicates
// to find students who can vote
public class ValidAge {
	public static void main(String[] args) {
       
		// create scanner object
		Scanner scanner = new Scanner(System.in);
		
		//create array  of space 10
		int [] age = new int[10];
		
		// taking the input for student age
		for( int i = 0; i < age.length; i++) {
			System.out.print("Enter age for student " + (i + 1) + ": ");
			age[i] = scanner.nextInt();
		}
		
		//display the output
		System.out.println("--- results---");
		for(int j = 0; j < age.length; j++) {
			
			// check the number is valid
			if( age[j] < 0 ) {
				System.out.println(" Invalid age.");
				
			}
			
			// check the valid age 
			if( age[j] >= 18 ) {
				System.out.println("The student with the age " + age[j] + " can vote.");
			}
			else {
				System.out.println("The student with the age " + age[j] + " cannot vote.");
			}
		}
	}

}
