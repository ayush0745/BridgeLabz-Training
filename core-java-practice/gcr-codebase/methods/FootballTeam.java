import java.util.Scanner;

public class FootballTeamStats {

    public static void main(String[] args) {
        // Create an array of size 11 for the team
        int[] heights = new int[11];

       
        System.out.println("Generating random heights for 11 players:");
        for (int i = 0; i < heights.length; i++) {
            
            heights[i] = (int) (Math.random() * (250 - 150 + 1)) + 150;
            System.out.print(heights[i] + " ");
        }
        System.out.println("\n");

        // Display Results
        System.out.println("Team Statistics ");
        System.out.println("Shortest Player: " + findShortest(heights) + " cm");
        System.out.println("Tallest Player : " + findTallest(heights) + " cm");
        System.out.printf("Mean Height    : %.2f cm%n", findMean(heights));
    }

    //Method to find the sum of all elements in the array.
    
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int h : heights) {
            sum += h;
        }
        return sum;
    }

    
    // Method to find the mean height.
    
    public static double findMean(int[] heights) {
        int totalSum = findSum(heights);
        return (double) totalSum / heights.length;
    }

    // Method to find the shortest height.
     
    public static int findShortest(int[] heights) {
        int min = heights[0];
        for (int h : heights) {
            min = Math.min(min, h);
        }
        return min;
    }

    
    //  Method to find the tallest height.
     
    public static int findTallest(int[] heights) {
        int max = heights[0];
        for (int h : heights) {
            max = Math.max(max, h);
        }
        return max;
    }
}