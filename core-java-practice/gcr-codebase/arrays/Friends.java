import java.util.Scanner;

// compare age and height for 3 friends
public class Friends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // collect input for each friend
        for (int i = 0; i < 3; i++) {
            System.out.println("Details for " + names[i] + ":");
            System.out.print("Age: ");
            ages[i] = scanner.nextInt();
            System.out.print("Height: ");
            heights[i] = scanner.nextDouble();
        }

        // initialize
        int minAge = ages[0];
        String youngest = names[0];
        
        double maxHeight = heights[0];
        String tallest = names[0];

        // loop to compare and find min/max
        for (int i = 1; i < 3; i++) {
            // check for youngest
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngest = names[i];
            }
            // check for tallest
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallest = names[i];
            }
        }

        // display final winners
        System.out.println(" Results ");
        System.out.println("Youngest Friend: " + youngest + " (" + minAge + " years)");
        System.out.println("Tallest Friend : " + tallest + " (" + maxHeight + " units)");

        scanner.close();
    }
}