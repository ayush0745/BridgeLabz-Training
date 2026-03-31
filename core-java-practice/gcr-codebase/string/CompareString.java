import java.util.*;

public class CompareString{
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("String 1: ");
		String s1 = scanner.next();
		System.out.print("String 2: ");
		String s2 = scanner.next();
		
		int result = compareLexicographically(s1, s2);
		
		if (result < 0) {
			System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\"");
		} else if (result > 0) {
			System.out.println("\"" + s2 + "\" comes before \"" + s1 + "\"");
		} else {
			System.out.println("Both strings are equal.");
		}
	}
	
	public static int compareLexicographically(String s1, String s2) {
	
		int minLength = Math.min(s1.length(), s2.length());
		
		for (int i = 0; i < minLength; i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			
			// Compare ASCII values
			if (c1 != c2) {
				return c1 - c2; 
			}
		}
		
		return s1.length() - s2.length();
	}
}