public class Candidate {
    int candidateId;
    String name;
    int voteCount = 0; // Stores total votes

    // Candidate details
    public Candidate(int candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
    }
}
