class Book {

    String title;
    String author;
    boolean isAvailable;

    // Constructor
    Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {

        // Store book data in an array
        Book[] books = {
            new Book("Java Programming", "James Gosling", true),
            new Book("Data Structures", "Mark Allen", true),
            new Book("Python Basics", "Guido van Rossum", false),
            new Book("Operating Systems", "Abraham Silberschatz", true)
        };

        // Display all books
        displayBooks(books);

        // Search by partial title
        System.out.println("\nSearch results for 'Java':");
        searchByTitle(books, "Java");

        // Checkout a book
        System.out.println("\nChecking out 'Data Structures':");
        checkoutBook(books, "Data Structures");

        // Display updated list
        System.out.println("\nUpdated Book List:");
        displayBooks(books);
    }

    // Method to display all books
    public static void displayBooks(Book[] books) {
        for (Book book : books) {
            String status = book.isAvailable ? "Available" : "Checked Out";
            System.out.println(book.title + " | " + book.author + " | " + status);
        }
    }

    // Method to search books by partial title
    public static void searchByTitle(Book[] books, String keyword) {
        for (Book book : books) {
            if (book.title.toLowerCase().contains(keyword.toLowerCase())) {
                String status = book.isAvailable ? "Available" : "Checked Out";
                System.out.println(book.title + " | " + book.author + " | " + status);
            }
        }
    }

    // Method to checkout a book
    public static void checkoutBook(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.isAvailable) {
                    book.isAvailable = false;
                    System.out.println("Book checked out successfully.");
                } else {
                    System.out.println("Book is already checked out.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
