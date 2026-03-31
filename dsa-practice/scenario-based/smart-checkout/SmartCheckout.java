import java.util.*;

class SmartCheckout {

	Queue<Customer> queue = new LinkedList<>();
	Map<Item, Integer> priceMap = new HashMap<>();
	Map<Item, Integer> stockMap = new HashMap<>();
    
	//add customer to queue
	public void addCustomer( Customer customer) {
		queue.add(customer);
		System.out.println(customer.name + " added to queue");
	}
	
	//remove from queue
	public void processWork() {
		Customer customer = queue.poll();
		
		if( customer == null ) {
			System.out.println("no customer in the queue");
		}
		
		int totalBill = 0 ;
		
		for( Item items : customer.items) {
			int price = priceMap.get(items);
			int stock = stockMap.get(items);
			
			if(stock > 0) {
				totalBill += price;
				
				stockMap.put(items,stock-1);
			}
			else {
				System.out.println(items.name + " is out of stock");
			}
		}
		
		System.out.println("customer.name bill = " + totalBill);
	}
}
