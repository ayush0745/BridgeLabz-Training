import java.util.Scanner;

public class CafetariaMenuApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] menuItems = {
            "Sandwich",
            "Burger",
            "Pizza",
            "Pasta",
            "Noodles",
            "Fried Rice",
            "Coffee",
            "Tea",
            "Juice",
            "Ice Cream"
        };

        displayMenu(menuItems);

        System.out.print("Select an item by index: ");
        int choice = sc.nextInt();

        String selectedItem = getItemByIndex(menuItems, choice);
        System.out.println("You selected: " + selectedItem);

        sc.close();
    }

    // Method to display menu items
    public static void displayMenu(String[] items) {
        System.out.println("---- Cafeteria Menu ----");
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + " : " + items[i]);
        }
    }

    // Method to get item by index
    public static String getItemByIndex(String[] items, int index) {
        return items[index];
    }
}
