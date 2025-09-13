package library_management;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class LibraryServiceTest {

    private final LibraryService service = new LibraryService();

    private final List<Book> books = Arrays.asList(
            new Book(1, "Java Basics", "James Gosling", 450),
            new Book(2, "Effective Java", "Joshua Bloch", 900),
            new Book(3, "Clean Code", "Robert C. Martin", 700),
            new Book(4, "Algorithms", "CLRS", 1200),
            new Book(5, "Head First Java", "Kathy Sierra", 500)
    );

    @Test
    void testFilterExpensiveBooks() {
        List<Book> result = service.filterExpensiveBooks(books);
        assertEquals(3, result.size());
        assertEquals("Clean Code", result.get(0).getTitle());
        assertEquals("Effective Java", result.get(1).getTitle());
        assertEquals("Algorithms", result.get(2).getTitle());
    }

    @Test
    void testGetUniqueAuthors() {
        Set<String> authors = service.getUniqueAuthors(books);
        assertEquals(5, authors.size());
        assertTrue(authors.contains("Joshua Bloch"));
    }

    @Test
    void testFindMostExpensiveBook() {
        Optional<Book> mostExpensive = service.findMostExpensiveBook(books);
        assertTrue(mostExpensive.isPresent());
        assertEquals("Algorithms", mostExpensive.get().getTitle());
    }

    @Test
    void testEmptyBookList() {
        List<Book> emptyList = new ArrayList<>();
        List<Book> result = service.filterExpensiveBooks(emptyList);
        assertTrue(result.isEmpty());

        Set<String> authors = service.getUniqueAuthors(emptyList);
        assertTrue(authors.isEmpty());

        Optional<Book> mostExpensive = service.findMostExpensiveBook(emptyList);
        assertTrue(mostExpensive.isEmpty());
    }
}
