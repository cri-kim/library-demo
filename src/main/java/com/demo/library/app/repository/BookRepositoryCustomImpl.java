package com.demo.library.app.repository;

import com.demo.library.app.domain.Book;
import com.demo.library.app.dto.request.BookSearchCondition;
import com.demo.library.app.dto.response.BookResponse;
import com.demo.library.app.dto.response.CategoryResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.Objects;

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
        return applyPagination(pageable, contentQuery
                -> bookContentQuery(bookCondition(condition)));
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
                        book.id, book.name,book.author, book.publisher, book.floor
                        ,book.gimmick, book.updatedAt,
                        Projections.constructor(CategoryResponse.class,
                                category.id, category.name)))
                .from(book)
                .join(book.category, category)
                .where(condition);
    }
    private BooleanExpression book(){
        return book.id.goe(0);
    }
    private BooleanExpression bookNameLike(BookSearchCondition condition){
        if(Objects.isNull(condition.getName())){
            return null;
        }
        return book.name.like(condition.getName());
    }
    private BooleanExpression bookCondition(BookSearchCondition condition){
        return book().and(bookNameLike(condition));
    }
}
