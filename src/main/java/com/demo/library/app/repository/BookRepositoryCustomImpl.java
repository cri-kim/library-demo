package com.demo.library.app.repository;

import com.demo.library.app.domain.Book;
import com.demo.library.app.dto.request.BookSearchCondition;
import com.demo.library.app.dto.response.BookResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static com.demo.library.app.domain.querydsl.QBook.book;
import static com.demo.library.app.domain.querydsl.QCategory.category;

public class BookRepositoryCustomImpl extends QuerydslRepositorySupportCustom implements BookRepositoryCustom {

    public BookRepositoryCustomImpl(EntityManager entityManager) {
        super(Book.class);
    }
    public BookRepositoryCustomImpl(EntityManager entityManager, boolean transacted) {
        super(Book.class, transacted);
    }

    @Override
    public Page<BookResponse> findAll(BookSearchCondition condition, Pageable pageable) {
        return null;
    }

    private JPAQuery<BookResponse> bookContentQuery(BooleanExpression condition){
        EntityTransaction tx = null;
        if(getTransacted()){
            tx = getEntityManager().getTransaction();
            tx.begin();
            getEntityManager().flush();
            getEntityManager().clear();
        }

        return getQueryFactory().select(
                Projections.constructor(BookResponse.class,
                        book.id, book.name, book.categoryId))
                .from(book)
                .join(book.categoryId, category)
                .where(condition);
    }
}
