import java.util.Scanner;

// calculate the average height of 11 football players
public class TeamHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // array for 11 players and variable for the total
        double[] heights = new double[11];
        double sum = 0;

        // get height inputs from the user
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height for player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
        }

        // add up all the heights in the array
        for (int i = 0; i < heights.length; i++) {
            sum = sum + heights[i];
        }

        // divide total by 11 to get the mean
        double mean = sum / 11;
        
        // display the final average height
        System.out.printf("The mean height of the team is: %.2f", mean);

        scanner.close();
    }
}