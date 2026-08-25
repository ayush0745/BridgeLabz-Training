import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {

            String s = sc.nextLine();

            Stack<Character> stack = new Stack<>();

            boolean balanced = true;

            for (char ch : s.toCharArray()) {

                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                }
                else if (ch == ')' || ch == '}' || ch == ']') {

                    if (stack.isEmpty()) {
                        balanced = false;
                        break;
                    }

                    char top = stack.pop();

                    if (ch == ')' && top != '(' ||
                        ch == '}' && top != '{' ||
                        ch == ']' && top != '[') {

                        balanced = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                balanced = false;
            }

            System.out.println(balanced);
        }
    }
}