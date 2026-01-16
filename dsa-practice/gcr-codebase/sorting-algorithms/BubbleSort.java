import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for comparisons
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap adjacent elements
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] studentMarks = {78, 45, 89, 32, 67};

        System.out.println("Before Sorting: " + Arrays.toString(studentMarks));
        bubbleSort(studentMarks);
        System.out.println("After Sorting: " + Arrays.toString(studentMarks));
    }
}
