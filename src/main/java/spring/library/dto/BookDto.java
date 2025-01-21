package spring.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.library.domain.Book;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String classification;
    private String status;

    public static BookDto from(Book book) {
        return BookDto.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .publisher(book.getPublisher())
                .publicationYear(book.getPublicationYear())
                .classification(book.getClassification())
                .status(book.getStatus())
                .build();
    }

}
