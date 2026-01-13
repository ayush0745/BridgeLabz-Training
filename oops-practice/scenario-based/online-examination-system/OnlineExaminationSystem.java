public class OnlineExaminationSystem {
    public static void main(String[] args) {

        Student s1 = new Student(1, "Ayush");

        Exam exam = new Exam("Java Test");
        exam.addQuestion(new Question("What is Java?", "Language"));

        EvaluationStrategy objective = new ObjectiveEvaluation();
        EvaluationStrategy descriptive = new DescriptiveEvaluation();

        try {
            exam.submitAnswer(s1, "Language");

            int score1 = objective.evaluate("Language", "Language");
            int score2 = descriptive.evaluate("Java is OOP language", "Language");

            System.out.println("Objective Score: " + score1);
            System.out.println("Descriptive Score: " + score2);

        } catch (ExamTimeExpiredException e) {
            System.out.println(e.getMessage());
        }
    }
}
