import java.util.*;

class VotingSystem {

	private Map<String, Integer> voteCount;
	private LinkedHashMap<Integer, String> voteOrder;
	private int voteId;

	VotingSystem() {
		this.voteCount = new HashMap<String, Integer>();
		this.voteOrder = new LinkedHashMap<Integer, String>();
		this.voteId = 1;
	}

	public void castVote(String candidate) {
		voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
		voteOrder.put(voteId++, candidate);
	}

	public void displayCandidates() {
		System.out.println("Candidates:");
		for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println();
	}

	public void displayResult() {
		System.out.println("Votes: ");
		TreeMap<String, Integer> votes = new TreeMap<>(
				(a, b) -> voteCount.get(b) != voteCount.get(a) ? voteCount.get(b) - voteCount.get(a) : a.compareTo(b));
		votes.putAll(voteCount);
		for (Map.Entry<String, Integer> entry : votes.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println();
	}

	public void displayVotingOrder() {
		System.out.println("Voting Order:");
		for (Map.Entry<Integer, String> entry : voteOrder.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println();
	}

}