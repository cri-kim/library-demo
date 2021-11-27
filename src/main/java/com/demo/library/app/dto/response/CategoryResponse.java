package com.demo.library.app.dto.response;

import com.demo.library.app.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryResponse {
    private Long id;
    private String name;
    public CategoryResponse(Long id, String name){
        this.id = id;
        this.name = name;
    }
    public static CategoryResponse from(Category category){
        return new CategoryResponse(category.getId(), category.getName());
    }
}
