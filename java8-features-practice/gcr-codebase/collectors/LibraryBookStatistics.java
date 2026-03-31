import java.util.*;
import java.util.stream.*;

class Book {
    private String title;
    private String genre;
    private int pages;

    public Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }
}

public class LibraryBookStatistics {
    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
            new Book("Java Basics", "Programming", 300),
            new Book("Advanced Java", "Programming", 500),
            new Book("History of India", "History", 400),
            new Book("World War II", "History", 350),
            new Book("Mystery House", "Fiction", 250)
        );

        // Group by genre and summarize pages
        Map<String, IntSummaryStatistics> statsByGenre =
                books.stream()
                     .collect(Collectors.groupingBy(
                             Book::getGenre,
                             Collectors.summarizingInt(Book::getPages)
                     ));

        // Print statistics
        statsByGenre.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("Total Pages: " + stats.getSum());
            System.out.println("Average Pages: " + stats.getAverage());
            System.out.println("Max Pages: " + stats.getMax());
            System.out.println();
        });
    }
}
