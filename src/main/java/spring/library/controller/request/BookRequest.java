package spring.library.controller.request;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String author;
    private int year;
    private Long memberId;

    public BookRequest(String title, String author, int year, Long memberId) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.memberId = memberId;
    }
}
