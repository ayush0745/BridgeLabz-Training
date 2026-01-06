import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentScoresManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of students: ");
            int n = sc.nextInt();

            int[] scores = new int[n];

            System.out.println("Enter student scores:");
            for (int i = 0; i < n; i++) {
                int score = sc.nextInt();

                if (score < 0) {
                    throw new IllegalArgumentException("Scores cannot be negative.");
                }
                scores[i] = score;
            }

            double average = calculateAverage(scores);
            int max = findMax(scores);
            int min = findMin(scores);

            System.out.println("\nAverage Score: " + average);
            System.out.println("Highest Score: " + max);
            System.out.println("Lowest Score: " + min);

            System.out.println("\nScores above average:");
            displayAboveAverage(scores, average);

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter numeric values only.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // Method to calculate average
    public static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    // Method to find highest score
    public static int findMax(int[] scores) {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    // Method to find lowest score
    public static int findMin(int[] scores) {
        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }

    // Method to display scores above average
    public static void displayAboveAverage(int[] scores, double average) {
        for (int score : scores) {
            if (score > average) {
                System.out.println(score);
            }
        }
    }
}
