package com.demo.library.app.service;

import com.demo.library.app.domain.Book;
import com.demo.library.app.dto.request.BookSearchCondition;
import com.demo.library.app.dto.response.BookPaginationResponse;
import com.demo.library.app.dto.response.BookResponse;
import com.demo.library.app.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookPaginationResponse findAll(BookSearchCondition condition, Pageable pageable){
        Page<BookResponse> bookResponses = bookRepository.findAll(condition, pageable);

        return BookPaginationResponse.builder()
                .books(bookResponses.getContent())
                .pageCnt(bookResponses.getTotalPages())
                .build();
    }

    @Transactional
    public Book save(Book book){
        return bookRepository.save(book);
    }
    @Transactional
    public void delete(Book book){
        bookRepository.delete(book);
    }
}
