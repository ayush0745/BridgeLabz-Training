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
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
    // Write your code here
    ArrayList<Integer> arr = new ArrayList<>(operations.size());
    Stack<Integer> s = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();
    for(String str : operations){
        String [] ar = str.split(" ");
        if(ar[0].equals("1")){
            s.push(Integer.parseInt(ar[1]));
            if (maxStack.isEmpty()) {
                maxStack.push(Integer.parseInt(ar[1]));
            }           
            else {
                maxStack.push(Math.max(Integer.parseInt(ar[1]), maxStack.peek()));
                 }
        }
        else if(ar[0].equals("2")){
            s.pop();
            maxStack.pop();
        }
        else{
            arr.add(maxStack.peek());
            
        }
    }
  return arr;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
