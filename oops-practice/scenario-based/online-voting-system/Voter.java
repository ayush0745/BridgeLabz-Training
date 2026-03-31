public class Voter {
    int voterId;
    String name;
    boolean hasVoted = false; // Tracks voting status

    // Voter registration
    public Voter(int voterId, String name) {
        this.voterId = voterId;
        this.name = name;
    }
}
