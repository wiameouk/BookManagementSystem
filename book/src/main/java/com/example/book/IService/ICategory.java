package com.example.book.IService;

import java.util.List;

import com.example.book.Payload.Request.CategoryRequest;
import com.example.book.Payload.Response.CategoryResponse;

public interface ICategory {
    void saveCategory(CategoryRequest categoryRequest);
    List<CategoryResponse> getAllCategory();
    CategoryResponse getCategoryById(CategoryRequest categoryRequest,String categoryId);
    void UpdateCategory(CategoryRequest categoryRequest,String categoryId);
    void deleteCategoryById(String categoryId);    
}
