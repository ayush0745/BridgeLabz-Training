public class OnlineVotingSystem{
    public static void main(String[] args) {

        ElectionService service = new Election();

        Voter v1 = new Voter(1, "Ayush");
        Candidate c1 = new Candidate(101, "Candidate A");
        Candidate c2 = new Candidate(102, "Candidate B");

        service.registerVoter(v1);
        service.addCandidate(c1);
        service.addCandidate(c2);

        try {
            service.castVote(new Vote(v1, c1));
            // service.castVote(new Vote(v1, c2)); // Exception case
        } catch (DuplicateVoteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nElection Result:");
        service.declareResult();
    }
}
