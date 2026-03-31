import java.util.Scanner;

//program to find windChill temperature
public class WindChill {
	public static double calculateWindChill(double temperature, double windSpeed) {
		return  35.74 + (0.6215 * temperature) + (( 0.4275 * temperature - 35.75) * Math.pow( windSpeed, 0.16));
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter the temperatue:");
		double temp = scanner.nextDouble();
		System.out.println("enter the wind speed:");
		double windSpeed = scanner.nextDouble();
		
		double windChill = calculateWindChill( temp, windSpeed);
		
		//output
		System.out.println("windchill = " + windChill);
		System.out.printf("windchill = %.2f", windChill);
	}
	

}
