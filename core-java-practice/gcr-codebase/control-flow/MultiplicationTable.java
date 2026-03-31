
import java.util.Scanner;
// level 1 control flow problem
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter a number ");
        int number = sc.nextInt();

    
       
        for (int i = 6; i <= 9; i++) {
            int product = number * i;
            System.out.println(number + " * " + i + " = " + product);
        }
        sc.close();
    }
}