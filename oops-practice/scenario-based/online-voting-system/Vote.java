public class Vote {
    Voter voter;
    Candidate candidate;

    // Links voter with candidate
    public Vote(Voter voter, Candidate candidate) {
        this.voter = voter;
        this.candidate = candidate;
    }
}
