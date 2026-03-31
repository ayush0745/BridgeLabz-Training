import java.util.*;

// Book class
class Book {
    private final String title;
    private final String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Prevent duplicate books in HashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return title.equalsIgnoreCase(book.title)
                && author.equalsIgnoreCase(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), author.toLowerCase());
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}

// Library class
class Library {

    // genre -> list of books
    private Map<String, LinkedList<Book>> catalog = new HashMap<>();

    // To avoid duplication
    private Set<Book> allBooks = new HashSet<>();

    // Add a book (Return)
    public void addBook(String genre, Book book) {
        genre = genre.toLowerCase();

        if (allBooks.contains(book)) {
            System.out.println("Duplicate book not allowed: " + book);
            return;
        }

        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(book);
        allBooks.add(book);

        System.out.println("Book added: " + book);
    }

    // Remove a book (Borrow)
    public void removeBook(String genre, Book book) {
        genre = genre.toLowerCase();
        LinkedList<Book> books = catalog.get(genre);

        if (books != null && books.remove(book)) {
            allBooks.remove(book);
            System.out.println("Book borrowed: " + book);

            if (books.isEmpty()) {
                catalog.remove(genre);
            }
        } else {
            System.out.println("Book not found: " + book);
        }
    }

    // Display catalog
    public void displayCatalog() {
        System.out.println("\nLibrary Catalog:");
        if (catalog.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Map.Entry<String, LinkedList<Book>> entry : catalog.entrySet()) {
            System.out.println("Genre: " + entry.getKey());
            for (Book book : entry.getValue()) {
                System.out.println("  - " + book);
            }
        }
    }
}

// Main class
public class BookShelf {
    public static void main(String[] args) {

        Library library = new Library();

        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("Animal Farm", "George Orwell");
        Book b3 = new Book("The Hobbit", "J.R.R. Tolkien");

        library.addBook("Fiction", b1);
        library.addBook("Fiction", b2);
        library.addBook("Fantasy", b3);

        library.displayCatalog();

        // Borrow a book
        library.removeBook("Fiction", b1);

        library.displayCatalog();

        // Try adding duplicate
        library.addBook("Fantasy", b3);
    }
}
