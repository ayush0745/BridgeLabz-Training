import java.util.*;

public class SymmetricDifference {

	public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
		Set<T> ans = new HashSet<T>(set1);
		ans.addAll(set2);

		Set<T> intersection = new HashSet<T>(set1);
		intersection.retainAll(set2);

		ans.removeAll(intersection);
		return ans;
	}

	public static void main(String[] args) {
		
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3, 4, 5));
		System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));
	}

}