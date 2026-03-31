package programmingelements;
import java.util.Scanner;
public class UniversityWithInput {
	public static void main(String [] args) {
	Scanner scanner = new Scanner(System.in);
	
	double fee = scanner.nextDouble();
	double discountPercent = scanner.nextDouble();
	double discount = (12500 * discountPercent) / 100 ;
	fee = fee - discount;
	System.out.println("The discount amount is INR "+ discount+" final discounted fees is INR "+ fee);
	scanner.close();
}
}