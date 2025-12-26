import java.util.*;

public class LongestWord {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a sentence:");
		String str = scanner.nextLine();
		
		String ans = findLongestWord(str);
		
		System.out.println("Longest word: " + ans);
	}
	
	public static String findLongestWord(String str) {
		// Split string by one or more spaces
		String[] words = str.split("\\s+");
		String longest = "";
		
		for (String word : words) {
			if (word.length() > longest.length()) {
				longest = word;
			}
		}
		return longest;
	}
}