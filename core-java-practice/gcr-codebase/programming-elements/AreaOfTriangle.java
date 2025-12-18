import java.util.Scanner;

public class AreaOfTriangle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double base = scanner.nextDouble();
		double height = scanner.nextDouble();
		double areaInCm = 0.5 * base * height;
		System.out.println("Your Height in cm is " + areaInCm + " while in feet is " + 0.0328084 * areaInCm + " and inches is " + areaInCm * 0.393701 );
	}

}
