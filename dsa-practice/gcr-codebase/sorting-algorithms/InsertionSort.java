import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] empIds) {
        int n = empIds.length;

        for (int i = 1; i < n; i++) {
            int key = empIds[i];
            int j = i - 1;

            // Shift elements greater than key to one position ahead
            while (j >= 0 && empIds[j] > key) {
                empIds[j + 1] = empIds[j];
                j--;
            }

            // Insert key at correct position
            empIds[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIDs = {105, 102, 110, 101, 108};

        System.out.println("Before Sorting: " + Arrays.toString(employeeIDs));
        insertionSort(employeeIDs);
        System.out.println("After Sorting: " + Arrays.toString(employeeIDs));
    }
}
