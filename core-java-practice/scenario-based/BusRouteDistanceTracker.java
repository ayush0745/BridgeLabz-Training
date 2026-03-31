import java.util.Scanner;

public class BusRouteDistanceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double totalDistance = 0.0;
        boolean stillOnBus = true;
        int stopCount = 0;

        System.out.println("Bus Route Started");

        while (stillOnBus) {
            stopCount++;
            
            double distanceToNextStop = 5; 
            totalDistance += distanceToNextStop;

            System.out.println("\nArrived at Stop #" + stopCount);
            System.out.println("Total distance covered: " + totalDistance + " km");

            // Ask the user for confirmation
            System.out.print("Do you want to get off here? (yes/no): ");
            String choice = sc.next().toLowerCase();

            if (choice.equals("yes")) {
                stillOnBus = false; 
            }
        }

        System.out.println("\n You have reached your destination.");
        System.out.println("Final Travel Distance: " + totalDistance + " km");
        System.out.println("Thank you for riding with us!");
        
        sc.close();
    }
}