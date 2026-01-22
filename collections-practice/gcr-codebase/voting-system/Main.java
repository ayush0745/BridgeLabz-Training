public class Main {

	public static void main(String[] args) {
		
		VotingSystem votingSystem = new VotingSystem();
		votingSystem.castVote("Ayush");
		votingSystem.castVote("Arpit");
		votingSystem.castVote("jay");
		

		votingSystem.displayCandidates();
		votingSystem.displayVotingOrder();
		votingSystem.displayResult();
	}

}