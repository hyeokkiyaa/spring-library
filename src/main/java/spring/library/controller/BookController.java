package spring.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.controller.request.BookRequest;
import spring.library.controller.response.BookResponse;
import spring.library.dto.BookDto;
import spring.library.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BookResponse>> getBooks() {
        List<BookResponse> books = bookService.findAll().stream().map(BookResponse::from).toList();
        return ResponseEntity.ok().body(books);

    }

    @PostMapping("/books")
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest bookRequest) {
        BookDto bookDto = bookService.save(bookRequest);
        return ResponseEntity.ok().body(BookResponse.from(bookDto));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
