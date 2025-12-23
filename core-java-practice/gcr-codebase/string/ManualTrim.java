import java.util.Scanner;

public class ManualTrim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text with spaces at start/end:");
        String input = sc.nextLine();

        // 1. Get boundaries
        int[] boundaries = getTrimBoundaries(input);
        
        // 2. Create custom substring based on boundaries
        String customTrimmed = customSubstring(input, boundaries[0], boundaries[1]);
        
        // 3. Built-in trim
        String builtInTrimmed = input.trim();

        // 4. Compare and Display
        boolean match = compareStrings(customTrimmed, builtInTrimmed);
        System.out.println("Custom Trimmed: [" + customTrimmed + "]");
        System.out.println("Built-in Trimmed: [" + builtInTrimmed + "]");
        System.out.println("Do results match? " + match);
    }

    // Finds the start and end indices of the actual text
    public static int[] getTrimBoundaries(String str) {
        int start = 0;
        int end = str.length() - 1;

        // Loop to find first non-space character
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }
        // Loop to find last non-space character
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end + 1}; // +1 because substring end is exclusive
    }

    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}