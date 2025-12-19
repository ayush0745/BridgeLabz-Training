import java.util.Scanner;
//level 2 control flow problem
public class MultiplesBelowHundred {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer (less than 100): ");

        
        int number = scanner.nextInt();
        // Check if number is positive and less than 100
        if (number > 0 && number < 100) {
            System.out.print("Multiples of " + number + " below 100 are: ");
            
            
            for (int i = 100; i >= 1; i--) {
                
                if (i % number == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } 
        else {
            System.out.println("Invalid range. Please enter a number between 1 and 99.");
        }
        scanner.close();
    }
}
         
      