import java.util.Scanner;

public class QuotientAndRemainder {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number1 = scanner.nextInt();
		int number2 = scanner.nextInt();
		System.out.println("The Quotient is " + number1 / number2 + " Reminder is " + number1 % number2 + " of two number " + number1 + " and " + number2);
		scanner.close();
		
	}
}
