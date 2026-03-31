import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine().toLowerCase().replace(" ", "");

        System.out.println("Method 1 (Loop): " + isPalindromeLoop(text));
        System.out.println("Method 2 (Recursion): " + isPalindromeRec(text, 0, text.length() - 1));
        System.out.println("Method 3 (Reverse): " + isPalindromeReverse(text));
        
        sc.close();
    }

    
    public static boolean isPalindromeLoop(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    //  Use recursion 
    public static boolean isPalindromeRec(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return isPalindromeRec(s, start + 1, end - 1);
    }

    // Reverse the text and compare
    public static boolean isPalindromeReverse(String s) {
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse += s.charAt(i);
        }
        return s.equals(reverse);
    }
}