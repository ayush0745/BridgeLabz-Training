class Movie {
    public String title;
    public String director;
    public double rating;
    public int year_of_release;
    Movie next = null;
    Movie prev = null;

    public Movie(String title, String director, double rating, int year_of_release) {
        this.director = director;
        this.title = title;
        this.rating = rating;
        this.year_of_release = year_of_release;
    }
}

class MovieRecord {
    Movie head;
    Movie tail;
    int size;

    // Add at beginning
    public void addAtBeginning(String title, String director, double rating, int year) {
        Movie movie = new Movie(title, director, rating, year);

        if (head == null) {
            head = tail = movie;
        } else {
            movie.next = head;
            head.prev = movie;
            head = movie;
        }
        size++;
    }

    // Add at end
    public void addAtEnd(String title, String director, double rating, int year) {
        Movie movie = new Movie(title, director, rating, year);

        if (head == null) {
            head = tail = movie;
        } else {
            tail.next = movie;
            movie.prev = tail;
            tail = movie;
        }
        size++;
    }

    // Add at specific position (1-based)
    public void addAtPosition(String title, String director, double rating, int year, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            addAtBeginning(title, director, rating, year);
            return;
        }

        if (position == size + 1) {
            addAtEnd(title, director, rating, year);
            return;
        }

        Movie movie = new Movie(title, director, rating, year);
        Movie temp = head;

        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        movie.next = temp.next;
        movie.prev = temp;
        temp.next.prev = movie;
        temp.next = movie;

        size++;
    }

    // Remove by movie title
    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("No movies available");
            return;
        }

        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }

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

        size--;
        System.out.println("Movie removed successfully");
    }

    // Search by director
    public void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found for director: " + director);
        }
    }

    // Search by rating
    public void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating >= rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found with rating >= " + rating);
        }
    }

    // Update rating by title
    public void updateRating(String title, double newRating) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found");
    }

    // Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display");
            return;
        }

        Movie temp = head;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display");
            return;
        }

        Movie temp = tail;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    private void displayMovie(Movie m) {
        System.out.println(
            "Title: " + m.title +
            ", Director: " + m.director +
            ", Year: " + m.year_of_release +
            ", Rating: " + m.rating
        );
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {

        MovieRecord record = new MovieRecord();

        record.addAtBeginning("Inception", "Christopher Nolan", 8.8, 2010);
        record.addAtEnd("Interstellar", "Christopher Nolan", 8.6, 2014);
        record.addAtPosition("Tenet", "Christopher Nolan", 7.4, 2020, 2);

        System.out.println("All Movies (Forward):");
        record.displayForward();

        System.out.println("\nAll Movies (Reverse):");
        record.displayReverse();

        System.out.println("\nSearch by Director:");
        record.searchByDirector("Christopher Nolan");

        System.out.println("\nUpdating Rating:");
        record.updateRating("Tenet", 8.0);

        System.out.println("\nRemoving Movie:");
        record.removeByTitle("Inception");

        System.out.println("\nFinal Movie List:");
        record.displayForward();
    }
}
