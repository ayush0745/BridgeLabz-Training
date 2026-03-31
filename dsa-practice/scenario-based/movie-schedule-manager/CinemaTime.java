import java.util.ArrayList;
import java.util.List;

public class CinemaTime {

    private final List<String> movieTitles = new ArrayList<>();
    private final List<String> showTimes = new ArrayList<>();

    // Add movie
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        movieTitles.add(title);
        showTimes.add(time);
    }

    // Search movie by keyword
    public void searchMovie(String keyword) {
        try {
            boolean found = false;
            for (int i = 0; i < movieTitles.size(); i++) {
                if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(
                        String.format("Found: %s at %s", movieTitles.get(i), showTimes.get(i))
                    );
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No movies found for keyword: " + keyword);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Search index error: " + e.getMessage());
        }
    }

    // Display all movies
    public void displayAllMovies() {
        if (movieTitles.isEmpty()) {
            System.out.println("No movies scheduled.");
            return;
        }

        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.println(
                String.format("%d. %s - %s", i + 1, movieTitles.get(i), showTimes.get(i))
            );
        }
    }

    // Convert list to array for printable report
    public void generateReport() {
        String[] titlesArray = movieTitles.toArray(new String[0]);
        String[] timesArray = showTimes.toArray(new String[0]);

        System.out.println("\n--- Movie Schedule Report ---");
        for (int i = 0; i < titlesArray.length; i++) {
            System.out.println(titlesArray[i] + " | " + timesArray[i]);
        }
    }

    // Validate time format HH:MM (24-hour)
    private boolean isValidTime(String time) {
        if (!time.matches("\\d{2}:\\d{2}")) return false;

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
    }
}
