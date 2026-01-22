import java.util.*;

public class UnionAndIntersection {

	public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
		Set<T> union = new HashSet<T>(set1);
		union.addAll(set2);
		return union;
	}

	public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
		Set<T> intersection = new HashSet<T>(set1);
		intersection.retainAll(set2);
		return intersection;
	}

	public static void main(String[] args) {
		
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3, 4, 5));
		System.out.println("Union: " + union(set1, set2));
		System.out.println("Intersection: " + intersection(set1, set2));
	}

}