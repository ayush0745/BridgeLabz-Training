import java.io.*;
import java.util.*;

class Result {

    public static int powerSum(int X, int N) {
        return count(X, N, 1);
    }

    public static int count(int X, int N, int num) {

        int power = (int) Math.pow(num, N);

        if (power > X) {
            return 0;
        }

        if (power == X) {
            return 1;
        }

        return count(X - power, N, num + 1)
             + count(X, N, num + 1);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
            new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = Integer.parseInt(bufferedReader.readLine().trim());

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}