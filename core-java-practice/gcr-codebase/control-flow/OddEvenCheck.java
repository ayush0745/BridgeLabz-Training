import java.util.Scanner;
// level 1 control flow problem
public class OddEvenCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number");
        int number = sc.nextInt();

        if (number < 1) {
            System.out.println("Please enter a natural number.");
        } else {
        
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is Even");
                } else {
                    System.out.println(i + " is Odd");
                }
            }
        }
    }
}