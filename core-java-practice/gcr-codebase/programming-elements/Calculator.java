
import java.util.Scanner;

public class Calculator {
	public static void main (String [] args) {
		Scanner scanner = new Scanner(System.in);
		float number1 = scanner.nextFloat();
		float number2 = scanner.nextFloat();
		float addition = number1 + number2;
		float substraction = number1 - number2;
		float multiplication = number1 * number2;
		float divison = number1 / number2;
		System.out.print("The addition, subtraction, multiplication and division value of 2 numbers " + number1 + " and " + number2 + " is " + addition + " " + substraction + " " + multiplication + " and " + divison);
		scanner.close();
	}
}
