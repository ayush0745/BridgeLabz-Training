import java.time.LocalDate;
import java.util.*;

class Management {
	Set<Policy> set = new HashSet<Policy>();
	Set<Policy> linkedSet = new LinkedHashSet<Policy>();
	Set<Policy> treeSet = new TreeSet<Policy>();

	public void addPolicy(Policy policy) {
		set.add(policy);
		linkedSet.add(policy);
		treeSet.add(policy);
	}

	public void displayAllPolicies() {
		System.out.println("All policies:");
		for (Policy p : set) {
			System.out.println(p);
		}
	}

	public void expiringSoon() {
		System.out.println("Policies expiring within 30 days:");
		LocalDate today = LocalDate.now();
		for (Policy p : set) {
			LocalDate expiry = LocalDate.parse(p.getExpiryDate());
			if (!expiry.isBefore(today) && expiry.isBefore(today.plusDays(30))) {
				System.out.println(p);
			}
		}
	}

	public void displayByCoverageType(String type) {
		System.out.println("Policies with coverage type: " + type);
		for (Policy p : set) {
			if (p.getType().equalsIgnoreCase(type)) {
				System.out.println(p);
			}
		}
	}

	public void displayDuplicates(List<Policy> policies) {
		System.out.println("Duplicate policies:");
		for (Policy p : policies) {
			if (set.contains(p)) {
				System.out.println(p);
			}
		}
	}

	public void compare() {
		Policy test = new Policy(100, "Test", "2025-10-11", "Health", 1000);

		System.out.println("Comparision");

		long start = System.nanoTime();
		set.add(test);
		set.contains(test);
		set.remove(test);
		long end = System.nanoTime();
		System.out.println("Set: " + (end - start));

		start = System.nanoTime();
		linkedSet.add(test);
		linkedSet.contains(test);
		linkedSet.remove(test);
		end = System.nanoTime();
		System.out.println("LinkedSet: " + (end - start));

		start = System.nanoTime();
		treeSet.add(test);
		treeSet.contains(test);
		treeSet.remove(test);
		end = System.nanoTime();
		System.out.println("TreeSet: " + (end - start));
	}
}