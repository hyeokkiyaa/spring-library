package spring.library.controller.response;

import lombok.Data;
import spring.library.dto.BookDto;

@Data
public class BookResponse {
    private String title;
    private String author;
    private int year;
    private Long memberId;

    public BookResponse(String title, String author, int year, Long memberId) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.memberId = memberId;
    }

    public BookResponse(BookDto bookDto) {
        this.title = bookDto.getTitle();
        this.author = bookDto.getAuthor();
        this.year = bookDto.getYear();
        this.memberId = bookDto.getMemberId();
    }
}
