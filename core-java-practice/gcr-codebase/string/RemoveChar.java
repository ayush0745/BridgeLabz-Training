import java.util.*;

public class RemoveChar {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("String: ");
		String str = scanner.nextLine();
		
		System.out.print("Character to Remove: ");
		char charToRemove = scanner.next().charAt(0);
		
		// call function
		String ans = removeSpecificChar(str, charToRemove);
		
		System.out.println("Modified String: " + ans);
	}
	
	public static String removeSpecificChar(String str, char target) {
		StringBuilder result = new StringBuilder();
		
		// loop through the string
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			
			
			if (currentChar != target) {
				result.append(currentChar);
			}
		}
		
		return result.toString();
	}
}