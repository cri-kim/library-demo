package com.demo.library.app.domain;

import java.util.ArrayList;

public class BookBuilder {
    private BookBuilder(){

    }

    public static Book dummyBook(String name, int gimmick, String author, String publisher, String stat){
        return Book.builder().name(name)
                .gimmick(gimmick)
                .publisher(publisher)
                .author(author)
                .stat(stat)
                .order(new ArrayList<Order>())
                .loan(new ArrayList<Loan>())
                .build();
    }
}
