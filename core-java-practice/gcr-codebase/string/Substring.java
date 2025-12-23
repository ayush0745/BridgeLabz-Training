import java.util.Scanner;
// program to compare substrings using builtin method and by using charAt
public class Substring {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//take the input for string and start indexx and the end index
		String str = scanner.next();
		int startIndex = scanner.nextInt();
		int endIndex = scanner.nextInt();
		
		String builtInResult = str.substring(startIndex, endIndex);
		
		String customResult = customSubstring( str, startIndex, endIndex);
		
		//display results
		System.out.println("result using builtin method : " + builtInResult);
		System.out.println("result using customResult : " + customResult);
		
		//compare both results
		if (customResult.equals(builtInResult)) {
		    System.out.println("Both methods gave the same answer!");
		}
	}
	
	//method for substring using charAt 
	public static String customSubstring(String str, int start, int end) {
		
		//create string to store result
		String result = "";
		
		for( int i = start; i < end; i++ ) {
			result += str.charAt(i);
		}
		
		//return the result
		return result;
		
	}
	
}
