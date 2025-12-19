import java.util.Scanner;
//level 2 control flow problems

public class FizzBuzzFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");

       
            int n = scanner.nextInt();

            // Check if the integer is positive
            if (n > 0) {
                for (int i = 1; i <= n; i++) {
                    if (i % 3 == 0 && i % 5 == 0) {
                        System.out.println("FizzBuzz");
                    } else if (i % 3 == 0) {
                        System.out.println("Fizz");
                    } else if (i % 5 == 0) {
                        System.out.println("Buzz");
                    } else {
                        System.out.println(i);
                    }
                 }
                
             }
            
             else {
                System.out.println("Please enter a number greater than 0.");
             }
         
        scanner.close();
    }
}