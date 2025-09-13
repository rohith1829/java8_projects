package library_management;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryService {

    public List<Book> filterExpensiveBooks(List<Book> books) {
        return books.stream()
                .filter(b -> b.getPrice() > 500)
                .sorted(Comparator.comparingDouble(Book::getPrice))
                .toList();
    }

    public Set<String> getUniqueAuthors(List<Book> books) {
        return books.stream()
                .map(Book::getAuthor)
                .collect(Collectors.toSet());
    }

    public Optional<Book> findMostExpensiveBook(List<Book> books) {
        return books.stream()
                .max(Comparator.comparingDouble(Book::getPrice));
    }
}
