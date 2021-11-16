package com.demo.library.app.book.controller;

import com.demo.library.app.book.domain.Book;
import com.demo.library.app.book.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id){
        Optional<Book> book = bookService.findById(id);
        return new ResponseEntity<>(book.get(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> add(Book book){
        return new ResponseEntity<>(bookService.save(book), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, Book book){
        bookService.updateById(id,book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
