import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int left = 0;
        int right = s.length() - 1;

        boolean palindrome = true;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                palindrome = false;
                break;
            }

            left++;
            right--;
        }

        if (palindrome) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
