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
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {

    List<int[]> list = new ArrayList<>();

    for (int i = 0; i < arr.size(); i++) {
        list.add(new int[]{arr.get(i), i + 1});
    }

    list.sort((a, b) -> Integer.compare(a[0], b[0]));

    for (int i = 0; i < list.size(); i++) {

        int current = list.get(i)[0];
        int needed = m - current;

        int low = i + 1;
        int high = list.size() - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid)[0] == needed) {

                int index1 = list.get(i)[1];
                int index2 = list.get(mid)[1];

                return Arrays.asList(
                    Math.min(index1, index2),
                    Math.max(index1, index2)
                );
            }

            if (list.get(mid)[0] < needed) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }

    return new ArrayList<>();
}
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int m = Integer.parseInt(bufferedReader.readLine().trim());

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.icecreamParlor(m, arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
