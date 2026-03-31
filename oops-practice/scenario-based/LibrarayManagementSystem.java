import java.util.ArrayList;
import java.util.List;

// Custom Exception
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// Book Class
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkOut() throws BookNotAvailableException {
        if (!isAvailable) {
            throw new BookNotAvailableException(
                "Book \"" + title + "\" is currently unavailable."
            );
        }
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return String.format(
            "%-25s | %-15s | %s",
            title,
            author,
            isAvailable ? "Available" : "Checked Out"
        );
    }
}

// Library Class
class Library {
    private List<Book> books = new ArrayList<>();

    // Load books from array
    public void loadBooks(Book[] bookArray) {
        for (Book b : bookArray) {
            books.add(b);
        }
    }

    // Search by partial title
    public List<Book> searchByTitle(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }

    // Display books
    public void displayBooks(List<Book> list) {
        if (list.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Title                     | Author          | Status");
        System.out.println("-----------------------------------------------");
        for (Book b : list) {
            System.out.println(b);
        }
        System.out.println("-----------------------------------------------");
    }

    // Checkout book
    public void checkoutBook(String title) throws BookNotAvailableException {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.checkOut();
                System.out.println("Book checked out successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

// Main Class
public class LibrarayManagementSystem {
    public static void main(String[] args) {

        Library library = new Library();

        // Book data stored in Array
        Book[] bookArray = {
            new Book("Java Programming", "James Gosling", true),
            new Book("Data Structures", "Mark Weiss", true),
            new Book("Clean Code", "Robert Martin", false),
            new Book("Operating Systems", "Galvin", true)
        };

        library.loadBooks(bookArray);

        System.out.println("\nSearch Results for 'code':");
        List<Book> searchResults = library.searchByTitle("code");
        library.displayBooks(searchResults);

        try {
            library.checkoutBook("Clean Code"); // Unavailable
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            library.checkoutBook("Data Structures"); // Available
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nAll Books After Checkout:");
        library.displayBooks(library.searchByTitle(""));
    }
}
