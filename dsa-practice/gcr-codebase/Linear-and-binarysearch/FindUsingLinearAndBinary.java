import java.util.*;

public class FindUsingLinearAndBinary {

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int target = 4;

        int missing = firstMissingPositive(arr);
        System.out.println("First Missing Positive: " + missing);

        Arrays.sort(arr); // required for binary search

        int index = binarySearch(arr, target);
        System.out.println("Index of target " + target + ": " + index);
    }

    // Linear Search: First Missing Positive
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n + 1];

        for (int num : arr) {
            if (num > 0 && num <= n) {
                visited[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return n + 1;
    }

    //Binary Search: Find Target Index
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
