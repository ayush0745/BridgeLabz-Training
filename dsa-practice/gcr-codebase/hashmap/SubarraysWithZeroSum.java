import java.util.*;

public class SubarraysWithZeroSum {

    public static void findZeroSumSubarrays(int[] arr) {

        // Map: prefixSum -> list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        int prefixSum = 0;

        // To handle subarrays starting from index 0
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            // If prefixSum seen before, zero-sum subarrays exist
            if (map.containsKey(prefixSum)) {
                for (int startIndex : map.get(prefixSum)) {
                    System.out.println(
                        "Zero-sum subarray found from index "
                        + (startIndex + 1) + " to " + i
                    );
                }
            }

            // Store current index
            map.computeIfAbsent(prefixSum, k -> new ArrayList<>()).add(i);
        }
    }

    public static void main(String[] args) {

        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};

        findZeroSumSubarrays(arr);
    }
}
