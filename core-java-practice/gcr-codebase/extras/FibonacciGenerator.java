
import java.util.Scanner;
//program to generate fibonacci sequence
public class FibonacciGenerator {
	//method to generate fibonacci
	public static void fibonacci( int num ) {
		int [] fibb = new int[num];
		
		fibb[0] = 0;
		fibb[1] = 1;
		for( int i = 2; i < num; i++) {
			fibb[i] = fibb[i-1] + fibb[i-2];
		}
		
		//display
		for( int value : fibb ) {
			System.out.print( value + " - ");
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter no. of terms");
		int num = scanner.nextInt();
	    fibonacci( num );
	}
}
