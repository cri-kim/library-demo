package com.demo.library.app.controller;

import com.demo.library.app.dto.request.BookSearchCondition;
import com.demo.library.app.dto.response.BookPaginationResponse;
import com.demo.library.app.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public ResponseEntity<BookPaginationResponse> findBooks(@ModelAttribute BookSearchCondition condition, Pageable pageable){
        return ResponseEntity.ok(bookService.findAll(condition, pageable));
    }

}
