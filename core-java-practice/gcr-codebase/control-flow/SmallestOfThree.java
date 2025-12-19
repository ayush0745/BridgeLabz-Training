import java.util.Scanner;
// level 1 control flow problem
public class SmallestOfThree {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number1 = scanner.nextInt();
		int number2 = scanner.nextInt();
		int number3 = scanner.nextInt();
		String answer = number1 < number2 && number1 < number3 ? "yes" : "no";
		System.out.println("Is the first number the smallest? " + answer);
	}
}
