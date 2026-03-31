import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Step 1: Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Step 2: Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Swap root with last element
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Heapify reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Heapify a subtree rooted at index i
    public static void heapify(int[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check left child
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Check right child
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            // Recursively heapify affected subtree
            heapify(salaries, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] salaryDemands = {70000, 50000, 120000, 90000, 60000};

        System.out.println("Before Sorting: " + Arrays.toString(salaryDemands));
        heapSort(salaryDemands);
        System.out.println("After Sorting: " + Arrays.toString(salaryDemands));
    }
}
