package at.kaindorf.bookshop.bookdb_2;

import at.kaindorf.bookshop.bookdb_2.pojos.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
    // You can define custom query methods here if needed
}
