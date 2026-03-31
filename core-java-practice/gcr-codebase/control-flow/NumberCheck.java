import java.util.Scanner;
// level 1 control flow problem
public class NumberCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
      
        int number = input.nextInt();

        if (number > 0) {
            System.out.println("positive");
        } else if (number < 0) {
            System.out.println("negative");
        } else {
            System.out.println("zero");
        }
        
        input.close();
    }
}