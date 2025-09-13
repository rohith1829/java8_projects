package movies;

import java.util.*;

public class MovieService {
    public List<Movie> getHighRatedActionMovies(List<Movie> movies) {
        return movies.stream()
                .filter(m -> m.getRating() > 8 && "Action".equalsIgnoreCase(m.getGenre()))
                .toList();
    }

    public List<Movie> getTop3RatedMovies(List<Movie> movies) {
        return movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .limit(3)
                .toList();
    }

    public boolean hasComedyMovies(List<Movie> movies) {
        return movies.stream()
                .anyMatch(m -> "Comedy".equalsIgnoreCase(m.getGenre()));
    }

    public Optional<Movie> getBestRatedMovie(List<Movie> movies) {
        return movies.stream()
                .max(Comparator.comparingDouble(Movie::getRating));
    }
}
