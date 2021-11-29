package com.demo.library.app.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
public class BookResponse {
    private Long id;
    private String author;
    private String publisher;
    private String name;
    private String stat;
    private String floor;
    private int gimmick;

    private CategoryResponse category;
}
