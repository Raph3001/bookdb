package at.kaindorf.bookshop.bookdb_2;

import at.kaindorf.bookshop.bookdb_2.pojos.Author;
import at.kaindorf.bookshop.bookdb_2.pojos.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * Project: Exa_101_BookShop
 * Created by: raph
 * Date: 2024-09-26
 * Time: 11:18:20
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class InitDB {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @PostConstruct
    public void initDB() {

        InputStream is = getClass().getResourceAsStream("/audioAndEbooks.json");
        if (is != null) {
            ObjectMapper mapper = new ObjectMapper()
                    .registerModule(new JavaTimeModule());
            try {
                List<Author> authors = mapper.readerForListOf(Author.class).readValue(is);
                authorRepository.saveAll(authors);

                for (Author author : authors) {
                    List<Book> books = author.getBooks();
                    if (books != null) {
                        bookRepository.saveAll(books);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
