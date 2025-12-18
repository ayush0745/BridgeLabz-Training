package programmingelements;
import java.util.Scanner;
public class KmToMileWithInput {
	public static void main (String [] args) {
		Scanner scanner = new Scanner (System.in);
			double kilometer = scanner.nextDouble();
			double mile = kilometer * 0.621371;
	        System.out.println("The total miles is  " + mile + " mile" + " for the given " + kilometer + "km");
	}
}
