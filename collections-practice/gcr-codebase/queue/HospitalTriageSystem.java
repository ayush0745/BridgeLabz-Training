package collections.gcr_codebase.queue;

import java.util.*;

class Patient {
	String name;
	int severity;

	Patient(String name, int severity) {
		this.name = name;
		this.severity = severity;
	}
}

public class HospitalTriageSystem {

	public static void treatPatients(List<Patient> patients) {
		PriorityQueue<Patient> pq = new PriorityQueue<Patient>((a, b) -> b.severity - a.severity);
		for (Patient patient : patients) {
			pq.offer(patient);
		}
		while (!pq.isEmpty()) {
			Patient patient = pq.poll();
			System.out.println(patient.name);
		}
	}

	public static void main(String[] args) {
		List<Patient> patients = new ArrayList<Patient>(
				Arrays.asList(new Patient("John", 3), new Patient("Alice", 5), new Patient("Bob", 2)));
		treatPatients(patients);
	}
}