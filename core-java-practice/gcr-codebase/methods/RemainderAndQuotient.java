import java.util.Scanner;

//program to find remainder and quotient
public class RemainderAndQuotient {
	
	//method to find remainder and quotient
	public static int[] findRemainderAndQuotient(int number, int divisor) {
		int quotient = number / divisor;
		int remainder = number % divisor;
		
		return new int[] {quotient,remainder};
	}
	
	public static void main(String[] args) {
		//scanner object
		Scanner scanner = new Scanner(System.in);
		
		//take input
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		
		int[] result = findRemainderAndQuotient( num1 ,num2);
		
		//output
		System.out.println("quotient --" + result[0]);
		System.out.println("Remainder --" + result[1]);
		
	}
}
