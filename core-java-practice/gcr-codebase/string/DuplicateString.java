import java.util.*;

public class DuplicateString{
	public static void main(String[] args) {
		
		//create scanner object
		Scanner scanner = new Scanner(System.in);
		
		//take string input
		String str = scanner.next();
		
		// call function and save in string 
		String ans = removeDuplicateChars( str );
		
		System.out.println("String after removing duplicates : " + ans );
	
	}
	
	//method to remove duplicate characters using nested loops
	public static String removeDuplicateChars( String str ) {
		StringBuilder result = new StringBuilder();
		
		//outer loop to pick each character one by one
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			boolean isDuplicate = false;
			
			//inner loop to check if the character appeared previously in the string
			for (int j = 0; j < i; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					isDuplicate = true;
					break; 
				}
			}
			
			//if no duplicate was found in the previous characters, add it to result
			if (!isDuplicate) {
				result.append(currentChar);
			}
		}
		
		return result.toString();
	}
}