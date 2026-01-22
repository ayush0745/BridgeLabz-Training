public class Main {
	public static void main(String[] args) {
		BankingSystem bank = new BankingSystem();

		bank.addAccount("101", 5000);
		bank.addAccount("102", 3000);
		bank.addAccount("103", 7000);

		bank.withdrawalRequest("101", 1000);
		bank.withdrawalRequest("102", 4000);
		bank.withdrawalRequest("103", 2000);

		bank.processRequests();

		bank.displayAccounts();

		bank.displayCustomersSortedByBalance();
	}

}