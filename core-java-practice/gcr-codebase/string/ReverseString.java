import java.util.*;

public class ReverseString {
	public static void main(String[] args) {
		
		//create scanner object
		Scanner scanner = new Scanner(System.in);
		
		//take string input
		String str = scanner.next();
		
		// call function and save in string 
		String ans = reverseString( str );
		
		System.out.println("reversed string : " + ans );
	
	}
	
	//method to reverse string
	public static String reverseString( String str ) {
		StringBuilder str1 = new StringBuilder();
		
		//loop to reverse string
		for( int i = str.length()-1; i >= 0; i--) {
			str1.append( str.charAt(i));
		}
		
		return str1.toString();
	}

}
