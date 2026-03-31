import java.util.*;
import java.util.stream.*;

public class TrendingMovies {

    // Movie class
    static class Movie {
        String name;
        int releaseYear;
        double rating;

        Movie(String name, int releaseYear, double rating) {
            this.name = name;
            this.releaseYear = releaseYear;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return name + " (" + releaseYear + ") - Rating: " + rating;
        }
    }

    // Main method
    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 2024, 8.9),
            new Movie("Movie B", 2023, 9.1),
            new Movie("Movie C", 2022, 7.5),
            new Movie("Movie D", 2024, 8.7),
            new Movie("Movie E", 2021, 9.0),
            new Movie("Movie F", 2024, 9.3),
            new Movie("Movie G", 2023, 8.8),
            new Movie("Movie H", 2020, 8.2)
        );

        // Stream pipeline
        movies.stream()
              // keep only high-rated movies
              .filter(movie -> movie.rating >= 8.5)

              // sort by rating (desc), then by release year (desc)
              .sorted(
                  Comparator.comparingDouble((Movie m) -> m.rating).reversed()
                            .thenComparing(m -> m.releaseYear, Comparator.reverseOrder())
              )

              // take top 5
              .limit(5)

              // print result
              .forEach(System.out::println);
    }
}
