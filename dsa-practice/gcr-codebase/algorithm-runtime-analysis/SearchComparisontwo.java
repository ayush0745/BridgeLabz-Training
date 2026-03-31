import java.util.*;

public class SearchComparisontwo {

    public static void main(String[] args) {

        int size = 1_000_000;
        int target = -1; // worst-case search

        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        long start, end;

        // Array Search
        start = System.nanoTime();
        boolean found = false;
        for (int num : array) {
            if (num == target) {
                found = true;
                break;
            }
        }
        end = System.nanoTime();
        System.out.println("Array Search Time: " +
                (end - start) / 1_000_000.0 + " ms");

        // HashSet Search
        start = System.nanoTime();
        hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " +
                (end - start) / 1_000_000.0 + " ms");

        // TreeSet Search
        start = System.nanoTime();
        treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " +
                (end - start) / 1_000_000.0 + " ms");
    }
}
