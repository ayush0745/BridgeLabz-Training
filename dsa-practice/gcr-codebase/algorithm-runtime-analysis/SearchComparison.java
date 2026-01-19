import java.util.*;

public class SearchComparison {

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] datasetSizes = {1000, 10000, 1000000};
        int target = -1; // worst case (element not present)

        for (int size : datasetSizes) {
            int[] arr = new int[size];

            // Fill array
            for (int i = 0; i < size; i++) {
                arr[i] = i;
            }

            // Linear Search Timing
            long startLinear = System.nanoTime();
            linearSearch(arr, target);
            long endLinear = System.nanoTime();

            // Binary Search Timing
            Arrays.sort(arr); // required for binary search
            long startBinary = System.nanoTime();
            binarySearch(arr, target);
            long endBinary = System.nanoTime();

            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " +
                    (endLinear - startLinear) / 1_000_000.0 + " ms");
            System.out.println("Binary Search Time: " +
                    (endBinary - startBinary) / 1_000_000.0 + " ms");
            System.out.println("----------------------------------");
        }
    }
}
