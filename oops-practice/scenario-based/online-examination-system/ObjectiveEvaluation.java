public class ObjectiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(String studentAnswer, String correctAnswer) {
        return studentAnswer.equals(correctAnswer) ? 1 : 0;
    }
}
