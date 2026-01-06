import java.util.Scanner;

// Custom Exception
class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

public class StudentScoreAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of students: ");
            int n = sc.nextInt();

            int[] scores = new int[n];

            System.out.println("Enter student scores:");
            for (int i = 0; i < n; i++) {
                scores[i] = sc.nextInt();
                validateScore(scores[i]);
            }

            System.out.println("Average Score: " + calculateAverage(scores));
            System.out.println("Highest Score: " + findMax(scores));
            System.out.println("Lowest Score: " + findMin(scores));

        } catch (InvalidScoreException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // Validation Method
    public static void validateScore(int score) throws InvalidScoreException {
        if (score < 0 || score > 100) {
            throw new InvalidScoreException(
                "Invalid score detected: " + score + " (Score must be between 0 and 100)"
            );
        }
    }

    // Calculate Average
    public static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    // Find Maximum
    public static int findMax(int[] scores) {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    // Find Minimum
    public static int findMin(int[] scores) {
        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }
}
