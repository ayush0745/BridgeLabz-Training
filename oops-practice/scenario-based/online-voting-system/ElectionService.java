public abstract class ElectionService {

    // Register a new voter
    abstract void registerVoter(Voter voter);

    // Add a candidate
    abstract void addCandidate(Candidate candidate);

    // Cast vote
    abstract void castVote(Vote vote) throws DuplicateVoteException;

    // Declare final result
    abstract void declareResult();
}
