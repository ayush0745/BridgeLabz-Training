import java.util.Scanner;

public class LuckyDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter total number of visitors: ");
        int totalVisitors = sc.nextInt();

        for (int i = 1; i <= totalVisitors; i++) {
            System.out.println("\nVisitor #" + i + " - ");
            System.out.print("Enter your lucky number: ");
            int ticketNumber = sc.nextInt();

            //If number is invalid, skip this visitor
            if (ticketNumber <= 0) {
                System.out.println("Invalid number");
                continue; 
            }

            //Divisible by both 3 and 5
            if (ticketNumber % 3 == 0 && ticketNumber % 5 == 0) {
                System.out.println(" Congratulations! You won a gift!");
            } else {
                System.out.println("Better luck next time!");
            }
        }
        
        System.out.println("\nLucky Draw Ended. Happy Diwali!");
        sc.close();
    }
}