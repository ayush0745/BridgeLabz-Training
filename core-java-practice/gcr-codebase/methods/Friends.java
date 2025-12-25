import java.util.Scanner;

public class FriendsComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Take user input for Age and Height
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for " + names[i] + ":");
            System.out.print("Age: ");
            ages[i] = sc.nextInt();
            System.out.print("Height (in cm): ");
            heights[i] = sc.nextDouble();
            System.out.println();
        }

        // Find and display results
        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);

        System.out.println("--- Comparison Results ---");
        System.out.println("The youngest friend is " + names[youngestIndex] + 
                           " with an age of " + ages[youngestIndex]);
        System.out.println("The tallest friend is " + names[tallestIndex] + 
                           " with a height of " + heights[tallestIndex] + " cm");

        sc.close();
    }

    //Method to find the index of the youngest friend
    
    public static int findYoungest(int[] ages) {
        int minIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    // Method to find the index of the tallest friend
   
    public static int findTallest(double[] heights) {
        int maxIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}