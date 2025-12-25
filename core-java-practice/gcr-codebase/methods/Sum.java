import java.util.Scanner;

//program to find sum of n natural number using loop
public class Sum {
	
	//method to find sum 
	public static int sum(int n) {
		//define sum variable
		int sum = 0;
				
		//loop for sum
		for( int i = 1; i <= n; i++) {
		sum += i;
		}
		
		return sum;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//take input
		int n = scanner.nextInt();
		
		int sum = sum(n);
		//result
		System.out.println("output......");
		System.out.println(sum);
	}

}
