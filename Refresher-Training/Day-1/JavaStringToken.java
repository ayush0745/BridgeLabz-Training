import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    
    
    String[] tokens = s.trim().split("[^A-Za-z]+");
    
    
    List<String> filtered = new ArrayList<>();
    for (String t : tokens) {
        if (!t.isEmpty()) filtered.add(t);
    }
    
    System.out.println(filtered.size());
    for (String t : filtered) {
        System.out.println(t);
    }
}
}
