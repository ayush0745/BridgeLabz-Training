import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<List<String>> set = new HashSet<>();

        int n = sc.nextInt();

        while (n-- > 0) {

            String a = sc.next();
            String b = sc.next();

            List<String> pair = Arrays.asList(a, b);

            set.add(pair);

            System.out.println(set.size());
        }
    }
}