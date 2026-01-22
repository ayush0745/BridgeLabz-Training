import java.util.List;

class Customer{
	
	String name;
	
	List<Item> items;
	 
	Customer( String name, List<Item> items){
		this.name = name;
		this.items = items;
	}
}