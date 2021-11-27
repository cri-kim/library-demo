package com.demo.library.app.service;

import com.demo.library.app.domain.Category;
import com.demo.library.app.dto.request.CategoryResistrationRequest;
import com.demo.library.app.dto.response.CategoryResponse;
import com.demo.library.app.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository= categoryRepository;
    }

    @Transactional(readOnly = true)
    public Map<String, Category> findAllToMap(){
        return categoryRepository.findAll()
                .stream()
                .collect(Collectors.toMap(Category::getName, Function.identity()));
    }

    @Transactional(readOnly = true)
    public List<CategoryResponse> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category->CategoryResponse.from(category))
                .collect(Collectors.toList());
    }
    @Transactional
    public void save(CategoryResistrationRequest categoryResistrationRequest){
        Category category = Category.builder().name(categoryResistrationRequest.getName())
                .build();
        categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
