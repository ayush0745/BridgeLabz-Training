import java.util.*;

class Cart {
	private Map<String, Double> prices;
	private Map<Integer, String> itemOrder;
	private int itemId;

	Cart() {
		this.prices = new HashMap<String, Double>();
		this.itemOrder = new LinkedHashMap<Integer, String>();
		this.itemId = 1;
	}

	public void addItem(String itemName, double price) {
		prices.put(itemName, prices.getOrDefault(itemName, 0.0) + price);
		itemOrder.put(itemId++, itemName);
	}

	public void displayItems() {
		System.out.println("Item:");
		for (Map.Entry<String, Double> entry : prices.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		System.out.println();
	}

	public void displayOrder() {
		System.out.println("Item Order:");
		for (Map.Entry<Integer, String> entry : itemOrder.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		System.out.println();
	}

	public void displayPrice() {
		System.out.println("Item Price:");
		TreeMap<String, Double> itemsPrice = new TreeMap<String, Double>((a,
				b) -> prices.get(b) != prices.get(a) ? Double.compare(prices.get(b), prices.get(a)) : a.compareTo(b));
		itemsPrice.putAll(prices);
		double total = 0;
		for (Map.Entry<String, Double> entry : itemsPrice.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
			total += entry.getValue();
		}
		System.out.println("Total: " + total);
		System.out.println();
	}

}