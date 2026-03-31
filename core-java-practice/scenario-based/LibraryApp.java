import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Rohan's Library Reminder Appz");

        // Loop to repeat the process for 5 books
        for (int i = 1; i <= 5; i++) {
            System.out.println("\nBook " + i + ":");
            
            System.out.print("Enter Due Date (Day of month): ");
            int dueDate = input.nextInt();
            
            System.out.print("Enter Return Date (Day of month): ");
            int returnDate = input.nextInt();
            
            // Logic to calculate fine
            if (returnDate > dueDate) {
                int daysLate = returnDate - dueDate;
                int fine = daysLate * 5;
                System.out.println("Status: LATE | Days: " + daysLate + " | Fine: " + fine);
            } else {
                System.out.println("Status: ON TIME | Fine: ₹0");
            }
        }
        
        System.out.println("\nAll book submitted successfully.");
        input.close();
    }
}