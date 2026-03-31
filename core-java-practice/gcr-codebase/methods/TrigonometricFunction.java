import java.util.Scanner;
public class TrigonometricFunction {
	//method to find  TrigonometricFunction
	public static double[] calculateTrigonometricFunctions(double angle) {
        // Defining PI 
        final double PI = Math.PI;

        //  degrees to radians
        double radians = angle * (PI / 180.0);

        //Calculate values using Math class functions
        double sineVal = Math.sin(radians);
        double cosineVal = Math.cos(radians);
        double tangentVal = Math.tan(radians);

        return new double[]{sineVal, cosineVal, tangentVal};
    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//input
		double angleInDegrees = scanner.nextDouble();
		double[] results = calculateTrigonometricFunctions(angleInDegrees);
		
		//output
		System.out.println("Results for " + angleInDegrees + " degrees:");
        System.out.println("Sine: " + results[0]);
        System.out.println("Cosine: " + results[1]);
        System.out.println("Tangent: " + results[2]);
	}
}
