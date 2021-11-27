package com.demo.library.app.controller;

import com.demo.library.app.dto.request.CategoryResistrationRequest;
import com.demo.library.app.dto.response.CategoryResponse;
import com.demo.library.app.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    /**
     * @title get categories
     * */
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    /**
     * @param categoryResistrationRequest new category info
     * @title add a category
     * */
    @PostMapping("/add")
    public ResponseEntity<Void> registerCategory(@RequestBody CategoryResistrationRequest categoryResistrationRequest){
        categoryService.save(categoryResistrationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * @param id A category's id
     * @title delete a category
     * */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
