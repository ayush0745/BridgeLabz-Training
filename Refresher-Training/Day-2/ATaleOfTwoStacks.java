import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int n = sc.nextInt();
        while(n-- > 0){
            int a = sc.nextInt();
            
            if(a == 1){
                int b = sc.nextInt();
                s1.push(b);
                
            }
            else if(a == 2){
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                }
                }
                s2.pop();
            }
            else{
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                       s2.push(s1.pop());
                    }
                }

                System.out.println(s2.peek());
            }
        }
    }
}