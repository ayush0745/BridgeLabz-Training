import java.util.*;

public class ShellSort {

    static void shellSort(int[] arr, int[] gaps) {
        int comparisons = 0;
        int shifts = 0;

        for (int gap : gaps) {
            for (int i = gap; i < arr.length; i++) {

                int temp = arr[i];
                int j = i;

                while (j >= gap) {
                    comparisons++;

                    if (arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                        shifts++;
                        j = j - gap;
                    } else {
                        break;
                    }
                }

                arr[j] = temp;
            }
        }

        System.out.println("Sorted: " + Arrays.toString(arr));
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Shifts: " + shifts);
    }

    static int[] shellGaps(int n) {
        int[] gaps = new int[20];
        int count = 0;

        int gap = n / 2;

        while (gap > 0) {
            gaps[count++] = gap;
            gap = gap / 2;
        }

        return Arrays.copyOf(gaps, count);
    }

    static int[] knuthGaps(int n) {
        ArrayList<Integer> gaps = new ArrayList<>();

        int h = 1;

        while (h < n) {
            gaps.add(h);
            h = 3 * h + 1;
        }

        int[] result = new int[gaps.size()];

        for (int i = 0; i < gaps.size(); i++) {
            result[i] = gaps.get(gaps.size() - 1 - i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {9, 8, 3, 7, 5, 6, 4, 1};

        int[] shellArray = arr.clone();
        int[] knuthArray = arr.clone();

        System.out.println("Shell's Gap Sequence:");
        System.out.println(Arrays.toString(shellGaps(arr.length)));
        shellSort(shellArray, shellGaps(arr.length));

        System.out.println();

        System.out.println("Knuth's Gap Sequence:");
        System.out.println(Arrays.toString(knuthGaps(arr.length)));
        shellSort(knuthArray, knuthGaps(arr.length));
    }
}