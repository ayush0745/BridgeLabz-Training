import java.util.Scanner;

public class SideOfSquare {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int perimeter = scanner.nextInt();
		System.out.println("The length of the side is " + perimeter / 4);
	}
}
