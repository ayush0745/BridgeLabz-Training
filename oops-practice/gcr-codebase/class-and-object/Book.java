import java.util.Scanner;

class Book {
    String title;
    String author;
    double price;

    // Constructor 
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayBook() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating object
        System.out.println("Enter details for Book :");
        System.out.print("Title: ");
        String t1 = scanner.nextLine();
        System.out.print("Author: ");
        String a1 = scanner.nextLine();
        System.out.print("Price: ");
        double p1 = scanner.nextDouble();
        scanner.nextLine(); 

        // Creating the second book object
        System.out.println("\nEnter details for Book :");
        System.out.print("Title: ");
        String t2 = scanner.nextLine();
        System.out.print("Author: ");
        String a2 = scanner.nextLine();
        System.out.print("Price: ");
        double p2 = scanner.nextDouble();

        // Initializing objects
        Book book1 = new Book(t1, a1, p1);
        Book book2 = new Book(t2, a2, p2);

        // Displaying outputs
       
        book1.displayBook();
        book2.displayBook();

        scanner.close();
    }
}