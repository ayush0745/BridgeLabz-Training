import java.util.Scanner;

public class CostOfItem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		float unitPrice = scanner.nextFloat();
		float quantity = scanner.nextFloat();
		System.out.println("The total purchase price is INR " + unitPrice * quantity + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
	}

}
