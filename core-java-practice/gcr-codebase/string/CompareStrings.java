import java.util.Scanner;

// program to compare to strings using loop and equals
public class CompareStrings {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//taking input for two strings
		String string1 = scanner.next();
		String string2 = scanner.next();
		
		//comparing using chartAt 
		boolean CompareUsingCharAT = CompareUsingCharAt(string1, string2);

        //  Use built-in method to check
        boolean builtInResult = string1.equals(string2);

        //  Display results 
        System.out.println("result using chaAt: " + CompareUsingCharAT);
        System.out.println("result using builtin method:  " + builtInResult);
        
        if (CompareUsingCharAT == builtInResult) {
            System.out.println("Both methods gave the same answer!");
        }
    }

    // Method to compare using charAt
    public static boolean CompareUsingCharAt(String s1, String s2) {
        // If lengths are different, they can't be the same
        if (s1.length() != s2.length()) {
            return false;
        }

        // Check every character one by one
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false; 
            }
        }
        return true; 
    }
}

        