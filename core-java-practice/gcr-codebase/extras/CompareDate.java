import java.time.LocalDate;
import java.util.Scanner;
public class CompareDate{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String text = scanner.next();
		//convert string to date
		LocalDate date1 = LocalDate.parse(text);
		
		String text2 = scanner.next();
		//convert string to date
		LocalDate date2 = LocalDate.parse(text2);
		
		if( date1.isBefore(date2)) {
			System.out.println("first date comes first");
		}
		else if( date1.isAfter(date2)) {
			System.out.println("first date comes after second date");
		}
		else {
			System.out.println("first equals second");
		}
	}
}