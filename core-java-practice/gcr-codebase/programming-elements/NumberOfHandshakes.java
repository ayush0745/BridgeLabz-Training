import java.util.Scanner;

public class NumberOfHandshakes {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfStudents = scanner.nextInt();
		int numberOfHandshakes = (numberOfStudents * (numberOfStudents - 1) / 2);
		System.out.println("number of possible handshakes is " + numberOfHandshakes );
		scanner.close();
	}
}
