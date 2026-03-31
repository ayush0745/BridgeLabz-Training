// level 1 control flow problem
import java.util.Scanner;

public class FactorialUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("please enter positive numbers.");
        } else {
            long factorial = 1; // Using long for larger results
            int temp = num;
            while (temp > 0) {
                factorial *= temp;
                temp--;
            }
            System.out.println("The factorial of " + num + " is " + factorial);
        }
    }
}