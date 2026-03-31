import java.util.Scanner;
//level 1 control flow problem
public class Countdown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
     
        int start = scanner.nextInt();

        for (int i = start; i >= 1; i--) {
            System.out.println(i);
        }

        
    }
}