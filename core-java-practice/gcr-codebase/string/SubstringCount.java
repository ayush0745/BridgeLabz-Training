import java.util.*;

public class SubstringCount {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//take input
		System.out.print("Enter string: ");
		String str = scanner.next();
		System.out.print("Enter substring : ");
		String sub = scanner.next();
		
		//call method and store count in a variable
		int count = countOccurrences(str, sub);
		
		//display output
		System.out.println("no. of occurances: " + count);
	}
	
	//method to find count of substring occurences
	public static int countOccurrences(String str, String sub) {
		int count = 0;
		int subLen = sub.length();
		int strLen = str.length();
		
		// Loop 
		for (int i = 0; i <= strLen - subLen; i++) {
			
			String currentPart = str.substring(i, i + subLen);
			if (currentPart.equals(sub)) {
				count++;
			}
		}
		return count;
	}
}