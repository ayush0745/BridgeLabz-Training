import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);

            // Sort left part
            quickSort(prices, low, pivotIndex - 1);

            // Sort right part
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // pivot element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // Swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Place pivot in correct position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] productPrices = {999, 299, 1200, 450, 750};

        System.out.println("Before Sorting: " + Arrays.toString(productPrices));
        quickSort(productPrices, 0, productPrices.length - 1);
        System.out.println("After Sorting: " + Arrays.toString(productPrices));
    }
}
