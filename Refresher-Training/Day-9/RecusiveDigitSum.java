import java.util.*;

public class Solution {

    public static int superDigit(String n, int k) {

        long sum = 0;

      
        for (char c : n.toCharArray()) {
            sum += c - '0';
        }

        
        sum = sum * k;

        
        while (sum >= 10) {
            long digitSum = 0;

            while (sum > 0) {
                digitSum += sum % 10;
                sum /= 10;
            }

            sum = digitSum;
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        int k = sc.nextInt();

        System.out.println(superDigit(n, k));
    }
}