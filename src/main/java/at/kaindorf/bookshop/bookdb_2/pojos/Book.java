package at.kaindorf.bookshop.bookdb_2.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Project: Exa_101_BookShop
 * Created by: raph
 * Date: 2024-09-26
 * Time: 11:01:44
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Data
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Book {

    @Id
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Double price;


    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "US")
    private LocalDate publishing_date;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = true)
    private Author author;

}
