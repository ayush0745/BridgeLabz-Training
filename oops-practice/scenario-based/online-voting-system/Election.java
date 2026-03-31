import java.util.*;

public class Election extends ElectionService {

    List<Voter> voters = new ArrayList<>();
    List<Candidate> candidates = new ArrayList<>();

    @Override
    void registerVoter(Voter voter) {
        voters.add(voter);
        System.out.println("Voter registered: " + voter.name);
    }

    @Override
    void addCandidate(Candidate candidate) {
        candidates.add(candidate);
        System.out.println("Candidate added: " + candidate.name);
    }

    @Override
    void castVote(Vote vote) throws DuplicateVoteException {

        // Prevent duplicate voting
        if (vote.voter.hasVoted) {
            throw new DuplicateVoteException("Duplicate vote not allowed!");
        }

        vote.candidate.voteCount++; // Increase vote count
        vote.voter.hasVoted = true; // Mark voter as voted
        System.out.println("Vote cast successfully");
    }

    @Override
    void declareResult() {

        // Display results
        for (Candidate c : candidates) {
            System.out.println(c.name + " : " + c.voteCount + " votes");
        }
    }
}
