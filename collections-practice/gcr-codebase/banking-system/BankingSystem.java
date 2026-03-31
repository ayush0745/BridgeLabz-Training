import java.util.*;

class BankingSystem {
	private Map<String, Double> accounts = new HashMap<String, Double>();
	private Queue<Request> withdrawalQueue = new LinkedList<Request>();

	public void addAccount(String accountNumber, double balance) {
		accounts.put(accountNumber, balance);
	}

	public void withdrawalRequest(String accountNumber, double balance) {
		withdrawalQueue.offer(new Request(accountNumber, balance));
	}

	public void processRequests() {
		while (!withdrawalQueue.isEmpty()) {
			Request request = withdrawalQueue.poll();
			double balance = accounts.getOrDefault(request.getAccountNumber(), 0.0);
			if (balance >= request.getBalance()) {
				accounts.put(request.getAccountNumber(), balance - request.getBalance());
				System.out.println(
						"Withdrawal Request Successful: " + request.getAccountNumber() + " " + request.getBalance());
			} else {
				System.out.println("Insufficient balance");
			}
		}
		System.out.println();
	}

	public void displayCustomersSortedByBalance() {
		TreeMap<Double, List<String>> treeMap = new TreeMap<>(Collections.reverseOrder());
		for (Map.Entry<String, Double> entry : accounts.entrySet()) {
			double balance = entry.getValue();
			String accountNumber = entry.getKey();

			if (!treeMap.containsKey(balance)) {
				treeMap.put(balance, new ArrayList<>());
			}

			treeMap.get(balance).add(accountNumber);
		}
		for (Map.Entry<Double, List<String>> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		System.out.println();
	}

	public void displayAccounts() {
		for (Map.Entry<String, Double> entry : accounts.entrySet()) {
			System.out.println("Account: " + entry.getKey() + " Balance: " + entry.getValue());
		}
		System.out.println();
	}
}