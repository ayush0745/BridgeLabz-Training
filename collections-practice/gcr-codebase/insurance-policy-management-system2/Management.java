import java.time.LocalDate;
import java.util.*;

class Management {
	Map<Integer, Policy> map = new HashMap<>();
	Map<Integer, Policy> linkedMap = new LinkedHashMap<>();
	Map<LocalDate, List<Policy>> treeMap = new TreeMap<>();

	public void addPolicy(Policy policy) {
		map.put(policy.getPolicyNumber(), policy);
		linkedMap.put(policy.getPolicyNumber(), policy);
		LocalDate expiry = LocalDate.parse(policy.getExpiryDate());
		if (!treeMap.containsKey(expiry)) {
			treeMap.put(expiry, new ArrayList<>());
		}
		treeMap.get(expiry).add(policy);
	}

	public Policy getPolicy(int policyNumber) {
		return map.get(policyNumber);
	}

	public void displayAllPolicies() {
		System.out.println("All policies:");
		for (Map.Entry<Integer, Policy> entry : linkedMap.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	public void expiringSoon() {
		System.out.println("Policies expiring within 30 days:");
		LocalDate today = LocalDate.now();
		for (Map.Entry<LocalDate, List<Policy>> entry : treeMap.entrySet()) {
			LocalDate expiry = entry.getKey();
			if (!expiry.isBefore(today) && !expiry.isAfter(today.plusDays(30))) {
				System.out.println(entry.getValue());
			}
		}
	}

	public void removeExpired() {
		LocalDate today = LocalDate.now();
		Iterator<Map.Entry<LocalDate, List<Policy>>> iterator = treeMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<LocalDate, List<Policy>> entry = iterator.next();
			if (entry.getKey().isAfter(today)) {
				break;
			} else {
				for (Policy p : entry.getValue()) {
					map.remove(p.getPolicyNumber());
					linkedMap.remove(p.getPolicyNumber());
				}
				iterator.remove();
			}
		}
	}

	public void findPolicyHolderPolicies(String holderName) {
		System.out.println("Policies with holder type: " + holderName);
		for (Map.Entry<Integer, Policy> entry : map.entrySet()) {
			if (entry.getValue().getType().equalsIgnoreCase(holderName)) {
				System.out.println(entry.getValue());
			}
		}
	}
}