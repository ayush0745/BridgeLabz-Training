class Book {
    int bookId;
    String title;
    String author;
    String genre;
    boolean isAvailable;

    Book next;
    Book prev;

    public Book(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    Book head;
    Book tail;
    int count;

    //Add at beginning
    public void addAtBeginning(int id, String title, String author, String genre, boolean status) {
        Book book = new Book(id, title, author, genre, status);

        if (head == null) {
            head = tail = book;
        } else {
            book.next = head;
            head.prev = book;
            head = book;
        }
        count++;
    }

    //Add at end
    public void addAtEnd(int id, String title, String author, String genre, boolean status) {
        Book book = new Book(id, title, author, genre, status);

        if (head == null) {
            head = tail = book;
        } else {
            tail.next = book;
            book.prev = tail;
            tail = book;
        }
        count++;
    }

    //Add at specific position (1-based)
    public void addAtPosition(int pos, int id, String title, String author, String genre, boolean status) {
        if (pos <= 1) {
            addAtBeginning(id, title, author, genre, status);
            return;
        }

        Book temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            addAtEnd(id, title, author, genre, status);
            return;
        }

        Book book = new Book(id, title, author, genre, status);
        book.next = temp.next;
        book.prev = temp;
        temp.next.prev = book;
        temp.next = book;

        count++;
    }

    //Remove by Book ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("Library is empty");
            return;
        }

        Book temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                count--;
                System.out.println("Book removed successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    //Search by Title
    public void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No book found with this title");
    }

    //Search by Author
    public void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No book found by this author");
    }

    //Update availability
    public void updateAvailability(int id, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                System.out.println("Availability updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    //Display forward
    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    //Display reverse
    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    //Count books
    public int totalBooks() {
        return count;
    }

    private void displayBook(Book b) {
        System.out.println(
            "ID: " + b.bookId +
            ", Title: " + b.title +
            ", Author: " + b.author +
            ", Genre: " + b.genre +
            ", Available: " + (b.isAvailable ? "Yes" : "No")
        );
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addAtEnd(1, "Clean Code", "Robert Martin", "Programming", true);
        library.addAtBeginning(2, "Effective Java", "Joshua Bloch", "Programming", true);
        library.addAtEnd(3, "1984", "George Orwell", "Fiction", false);

        System.out.println("Library (Forward):");
        library.displayForward();

        System.out.println("\nLibrary (Reverse):");
        library.displayReverse();

        System.out.println("\nSearch by Author:");
        library.searchByAuthor("Joshua Bloch");

        library.updateAvailability(3, true);

        System.out.println("\nTotal Books: " + library.totalBooks());
    }
}
