
 class Book {

    // Static variable shared across all books
    private static String libraryName = "Egmore Library";

    // Final variable (cannot be changed once assigned)
    private final String isbn;

    private String title;
    private String author;

    // Constructor using 'this' keyword
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn; // final variable assigned once
    }

    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details using instanceof
    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        } else {
            System.out.println("Invalid book instance.");
        }
    }

    // Main method
    public static void main(String[] args) {

        Book book1 = new Book(
                "Effective Java",
                "Joshua Bloch",
                "978-0134685991"
        );

        // Display library and book details
        Book.displayLibraryName();
        book1.displayBookDetails();
    }
}
