import java.util.Scanner;

public class PrimeNumberCheck {
	
	//method to check number is prime or not 
	public static boolean isPrime(int num) {
	   
	    if (num <= 1) return false;
	    
	    for (int i = 2; i * i <= num; i++) {
	        if (num % i == 0) {
	           
	            return false;
	        }
	    }
	    
	   
	    return true;
	}
	
	public static void main(String[] args) {
		
		//create scanner object
		Scanner scanner = new Scanner(System.in);
		
		//take input 
		int num = scanner.nextInt();
		
//		if( isPrime( num )) {
//			System.out.println("number is prime ");
//		}
//		else {
//			 System.out.println("number is not prime");
//		}
		
		System.out.println(isPrime(num) ? "Num is prime" : "Num is not prime"); 
	}

}
