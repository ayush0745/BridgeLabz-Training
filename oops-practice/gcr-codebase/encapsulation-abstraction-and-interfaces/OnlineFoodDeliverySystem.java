abstract class FoodItem{
	private String itemName;
	private double price;
	private int quantity;
	
	FoodItem( String itemName, double price, int quantity){
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	
	abstract double calculateTotalPrice();
	
	public void getItemDetails() {
		System.out.println("itemname : "  + itemName);
		System.out.println("price : " + price);
		System.out.println("quantity : " + quantity);
	}
	
	public String getItemName() { return itemName; }
	public int getQuantity( ) {return quantity;}
	public double getPrice() {return price;}
}
interface Discountable{
	void applyDiscount( double percentage);
	String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    private double discountAmount = 0;

    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - discountAmount;
    }

    @Override
    public void applyDiscount(double percentage) {
        this.discountAmount = (getPrice() * getQuantity()) * (percentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Vegetarian Discount Applied: $" + discountAmount;
    }

}
class NonVegItem extends FoodItem {
    private final double SURCHARGE = 2.50; 

    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + SURCHARGE;
    }
}

class OnlineFoodDeliverySystem{
	
	public static void processOrder(FoodItem item) {
        System.out.println("Processing: " );
        item.getItemDetails();
        System.out.println("Total Cost: $" + item.calculateTotalPrice());
        
        
        if (item instanceof Discountable) {
            ((Discountable) item).applyDiscount(10); 
            System.out.println(((Discountable) item).getDiscountDetails());
            System.out.println("New Total: $" + item.calculateTotalPrice());
        }
        System.out.println("-----------------------------------");
    }
	public static void main(String[] args) {
		FoodItem veg = new VegItem("palak", 20.0, 3);
		FoodItem nonVeg = new NonVegItem("chicken", 250.0, 4);
		
		processOrder(veg);
		processOrder(nonVeg);
	}
	
}