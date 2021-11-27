package com.demo.library.app.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryResistrationRequest {

    private String name;

    @Builder
    public CategoryResistrationRequest( String name){
        this.name = name;
    }
}
