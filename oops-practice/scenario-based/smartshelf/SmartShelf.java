import java.util.*;

class SmartShelf {

    List<Book> shelf = new ArrayList<>();

    // Add book and keep list sorted
    public void addBook(String title) {

        shelf.add(new Book(title));   // Add new book at end
        insertionSort();              // Sort list after each insert
    }

    // Insertion Sort by book title
    private void insertionSort() {

        for (int i = 1; i < shelf.size(); i++) {

            Book key = shelf.get(i);   // Current book to insert
            int j = i - 1;

            // Shift larger titles to the right
            while (j >= 0 &&
                   shelf.get(j).title.compareToIgnoreCase(key.title) > 0) {

                shelf.set(j + 1, shelf.get(j));
                j--;
            }

            shelf.set(j + 1, key);     // Insert at correct position
        }
    }

    // Display current shelf state
    public void displayShelf() {
        System.out.println("SmartShelf Order:");
        for (Book b : shelf) {
            System.out.println(b.title);
        }
    }
}
