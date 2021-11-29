package com.demo.library.app.repository;

import com.demo.library.app.dto.request.BookSearchCondition;
import com.demo.library.app.dto.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookRepositoryCustom {

    Page<BookResponse> findAll(BookSearchCondition condition, Pageable pageable);
}
