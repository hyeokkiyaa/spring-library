package spring.library.controller.request;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String classification;
    private String status;

    public BookRequest(String title, String author, String publisher, int publicationYear, String classification, String status) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.classification = classification;
        this.status = status;
    }
}
