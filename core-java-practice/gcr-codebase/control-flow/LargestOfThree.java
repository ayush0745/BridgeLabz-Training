import java.util.Scanner;
// level 1 control flow problem
public class LargestOfThree {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number1 = scanner.nextInt();
		int number2 = scanner.nextInt();
		int number3 = scanner.nextInt();
		String answer1 = number1 > number2 && number1 > number3 ? "yes" : "no";
		String answer2 = number1 < number2 && number2 > number3 ? "yes" : "no";
		String answer3 = number2 < number3 && number2 < number3 ? "yes" : "no";
		 
		System.out.println("Is the first number the largest? " + answer1);
		System.out.println("Is the second number the largest? " + answer2);
		System.out.println("Is the third number the largest? " + answer3);
	}
}
