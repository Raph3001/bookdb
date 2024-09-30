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
 * Time: 11:04:09
 */


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("AudioBook")
public class AudioBook extends Book {

    public AudioBook(String isbn, String title, Double price, LocalDate publishingDate, Author author, String category, String length) {
        super(isbn, title, price, publishingDate, author);
        this.category = category;
        this.length = length;
    }


    private String category;

    private String length;

}
