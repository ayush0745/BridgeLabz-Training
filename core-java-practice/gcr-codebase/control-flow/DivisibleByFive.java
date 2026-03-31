import java.util.Scanner;
// level 1 control flow problem
public class DivisibleByFive {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		String answer = "";
		if(number % 5 == 0) {
			answer = "yes";
		}
		else {
			answer = "no";
		}
		System.out.println("Is the number " + number + " divisible by 5? " + answer );
		scanner.close();
	}
}
