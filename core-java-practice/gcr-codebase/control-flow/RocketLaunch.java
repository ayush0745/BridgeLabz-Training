import java.util.Scanner;
// level 1 control flow problem
public class RocketLaunch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counter = input.nextInt();

        // While loop to count down to 1
        while (counter >= 1) {
            System.out.println(counter);
            counter--; 
        }

      
        input.close();
    }
}