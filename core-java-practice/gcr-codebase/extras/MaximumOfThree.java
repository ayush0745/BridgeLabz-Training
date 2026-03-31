import java.util.Scanner;

public class MaximumOfThree {
	public static int Maximum( int num1, int num2, int num3 ) {
		if( num1 > num2 && num1 > num3) return num1;
		else if( num2 > num1 && num2 > num3 ) return num2;
		
		return num3;
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		int num3 = scanner.nextInt();
		int result = Maximum( num1, num2, num3);
		System.out.println("maximum number is " + result );
	}
}
