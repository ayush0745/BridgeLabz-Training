
import java.util.*;

class Employee {
	String name;
	String deptartment;

	Employee(String name, String deptartment) {
		this.name = name;
		this.deptartment = deptartment;
	}

	@Override
	public String toString() {
		return name;
	}
}

public class GroupEmployees {

	static Map<String, List<Employee>> group(List<Employee> list) {
		Map<String, List<Employee>> map = new HashMap<>();
		for (Employee e : list) {
			if (!map.containsKey(e.deptartment)) {
				map.put(e.deptartment, new ArrayList<Employee>());
			}
			map.get(e.deptartment).add(e);
		}
		return map;
	}

	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(new Employee("Alice", "HR"), new Employee("Bob", "IT"),
				new Employee("Carol", "HR"));

		Map<String, List<Employee>> map = group(employees);
		for (Map.Entry<String, List<Employee>> m : map.entrySet()) {
			System.out.println(m.getKey() + ": " + m.getValue());
		}
	}

}