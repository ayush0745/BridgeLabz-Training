import java.time.LocalDate;
import java.util.Scanner;
public class DateArthimetic {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String text = scanner.next();
		//convert string to date
		LocalDate date = LocalDate.parse(text);
		//date before operation
		System.out.println("before operations");
		System.out.println(date);
		
		//add days
		date = date.plusDays(7);
		System.out.println("added 7 days");
		System.out.println(date);
		
		// add month
		date = date.plusMonths(1);
		System.out.println("added 1 month");
		System.out.println(date);
		
		//add years
		date = date.plusYears(2);
		System.out.println("added 2 years");
		System.out.println(date);
				
		//substract 3 weeks
		date = date.minusWeeks(3);
		System.out.println("minus 3 weeks from final result");
		System.out.println(date);
		
		
		
	}
}
