import java.util.Scanner;
import java.util.Random;

public class GradingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();

        // 1. Generate scores
        int[][] pcmScores = generateRandomScores(numStudents);

        // 2. Calculate metrics
        double[][] stats = calculateStats(pcmScores);

        // 3. Determine grades
        String[][] grades = determineGrades(stats);

        // 4. Display scorecard
        displayScorecard(pcmScores, stats, grades);
        
        sc.close();
    }

    // Method to generate random 2-digit scores (10-99)
    public static int[][] generateRandomScores(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            scores[i][0] = rand.nextInt(90) + 10; // Physics
            scores[i][1] = rand.nextInt(90) + 10; // Chemistry
            scores[i][2] = rand.nextInt(90) + 10; // Math
        }
        return scores;
    }

    // Method to calculate total, average, and percentage
    public static double[][] calculateStats(int[][] scores) {
        double[][] results = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double perc = (total / 300.0) * 100.0;

            results[i][0] = total;
            results[i][1] = Math.round(avg * 100.0) / 100.0; // Round to 2 digits
            results[i][2] = Math.round(perc * 100.0) / 100.0; // Round to 2 digits
        }
        return results;
    }

    // Method to assign grade based on image reference
    public static String[][] determineGrades(double[][] stats) {
        String[][] grades = new String[stats.length][1];
        for (int i = 0; i < stats.length; i++) {
            double p = stats[i][2];
            if (p >= 80) grades[i][0] = "A";      // 80% and above
            else if (p >= 70) grades[i][0] = "B"; // 70-79%
            else if (p >= 60) grades[i][0] = "C"; // 60-69%
            else if (p >= 50) grades[i][0] = "D"; // 50-59%
            else if (p >= 40) grades[i][0] = "E"; // 40-49%
            else grades[i][0] = "R";              // 39% and below
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] stats, String[][] grades) {
        System.out.println("\nID | Phys | Chem | Math | Total | Avg | % | Grade");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "  | " + 
                scores[i][0] + "   | " + scores[i][1] + "   | " + scores[i][2] + "   | " + 
                (int)stats[i][0] + "   | " + stats[i][1] + " | " + stats[i][2] + " | " + grades[i][0]);
        }
    }
}