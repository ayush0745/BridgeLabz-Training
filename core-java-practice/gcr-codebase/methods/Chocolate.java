import java.util.Scanner;

//program to  find how many choclate each children get
public class Chocolate {
	//method to find remainder and quotient
	public static int[] findRemainderAndQuotient(int number, int divisor) {
		int quotient = number / divisor;
		int remainder = number % divisor;
		
		return new int[] {quotient,remainder};
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//input 
		System.out.println("Enter no. of children:");
		int N = scanner.nextInt();
		System.out.println("Enter no. of chocolates");
		int M = scanner.nextInt();
		
		int[] result = findRemainderAndQuotient(M, N);
		
		//output
		System.out.println("No.of  chocolates each children get: " + result[0]);
		System.out.println("chocolates remaining" + result[1]);
		
	}
	
}
