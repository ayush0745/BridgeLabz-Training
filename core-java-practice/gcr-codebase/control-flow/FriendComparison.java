import java.util.Scanner;
// level 2 control flow  problem
public class FriendComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Amar
        System.out.print("Enter Amar's age and height: ");
        int ageAmar = scanner.nextInt();
        double heightAmar = scanner.nextDouble();

        // Input for Akbar
        System.out.print("Enter Akbar's age and height: ");
        int ageAkbar = scanner.nextInt();
        double heightAkbar = scanner.nextDouble();

        // Input for Anthony
        System.out.print("Enter Anthony's age and height: ");
        int ageAnthony = scanner.nextInt();
        double heightAnthony = scanner.nextDouble();

        // Find the youngest 
        String youngest;
        if (ageAmar <= ageAkbar && ageAmar <= ageAnthony) {
            youngest = "Amar";
        } 
        else if (ageAkbar <= ageAmar && ageAkbar <= ageAnthony) {
            youngest = "Akbar";
        } 
        else {
            youngest = "Anthony";
        }

        // Find the tallest
        String tallest;
        if (heightAmar >= heightAkbar && heightAmar >= heightAnthony) {
            tallest = "Amar";
        } 
        else if (heightAkbar >= heightAmar && heightAkbar >= heightAnthony) {
            tallest = "Akbar";
        } 
        else {
            tallest = "Anthony";
        }

        
        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);
        
        scanner.close();
    }
}