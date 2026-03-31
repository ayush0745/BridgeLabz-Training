import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class DateFormatter {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		//in format dd/MM/yyyy
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("dd/MM/yyyy	----	" + date.format(format1));
		
		//format yyyy-MM-dd
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("yyyy-MM-dd	----	" +  date.format(format2));
		
		//format  EEE, MMM dd, yyyy 
		DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
		System.out.println("EEE, MMM dd, yyyy	----   " +  date.format(format3));
		
	}
}
