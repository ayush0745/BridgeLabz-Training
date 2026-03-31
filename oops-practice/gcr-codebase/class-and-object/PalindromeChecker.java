import java.util.Scanner;

class PalindromeChecker {
    String text;

    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check if the text is a palindrome
    public boolean isPalindrome() {
       
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();
        
        String reversed = "";
        for (int i = cleanText.length() - 1; i >= 0; i--) {
            reversed += cleanText.charAt(i);
        }
        
        return cleanText.equals(reversed);
    }

    // Method to display the result
    public void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }

    public static void main(String[] args) {
        
        PalindromeChecker pc1 = new PalindromeChecker("A man a plan a canal Panama");
        pc1.displayResult();

        
        PalindromeChecker pc2 = new PalindromeChecker("Hello");
        pc2.displayResult();
    }
}