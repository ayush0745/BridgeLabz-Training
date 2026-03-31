public class RotationPoint {
    public static void main(String[] args) {
        int[] rotatedArray = {4, 5, 1, 2, 3};

        int left = 0;
        int right = rotatedArray.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (rotatedArray[mid] > rotatedArray[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println("Rotation Point Index: " + left);
        System.out.println("Smallest Element: " + rotatedArray[left]);
    }
}
