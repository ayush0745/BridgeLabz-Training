import java.util.*;

public class Solution {

    static void quickSort(int[] ar) {
        quickSort(ar, 0, ar.length - 1);
    }

    static void quickSort(int[] ar, int left, int right) {

        if (left >= right) {
            return;
        }

        int pivot = ar[left];

        int[] temp = new int[right - left + 1];

        int index = 0;

        for (int i = left + 1; i <= right; i++) {
            if (ar[i] < pivot) {
                temp[index++] = ar[i];
            }
        }

        int pivotIndex = index;
        temp[index++] = pivot;

        for (int i = left + 1; i <= right; i++) {
            if (ar[i] > pivot) {
                temp[index++] = ar[i];
            }
        }

        for (int i = 0; i < temp.length; i++) {
            ar[left + i] = temp[i];
        }

        quickSort(ar, left, left + pivotIndex - 1);
        quickSort(ar, left + pivotIndex + 1, right);

        printArray(ar, left, right);
    }

    static void printArray(int[] ar, int left, int right) {
        for (int i = left; i <= right; i++) {
            System.out.print(ar[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] ar = new int[n];

        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }

        quickSort(ar);

        in.close();
    }
}