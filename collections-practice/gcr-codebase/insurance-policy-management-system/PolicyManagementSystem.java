import java.util.*;

public class PolicyManagementSystem {

	public static void main(String[] args) {
		
		Management manager = new Management();

		Policy p1 = new Policy(101, "Ayush", "2026-02-10", "Health", 5000);
		Policy p2 = new Policy(102, "Jay", "2025-11-15", "Auto", 3000);
		Policy p3 = new Policy(103, "Arpit", "2025-10-01", "Home", 7000);
		Policy p4 = new Policy(101, "Ayush", "2026-03-01", "Health", 6000);

		manager.addPolicy(p1);
		manager.addPolicy(p2);
		manager.addPolicy(p3);
		manager.addPolicy(p4);

		manager.displayAllPolicies();
		manager.expiringSoon();
		manager.displayByCoverageType("Health");

		List<Policy> inputList = Arrays.asList(p1, p3, p4);
		manager.displayDuplicates(inputList);

		manager.compare();
	}

}