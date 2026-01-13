public class DuplicateVoteException extends Exception {

    // Thrown when a voter tries to vote twice
    public DuplicateVoteException(String message) {
        super(message);
    }
}
