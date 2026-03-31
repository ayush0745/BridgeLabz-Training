public class InsufficientBalanceException extends Exception {

    // Thrown when balance is not enough
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
