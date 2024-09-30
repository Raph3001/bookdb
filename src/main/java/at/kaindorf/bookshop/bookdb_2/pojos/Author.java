    package at.kaindorf.bookshop.bookdb_2.pojos;

    import com.fasterxml.jackson.annotation.JsonIgnore;
    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import com.fasterxml.jackson.annotation.JsonSubTypes;
    import com.fasterxml.jackson.annotation.JsonTypeInfo;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.util.List;

    /**
     * Project: Exa_101_BookShop
     * Created by: raph
     * Date: 2024-09-26
     * Time: 11:01:35
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Author {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonIgnore
        private Long authorId;

        @Column(nullable = false)
        private String firstname;
        @Column(nullable = false)
        private String lastname;

        @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
        @JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
        @JsonSubTypes({
                @JsonSubTypes.Type(EBook.class),
                @JsonSubTypes.Type(AudioBook.class)
        })
        private List<Book> books;



    }
