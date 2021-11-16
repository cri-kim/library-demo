package com.demo.library.app.book.repository;

import com.demo.library.app.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findByNameLike(String name);
    public List<Book> findByCategoryId(Long categoryId);
    public List<Book> findByStat(String stat);
    public List<Book> findByPublisherLike(String publisher);
    public List<Book> findByAuthorLike(String author);
}
