import java.util.Scanner;

public class PalindromeCheck {
	public static void main(String[] args) {
		
		//create scanner object
		Scanner scanner = new Scanner(System.in);
		
		//take string input
		String str = scanner.next();
		
		// call function and save in string 
		boolean ans = palindrome( str );
		
		if( ans ) {
			System.out.println( "string is palindrome ");
		}
		else {
			System.out.println( "String is not palindrome ");
		}
	
	}
	
	//method to check palindrome string
	public static boolean palindrome( String str ) {
		StringBuilder str1 = new StringBuilder();
		
		//loop to reverse string
		for( int i = str.length()-1; i >= 0; i--) {
			str1.append( str.charAt(i));
		}
		
		return str1.toString().equals(str);
	}

}
