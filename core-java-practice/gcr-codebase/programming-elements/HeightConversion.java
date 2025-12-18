package programmingelements;
import java.util.Scanner;
public class HeightConversion {
	public static void main (String [] args) {
		Scanner scanner = new Scanner(System.in);
		double heightInCm = scanner.nextDouble();
		double heightInfeet = heightInCm * 0.0328084;
	    double heightInInches = heightInCm * 0.393701;
	    System.out.print("Your Height in cm is " + heightInCm + " while in feet is " + heightInfeet + " and inches is " +  heightInInches);
		scanner.close();
	}
}
