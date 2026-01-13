public class DescriptiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(String studentAnswer, String correctAnswer) {
        return studentAnswer.length() >= 5 ? 1 : 0;
    }
}
