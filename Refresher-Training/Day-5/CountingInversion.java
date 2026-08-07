import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'countInversions' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * INTEGER_ARRAY arr as parameter.
	 */

	public static long countInversions(List<Integer> arr) {
		int[] a = new int[arr.size()];

		for (int i = 0; i < arr.size(); i++) {
			a[i] = arr.get(i);
		}

		int[] temp = new int[a.length];

		return mergeSort(a, temp, 0, a.length - 1);
	}

	public static long mergeSort(int[] arr, int[] temp, int left, int right) {

		if (left >= right) {
			return 0;
		}

		int mid = left + (right - left) / 2;

		long count = 0;

		count += mergeSort(arr, temp, left, mid);

		count += mergeSort(arr, temp, mid + 1, right);

		count += merge(arr, temp, left, mid, right);

		return count;
	}

	public static long merge(int[] arr, int[] temp, int left, int mid, int right) {

		int i = left;
		int j = mid + 1;
		int k = left;

		long count = 0;

		while (i <= mid && j <= right) {

			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				count += (mid - i + 1);
			}
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= right) {
			temp[k++] = arr[j++];
		}

		for (int x = left; x <= right; x++) {
			arr[x] = temp[x];
		}

		return count;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());

				List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList());

				long result = Result.countInversions(arr);

				bufferedWriter.write(String.valueOf(result));
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
