package spring.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.library.controller.request.BookRequest;
import spring.library.domain.Book;
import spring.library.domain.Member;
import spring.library.dto.BookDto;
import spring.library.dto.MemberDto;
import spring.library.repository.BookRepository;
import spring.library.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookDto::from).toList();
    }


    public BookDto save(BookRequest bookRequest) {
        return BookDto.from(bookRepository.save(Book.from(bookRequest)));
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }


}
