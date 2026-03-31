public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};

        int peakIndex = findPeak(arr);
        System.out.println("Peak Element Index: " + peakIndex);
        System.out.println("Peak Element Value: " + arr[peakIndex]);
    }

    public static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean leftOk = (mid == 0) || arr[mid] > arr[mid - 1];
            boolean rightOk = (mid == arr.length - 1) || arr[mid] > arr[mid + 1];

            if (leftOk && rightOk) {
                return mid; // Peak found
            }

            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1; // Search left
            } else {
                left = mid + 1; // Search right
            }
        }
        return -1;
    }
}
