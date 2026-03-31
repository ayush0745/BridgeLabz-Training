import java.util.ArrayList;
import java.util.List;

// Custom Exception
class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

// Quiz Result Processor
class QuizResultProcessor {

    // Compare answers and calculate score
    public int calculateScore(String[] correctAnswers, String[] userAnswers)
            throws InvalidQuizSubmissionException {

        if (correctAnswers.length != userAnswers.length) {
            throw new InvalidQuizSubmissionException(
                "Answer count mismatch. Submission rejected."
            );
        }

        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }

    // Return grade based on score
    public String getGrade(int score, int totalQuestions) {
        double percentage = (score * 100.0) / totalQuestions;

        if (percentage >= 90) return "A";
        else if (percentage >= 75) return "B";
        else if (percentage >= 60) return "C";
        else return "Fail";
    }
}

// Main Class
public class OnlineQuizPlatform {
    public static void main(String[] args) {

        QuizResultProcessor processor = new QuizResultProcessor();
        List<Integer> scores = new ArrayList<>();

        // Correct answers
        String[] correctAnswers = {
            "A", "C", "B", "D", "A"
        };

        // User submissions 
        String[][] userSubmissions = {
            {"A", "C", "B", "D", "A"},   
            {"A", "B", "B", "D", "C"},  
            {"A", "C", "B"}             
        };

        for (int i = 0; i < userSubmissions.length; i++) {
            try {
                int score = processor.calculateScore(
                    correctAnswers,
                    userSubmissions[i]
                );

                scores.add(score);
                String grade = processor.getGrade(score, correctAnswers.length);

                System.out.println(
                    "User " + (i + 1) +
                    " | Score: " + score +
                    " | Grade: " + grade
                );

            } catch (InvalidQuizSubmissionException e) {
                System.out.println(
                    "User " + (i + 1) +
                    " Error: " + e.getMessage()
                );
            }
        }

        System.out.println("\nAll Scores Stored: " + scores);
    }
}
