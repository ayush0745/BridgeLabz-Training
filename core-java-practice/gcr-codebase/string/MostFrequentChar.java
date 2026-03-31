import java.util.*;

public class MostFrequentChar {
	public static void main(String[] args) {
		
		//create scanner object
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("String: ");
		String str = scanner.next();
		
		// call function and save result
		char ans = findMaxOccurringChar(str);
		
		System.out.println("Most Frequent Character: '" + ans + "'");
	}
	
	public static char findMaxOccurringChar(String str) {
		// Create an array to store the frequency of all 256 ASCII characters
		int[] freq = new int[256];
		
		// Loop through the string and increment the count for each character
		for (int i = 0; i < str.length(); i++) {
			freq[str.charAt(i)]++;
		}
		
		int maxCount = -1;
		char result = ' ';
		
		// Find the character with the maximum count in the frequency array
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if (freq[currentChar] > maxCount) {
				maxCount = freq[currentChar];
				result = currentChar;
			}
		}
		
		return result;
	}
}