import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] pumps = new int[n][2];

        for (int i = 0; i < n; i++) {
            pumps[i][0] = sc.nextInt(); // petrol
            pumps[i][1] = sc.nextInt(); // distance
        }

        for (int start = 0; start < n; start++) {

            int tank = 0;
            boolean possible = true;

            for (int count = 0; count < n; count++) {

                int current = (start + count) % n;

                tank += pumps[current][0];
                tank -= pumps[current][1];

                if (tank < 0) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println(start);
                return;
            }
        }
    }
}