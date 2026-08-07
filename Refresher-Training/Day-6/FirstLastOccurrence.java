public class FirstLastOccurrence {

    static int findFirst(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                high = mid - 1;
            } 
            else if (arr[mid] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return result;
    }

    static int findLast(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                low = mid + 1;
            } 
            else if (arr[mid] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {2, 4, 4, 4, 4, 7, 9, 9, 12};

        int[] targets = {4, 9, 5};

        for (int target : targets) {

            int first = findFirst(arr, target);
            int last = findLast(arr, target);

            System.out.println(
                target + " -> (" + first + ", " + last + ")"
            );
        }
    }
}