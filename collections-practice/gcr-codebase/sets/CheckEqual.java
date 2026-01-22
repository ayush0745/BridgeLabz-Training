import java.util.*;

public class CheckEqual {

	public static <T> boolean areEqual(Set<T> set1, Set<T> set2) {
		return set1.equals(set2);
	}

	public static void main(String[] args) {
		
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3, 2, 1));
		System.out.println("Are equal? " + areEqual(set1, set2));
	}

}