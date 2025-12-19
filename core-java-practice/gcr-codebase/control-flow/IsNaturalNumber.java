import java.util.Scanner;
//level 1 control flow problem
public class IsNaturalNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		if( number > 0) {
			System.out.println("The sum of " + number + " natural numbers is " + (number * (number + 1))/2);
			
		}
		else {
			System.out.println("The number " + number + " is not natural");
		}
	}
}
