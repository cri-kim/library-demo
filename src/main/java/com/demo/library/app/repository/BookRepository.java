package com.demo.library.app.repository;

import com.demo.library.app.domain.Book;;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> , BookRepositoryCustom{
}
