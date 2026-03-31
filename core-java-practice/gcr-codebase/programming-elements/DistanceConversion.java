import java.util.Scanner;

public class DistanceConversion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double distance = scanner.nextDouble();
		System.out.println("distance in feets is " + distance + " while in yards is " + 0.333333 * distance + " and in miles is " + 0.000189394 * distance);
	}
}
