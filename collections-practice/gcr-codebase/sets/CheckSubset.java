import java.util.*;

public class CheckSubset {

	public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {
		return set1.containsAll(set2) || set2.containsAll(set1);
	}

	public static void main(String[] args) {
		
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(2, 3));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4));
		System.out.println("Is subset: " + isSubset(set1, set2));
	}

}
public class CheckSubset {

}
