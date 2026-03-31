import java.util.*;

public class SetToSortedList {

	public static <T extends Comparable<? super T>> List<T> toSortedList(Set<T> set) {
		List<T> list = new ArrayList<T>(set);
		Collections.sort(list);
		return list;
	}

	public static void main(String[] args) {
		
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(5, 3, 9, 1));
		System.out.println(toSortedList(set));
	}

}
