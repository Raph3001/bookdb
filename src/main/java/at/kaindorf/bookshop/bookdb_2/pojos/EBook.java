package at.kaindorf.bookshop.bookdb_2.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Project: Exa_101_BookShop
 * Created by: raph
 * Date: 2024-09-26
 * Time: 11:03:59
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("EBook")
public class EBook extends Book {

    private String url;

    public EBook(String isbn, String title, Double price, LocalDate publishingDate, Author author, String url) {
        super(isbn, title, price, publishingDate, author);
        this.url = url;
    }
}
