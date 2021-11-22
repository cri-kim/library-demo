package com.demo.library.app.domain;

import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity(name="category")
public class Category extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Book> book;
}
