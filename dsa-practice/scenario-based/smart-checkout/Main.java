import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		Item apple = new Item("apple");
		Item milk = new Item("milk");
		
		SmartCheckout checkout = new SmartCheckout();
		
		checkout.priceMap.put(apple, 80);
		checkout.priceMap.put(milk, 50);
		
		checkout.stockMap.put(apple,10);
		checkout.stockMap.put(milk,2);
		
		Customer customer = new Customer( "Ayush " , Arrays.asList( apple,apple,milk,apple));
		Customer customer2 = new Customer( "Varun" , Arrays.asList(milk,milk,apple));
		
		checkout.addCustomer(customer);
		checkout.addCustomer(customer2);
		
		checkout.processWork();
		checkout.processWork();
	}
}
