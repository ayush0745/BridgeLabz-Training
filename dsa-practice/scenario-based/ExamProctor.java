import java.util.HashMap;
import java.util.Stack;

class Exam {

    // Stack to track question navigation (LIFO)
    private Stack<Integer> navigationStack;

    // HashMap to store answers: questionID -> answer
    private HashMap<Integer, String> answers;

    // HashMap to store correct answers
    private HashMap<Integer, String> correctAnswers;

    // Constructor
    public Exam() {
        navigationStack = new Stack<>();
        answers = new HashMap<>();
        correctAnswers = new HashMap<>();

        // Initialize correct answers
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "C");
        correctAnswers.put(3, "B");
        correctAnswers.put(4, "D");
        correctAnswers.put(5, "A");
    }

    // Track question navigation
    public void visitQuestion(int questionId) {
        navigationStack.push(questionId);
        System.out.println("Visited Question: " + questionId);
    }

    // Store student's answer
    public void submitAnswer(int questionId, String answer) {
        answers.put(questionId, answer);
        System.out.println("Answer recorded for Question " + questionId);
    }

    // Get last visited question
    public int getLastVisitedQuestion() {
        if (navigationStack.isEmpty()) {
            System.out.println("No questions visited yet.");
            return -1;
        }
        return navigationStack.peek();
    }

    // Function to calculate score
    public int evaluateScore() {
        int score = 0;

        for (int questionId : correctAnswers.keySet()) {
            if (answers.containsKey(questionId)) {
                if (answers.get(questionId).equals(correctAnswers.get(questionId))) {
                    score++;
                }
            }
        }
        return score;
    }

    // Submit exam and auto-evaluate
    public void submitExam() {
        System.out.println("\nExam Submitted Successfully!");
        int finalScore = evaluateScore();
        System.out.println("Final Score: " + finalScore + "/" + correctAnswers.size());
    }
}

public class ExamProctor {
    public static void main(String[] args) {

        Exam exam = new Exam();

        // Student navigates and answers questions
        exam.visitQuestion(1);
        exam.submitAnswer(1, "A");

        exam.visitQuestion(2);
        exam.submitAnswer(2, "B");

        exam.visitQuestion(3);
        exam.submitAnswer(3, "B");

        exam.visitQuestion(4);
        exam.submitAnswer(4, "D");

        exam.visitQuestion(5);
        exam.submitAnswer(5, "A");

        // Check last visited question
        System.out.println("\nLast Visited Question: "
                + exam.getLastVisitedQuestion());

        // Submit exam
        exam.submitExam();
    }
}
