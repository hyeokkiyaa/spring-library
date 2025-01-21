package spring.library.controller.response;

import lombok.Builder;
import lombok.Data;
import spring.library.dto.BookDto;

@Data
@Builder
public class BookResponse {
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String classification;
    private String status;

    public BookResponse(String title, String author, String publisher, int publicationYear, String classification, String status) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.classification = classification;
        this.status = status;
    }

    public BookResponse(BookDto bookDto) {
        this.title = bookDto.getTitle();
        this.author = bookDto.getAuthor();
        this.publisher = bookDto.getPublisher();
        this.publicationYear = bookDto.getPublicationYear();
        this.classification = bookDto.getClassification();
        this.status = bookDto.getStatus();
    }

    public static BookResponse from(BookDto bookDto) {
        return BookResponse.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .publisher(bookDto.getTitle())
                .publicationYear(bookDto.getPublicationYear())
                .classification(bookDto.getClassification())
                .status(bookDto.getStatus())
                .build();
    }
}
