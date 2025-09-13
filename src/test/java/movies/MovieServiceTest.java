package movies;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    private final MovieService service = new MovieService();

    private final List<Movie> movies = Arrays.asList(
            new Movie(1, "Avengers", 9.1, "Action"),
            new Movie(2, "Inception", 8.8, "Action"),
            new Movie(3, "The Hangover", 7.5, "Comedy"),
            new Movie(4, "Interstellar", 9.0, "Sci-Fi"),
            new Movie(5, "Mad Max", 9.1, "Action"),
            new Movie(6, "Toy Story", 8.3, "Animation")
    );

    @Test
    void testHighRatedActionMovies() {
        List<Movie> result = service.getHighRatedActionMovies(movies);
        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(m -> m.getGenre().equalsIgnoreCase("Action")));
    }

    @Test
    void testTop3RatedMovies() {
        List<Movie> top3 = service.getTop3RatedMovies(movies);
        assertEquals(3, top3.size());
        assertEquals("Avengers", top3.get(0).getTitle());
        assertEquals("Mad Max", top3.get(1).getTitle());
        assertEquals("Interstellar", top3.get(2).getTitle());
    }

    @Test
    void testHasComedyMovies() {
        assertTrue(service.hasComedyMovies(movies));
    }

    @Test
    void testGetBestRatedMovie() {
        Optional<Movie> best = service.getBestRatedMovie(movies);
        assertTrue(best.isPresent());
        assertTrue(best.get().getRating() >= 9.1);
    }

    @Test
    void testMultipleMaxRatedMovies() {
        List<Movie> tiedMovies = Arrays.asList(
                new Movie(1, "A", 9.5, "Action"),
                new Movie(2, "B", 9.5, "Drama"),
                new Movie(3, "C", 8.9, "Comedy")
        );
        Optional<Movie> best = service.getBestRatedMovie(tiedMovies);
        assertTrue(best.isPresent());
        assertEquals(9.5, best.get().getRating());
    }

    @Test
    void testEmptyMovies() {
        List<Movie> emptyList = Collections.emptyList();
        assertTrue(service.getHighRatedActionMovies(emptyList).isEmpty());
        assertTrue(service.getTop3RatedMovies(emptyList).isEmpty());
        assertFalse(service.hasComedyMovies(emptyList));
        assertTrue(service.getBestRatedMovie(emptyList).isEmpty());
    }
}
