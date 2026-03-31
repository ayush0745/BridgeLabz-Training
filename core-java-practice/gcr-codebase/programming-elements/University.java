package programmingelements;

public class University {
	public static void main (String [] args) {
		double fee = 12500;
		double discountPercent = 10;
		double discount = (12500 * discountPercent) / 100;
		fee = fee - discount;
		System.out.println("The discount amount is INR "+ discount+" final discounted fees is INR "+ fee);
	    
	}

}
