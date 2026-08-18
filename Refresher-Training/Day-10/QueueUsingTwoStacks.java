import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                in.push(x);
            } 
            else if (type == 2) {
                if (out.isEmpty()) {
                    while (!in.isEmpty()) {
                        out.push(in.pop());
                    }
                }
                out.pop();
            } 
            else if (type == 3) {
                if (out.isEmpty()) {
                    while (!in.isEmpty()) {
                        out.push(in.pop());
                    }
                }
                System.out.println(out.peek());
            }
        }
    }
}