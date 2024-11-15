package com.example.book.Payload.Mapper;

import org.springframework.stereotype.Service;

import com.example.book.Entity.Category;
import com.example.book.Payload.Request.CategoryRequest;
import com.example.book.Payload.Response.CategoryResponse;

@Service
public class CategoryMapper {
    public Category toCategory(CategoryRequest categoryRequest)
    {
        return Category.builder()
            .name(categoryRequest.name())
            .description(categoryRequest.description())
            .build();

    }
    public CategoryResponse toCategoryResponse(Category category)
    {
        return new CategoryResponse(
            category.getId().toString(),
            category.getName(),
            category.getDescription()
        );
    }
    
}
