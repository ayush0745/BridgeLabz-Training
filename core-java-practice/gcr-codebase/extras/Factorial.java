import java.util.Scanner;

public class Factorial {
	//method to find factorial using recursion
	public static int fact( int num ) {
		if( num == 1 ) return 1;
		
	  return num * fact( num - 1 );
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter the number to find factorial");
		int num = scanner.nextInt();
		int result = fact( num );
		display( result );
	}
	public static void display( int output ) {
		System.out.println(" factorial is " + output);
	}
}
