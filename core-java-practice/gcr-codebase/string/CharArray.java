import java.util.Scanner;

public class CharArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = sc.next();

        // Manual conversion
        char[] manualChars = getCharsManually(text);
        
        // Built-in conversion
        char[] builtInChars = text.toCharArray();

        // Compare 
        boolean isSame = compareArrays(manualChars, builtInChars);
        
        //display
        System.out.println("Arrays match: " + isSame);
    }

    // Manual method to get characters
    public static char[] getCharsManually(String str) {
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }
        return result;
    }

    // Method to compare two char arrays
    public static boolean compareArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}