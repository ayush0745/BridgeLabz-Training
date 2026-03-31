import java.util.Scanner;
//level 2 control flow problem
public class MultiplesUsingWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");

        int number = scanner.nextInt();

        // Check if number is positive and less than 100
        if (number > 0 && number < 100) {
            int counter = number - 1;
            System.out.print("The values are: ");

            while (counter > 1) {
                
                if (number % counter == 0) {
                    System.out.print(counter + " ");
                }
                counter--; 
            }
            System.out.println();
         } 
         else {
            System.out.println("Please enter a number between 1 and 99.");
         }
         scanner.close();
    }
}

