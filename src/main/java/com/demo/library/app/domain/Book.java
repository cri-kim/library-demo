package com.demo.library.app.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Entity
public class Book extends BaseEntity{
    private static final String DELETED_STAT = "N";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String publisher;
    private String name;
    private String stat;

    private int gimmick;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name="category_id"))
    private Category category;

    @OneToMany(mappedBy = "order", fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Order> order;

    @OneToMany(mappedBy = "loan", fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Loan> loan;

    public Book update(String stat){
        this.stat = stat;
        return this;
    }
    public void delete(){
        this.stat = DELETED_STAT;
    }
}
