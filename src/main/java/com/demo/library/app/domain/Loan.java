package com.demo.library.app.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Builder
@Cacheable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "user_id"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name="book_id"))
    private Book book;

    private String regDtm;
    private String returnAt;
    private String dueAt;

    public Loan(User user, Book book){
        this.user = user;
        this.book = book;
    }
    public Loan update(String returnAt){
        this.returnAt = returnAt;
        return this;
    }
}
