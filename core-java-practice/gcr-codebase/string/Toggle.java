import java.util.*;

public class Toggle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//take input for string 
		System.out.print("Enter string: ");
		String str = scanner.next();
		
		//call method 
		String ans = toggleCase(str);
		
		//display result
		System.out.println("Toggled string: " + ans);
	}
	
	//method to toggle characters fo string
	public static String toggleCase(String str) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			// Check if character is uppercase
			if (Character.isUpperCase(ch)) {
				result.append(Character.toLowerCase(ch));
			} 
			// Check if character is lowercase
			else if (Character.isLowerCase(ch)) {
				result.append(Character.toUpperCase(ch));
			} 
			// not a letter 
			else {
				result.append(ch);
			}
		}
		return result.toString();
	}
}