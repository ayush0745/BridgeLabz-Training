public class ShoppingCartSystem {

	public static void main(String[] args) {
		
		Cart cart = new Cart();

		cart.addItem("Apple", 50.0);
		cart.addItem("Banana", 20.0);
		cart.addItem("Orange", 30.0);
		cart.addItem("Apple", 25.0);
		cart.addItem("Mango", 80.0);
		cart.addItem("Banana", 10.0);

		cart.displayItems();
		cart.displayOrder();
		cart.displayPrice();
	}

}