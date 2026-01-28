import java.util.*;

class TableAlreadyReservedException extends Exception{
	public TableAlreadyReservedException(String message) {
		super(message);
	}
}
class Booking{
	HashMap<Integer,Integer> map;
	List<Integer> list;
	
	public Booking() {
		map = new HashMap<>();
		list = new ArrayList<>();
		
	}
	
	public void reserveTable(int table,int personNumber) {
		try {
				if(map.containsKey(table)) {
				    	throw new TableAlreadyReservedException("already reserved");
				    }
				    else {
				    	map.put(table, personNumber );
				    	list.add(table);
				    	System.out.println("table no. " + table + " booked for " + personNumber + "person");
				    }
				
			
		}
		catch(TableAlreadyReservedException e){
			System.out.println(e);
		}
	}
	public void cancelReservation(int table) {
		if(map.containsKey(table)) {
			map.remove(table);
			System.out.println("table no. " + table + " removed");
		}
		else {
			System.out.println("not booked yet");
		}
	}
	public void showAvailableTables() {
		System.out.println("available tables are : ");
		for(int i =1; i<= 10;i++) {
			if(!map.containsKey(i)) {
				System.out.print(i + " ");
			}
		}
	}
	
	
}
public class ReservationSystem{
	public static void main(String[] args) {
		Booking b = new Booking();
		
		b.reserveTable(7, 4);
		b.reserveTable(9, 4);
		b.cancelReservation(7);
		b.showAvailableTables();
		
	}
}