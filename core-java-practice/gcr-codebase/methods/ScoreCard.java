import java.util.Scanner;

public class ScoreCard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();

        //Generate PCM Scores
        int[][] pcmScores = generatePCMScores(numStudents);

        // Calculate Stats 
        double[][] stats = calculateStats(pcmScores);

        // Display Scorecard
        displayScorecard(pcmScores, stats);

        sc.close();
    }

 
    public static int[][] generatePCMScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                // Generates random int between 10 and 99
                scores[i][j] = (int) (Math.random() * 90) + 10;
            }
        }
        return scores;
    }

   // Computes Total, Average, and Percentage.
    
    public static double[][] calculateStats(int[][] pcmScores) {
        double[][] stats = new double[pcmScores.length][3];

        for (int i = 0; i < pcmScores.length; i++) {
            int total = pcmScores[i][0] + pcmScores[i][1] + pcmScores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Rounding to 2 decimal places using Math.round()
            stats[i][0] = total;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }

    // Displays results in a tabular format using tabs (\t).
    
    public static void displayScorecard(int[][] scores, double[][] stats) {
        System.out.println("\n--- STUDENT SCORECARD ---");
        System.out.println("ID\tPhy\tChem\tMath\tTotal\tAvg\tPerc(%)");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.print((i + 1) + "\t");
            System.out.print(scores[i][0] + "\t" + scores[i][1] + "\t" + scores[i][2] + "\t");
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2] + "%");
        }
    }
}