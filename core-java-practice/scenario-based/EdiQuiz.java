public class EdiQuiz {

    public static void main(String[] args) {

        // Correct answers
        String[] correctAnswers = {
            "A", "B", "C", "D", "A",
            "C", "B", "D", "A", "C"
        };

        // Student answers
        String[] studentAnswers = {
            "a", "B", "c", "A", "A",
            "c", "b", "D", "b", "C"
        };

        int score = calculateScore(correctAnswers, studentAnswers);

        double percentage = (score / 10.0) * 100;

        System.out.println("\nFinal Score: " + score + "/10");
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 40) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }

    // Method to calculate score and print feedback
    public static int calculateScore(String[] correct, String[] student) {
        int score = 0;

        for (int i = 0; i < correct.length; i++) {
            if (correct[i].equalsIgnoreCase(student[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
                score++;
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }
        return score;
    }
}
