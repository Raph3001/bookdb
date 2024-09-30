package at.kaindorf.bookshop.bookdb_2;

import at.kaindorf.bookshop.bookdb_2.pojos.AudioBook;
import at.kaindorf.bookshop.bookdb_2.pojos.Author;
import at.kaindorf.bookshop.bookdb_2.pojos.Book;
import at.kaindorf.bookshop.bookdb_2.pojos.EBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookDBTest {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    @Transactional
    void testNumberOfInsertedEBooks() {
        List<Book> books = bookRepository.findAll();
        long ebookCount = books.stream()
                .filter(book -> book instanceof EBook)
                .count();

        assertEquals(4, ebookCount, "The number of inserted EBooks should be 4.");
    }

    @Test
    @Transactional
    void testNumberOfInsertedAudioBooks() {
        List<Book> books = bookRepository.findAll();
        long audioBookCount = books.stream()
                .filter(book -> book instanceof AudioBook)
                .count();

        assertEquals(4, audioBookCount, "The number of inserted AudioBooks should be 4.");
    }

    @Test
    @Transactional
    void testNumberOfInsertedBooks() {
        Long bookCount = bookRepository.findAll().stream().count();

        assertEquals(8, bookCount, "The number of inserted Books should be 8.");
    }

    @Test
    @Transactional
    void testMaximumLengthAudioBook() {
        List<Book> books = bookRepository.findAll();

        // Filter and collect AudioBooks into a List<AudioBook>
        List<AudioBook> audioBooks = books.stream()
                .filter(book -> book instanceof AudioBook)
                .map(book -> (AudioBook) book) // Cast to AudioBook
                .collect(Collectors.toList());

        // Get the longest AudioBook
        AudioBook longestAudioBook = Tools.getLongestAudioBook(audioBooks);

        // Assert the title of the longest AudioBook
        assertEquals("Journey Beyond", longestAudioBook.getTitle(), "Test if name of longest audiobook");
    }


    @Test
    @Transactional
    void testAveragePriceOfBooks() {
        List<Book> books = bookRepository.findAll();
        double averagePrice = books.stream()
                .mapToDouble(Book::getPrice)
                .average()
                .orElse(0.0);

        assertEquals(123.45, averagePrice, "Testing if the average price of all books is 123.45");
    }


}
