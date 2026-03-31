import java.util.Scanner;
//program to check number is positive ,negative or zero

public class NumberCheck {
	
	//method to find positive negative or zero
	public static int check( int number) {
		if( number > 0) return 1;
		else if ( number < 0) return -1;
		
		return 0;
	}
	
	
	public static void main(String[] args) {
		
		//create scanner object
		Scanner scanner = new Scanner(System.in);
		
		//take input 
		int number = scanner.nextInt();
				
	    int result = check( number );
		
		System.out.println(result);
		
		
	}

}
