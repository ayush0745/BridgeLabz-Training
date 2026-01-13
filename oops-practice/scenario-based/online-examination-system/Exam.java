import java.util.*;

public class Exam {
    String examName;
    List<Question> questions = new ArrayList<>();
    Map<Student, String> answers = new HashMap<>();

    public Exam(String examName) {
        this.examName = examName;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void submitAnswer(Student s, String answer)
            throws ExamTimeExpiredException {

        if (answer == null) {
            throw new ExamTimeExpiredException("Exam time expired!");
        }
        answers.put(s, answer);
    }
}
