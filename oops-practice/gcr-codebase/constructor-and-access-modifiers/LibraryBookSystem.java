class Book {
    String title;
    String author;
    double price;
    boolean available;

    // Parameterized constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true; // book is available initially
    }

    // Method to borrow a book
    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("harry potter", "JK", 450);

        b1.borrowBook(); 
        b1.borrowBook(); 
    }
}
