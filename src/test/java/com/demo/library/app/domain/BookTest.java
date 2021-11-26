package com.demo.library.app.domain;

import org.junit.jupiter.api.Test;

import static com.demo.library.app.domain.BookBuilder.dummyBook;
import static org.assertj.core.api.Assertions.assertThat;
public class BookTest {

    @Test
    void update(){
        //given
        Book book = dummyBook("토비의 스프링 3.1",1, "이일민","에이콘","W");

        //when
        Book updatedBook = book.update("Y");

        //then
        assertThat(updatedBook.getStat()).isEqualTo("Y");
    }

    @Test
    void delete(){
        //given
        Book book = dummyBook("토비의 스프링 3.1"
                ,1, "이일민","에이콘","W");

        //when
        book.delete();

        //then
        assertThat(book.getStat()).isEqualTo("N");
    }
}
