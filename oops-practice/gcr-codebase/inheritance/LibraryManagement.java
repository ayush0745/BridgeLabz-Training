class Book {
    private String title;
    private int publicationYear;

    // Constructor
    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    // Method to display book info
    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    private String name;
    private String bio;

    // Constructor
    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear); // call Book constructor
        this.name = name;
        this.bio = bio;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    // Override displayInfo
    @Override
    void displayInfo() {
        super.displayInfo(); // display book details
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Author book1 = new Author(
                "Effective Java",
                2018,
                "Joshua Bloch",
                "Expert Java programmer and author."
        );

        book1.displayInfo();
    }
}
