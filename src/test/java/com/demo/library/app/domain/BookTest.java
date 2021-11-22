package com.demo.library.app.domain;

import org.junit.jupiter.api.Test;

import static com.demo.library.app.domain.BookBuilder.dummyBook;
import static org.assertj.core.api.Assertions.assertThat;
public class BookTest {

    @Test
    void update(){
        Book book = dummyBook("토비의 스프링 3.1",1, "이일민","에이콘","W");
        Book updatedBook = book.update("Y");
        assertThat(updatedBook.getStat()).isEqualTo("Y");
    }
}
