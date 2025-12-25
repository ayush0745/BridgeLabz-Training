import java.util.Scanner;

//program to find spring spring season
public class SpringSeason {
	//method to fin spring season
	public static boolean springSeason( int day, int month) {
		return (month == 3 && day >= 20 && day <= 31) ||
                (month == 4 && day >= 1  && day <= 30) ||
                (month == 5 && day >= 1  && day <= 31) ||
                (month == 6 && day >= 1  && day <= 20);
	}
	
	public static void main(String[] args) {
		
		//crete scanner object
		Scanner scanner = new Scanner(System.in);
		
		//take input
		System.out.println("enter month:");
		int month = scanner.nextInt();
		System.out.println("enter day");
		int day = scanner.nextInt();
		
		boolean isSpring =  springSeason( day, month);

		if(isSpring) {
			System.out.println("Its a Spring Season");
	    } 
		else {
			System.out.println("Not a Spring Season");
		}
		
	}
}
