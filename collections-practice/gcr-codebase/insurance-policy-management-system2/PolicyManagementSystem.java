import java.time.LocalDate;
import java.util.*;

public class PolicyManagementSystem {

	public static void main(String[] args) {
		
		Management manager = new Management();

		Policy p1 = new Policy(189, "Ayush", LocalDate.now().plusDays(12).toString(), "Health", 5000);

		Policy p2 = new Policy(112, "Arpit", LocalDate.now().plusDays(32).toString(), "Life", 12000);

		Policy p3 = new Policy(123, "Aman", LocalDate.now().minusDays(20).toString(), "Health", 5000);

		Policy p4 = new Policy(134, "jay", LocalDate.now().plusDays(40).toString(), "Life", 12000);

		manager.addPolicy(p1);
		manager.addPolicy(p2);
		manager.addPolicy(p3);
		manager.addPolicy(p4);

		manager.displayAllPolicies();

		manager.expiringSoon();

		manager.getPolicy(189);

		manager.findPolicyHolderPolicies("Ayush");

		manager.removeExpired();

		manager.displayAllPolicies();
	}

}