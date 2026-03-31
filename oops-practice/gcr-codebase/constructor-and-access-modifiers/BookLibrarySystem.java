class Book {
    // Access modifiers
    public String ISBN;
    protected String title;
    private String author;

    // Constructor
    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public methods to set and get private author
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

// Subclass demonstrating access modifiers
class EBook extends Book {
    String fileFormat;

    EBook(String ISBN, String title, String author, String fileFormat) {
        super(ISBN, title, author);
        this.fileFormat = fileFormat;
    }

    void displayDetails() {
        System.out.println("ISBN: " + ISBN);          
        System.out.println("Title: " + title);        
        System.out.println("Author: " + getAuthor()); 
        System.out.println("Format: " + fileFormat);
    }

    public static void main(String[] args) {
        EBook ebook = new EBook(
                "777-4554545",
                "iron man",
                "Stanley",
                "PDF"
        );

        ebook.displayDetails();

        // Modify author name
        ebook.setAuthor("me");
        System.out.println("Updated Author: " + ebook.getAuthor());
    }
}
