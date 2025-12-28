import java.util.Scanner;

public class PalindromeChecker {
	public static boolean isPalindrome( String str ) {
		StringBuilder str2 = new StringBuilder( str );
		
		
		
		return str2.reverse().toString().equals(str);
		}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter the string");
		String str = scanner.next();
		
		if(isPalindrome( str )) {
			System.out.println("string is palindrome");
		}
		else {
			System.out.println("string is not palindrome");
		}
	}
}
