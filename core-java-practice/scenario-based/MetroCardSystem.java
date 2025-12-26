import java.util.Scanner;

public class MetroSmartCardSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
     
        double cardBalance = 100.0;
        double shortDistanceLimit = 5.0;
        int quitCode = -1;
        double distanceInput = 0;

        System.out.println("Welcome to Delhi Metro Smart System");
        System.out.println("Current Balance: " + cardBalance);

        // Loop until balance is exhausted or user quits
        while (cardBalance > 0) {
            System.out.print("\nEnter travel distance in km (or " + quitCode + " to quit): ");
            distanceInput = scanner.nextDouble();

            if (distanceInput == quitCode) break;

            // Calculate fare using Ternary Operator
            // Logic: ₹20 for up to 5km, ₹40 for anything further
            double currentFare = (distanceInput <= shortDistanceLimit) ? 20.0 : 40.0;

            if (cardBalance >= currentFare) {
                cardBalance -= currentFare;
                System.out.println("Fare Deducted: ₹" + currentFare);
                System.out.printf("Remaining Balance: ₹%.2f\n", cardBalance);
            } else {
                System.out.println("Insufficient Balance! Current: ₹" + cardBalance + ", Required: ₹" + currentFare);
                System.out.println("Please recharge your card.");
                break;
            }
        }
        System.out.println("Thank you for using Delhi Metro.");
        scanner.close();
    }
}