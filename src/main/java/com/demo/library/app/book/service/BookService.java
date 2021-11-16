package com.demo.library.app.book.service;

import com.demo.library.app.book.domain.Book;
import com.demo.library.app.book.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAll(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(e->books.add(e));
        return books;
    }
    public Optional<Book> findById(Long id){
        Optional<Book> book = bookRepository.findById(id);
        return book;
    }

    public Book save(Book book){
        bookRepository.save(book);
        return book;
    }

    public void updateById(Long id, Book book){
        Optional<Book> e = bookRepository.findById(id);

        if(e.isPresent()){
            e.get().builder()
                    .id(id)
                    .name(book.getName())
                    .publisher(book.getPublisher())
                    .author(book.getAuthor())
                    .gimmick(book.getGimmick())
                    .stat(book.getStat())
                    .categoryId(book.getCategoryId())
                    .build();
        }
    }
}
