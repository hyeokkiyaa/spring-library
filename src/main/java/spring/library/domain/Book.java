package spring.library.domain;

import jakarta.persistence.*;
import lombok.*;
import spring.library.controller.request.BookRequest;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String classification;
    private String status;


    public Book(String title, String author, String publisher, int publicationYear, String classification, String status) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.classification = classification;
        this.status = status;
    }

    public static Book from(BookRequest bookRequest) {
        return Book.builder()
                .title(bookRequest.getTitle())
                .author(bookRequest.getAuthor())
                .publisher(bookRequest.getPublisher())
                .publicationYear(bookRequest.getPublicationYear())
                .classification(bookRequest.getClassification())
                .status(bookRequest.getStatus())
                .build();
    }
}
