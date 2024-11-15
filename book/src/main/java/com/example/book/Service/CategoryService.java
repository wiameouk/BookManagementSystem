package com.example.book.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.book.Entity.Category;
import com.example.book.Exception.CategoryNotFoundException;
import com.example.book.IService.ICategory;
import com.example.book.Payload.Mapper.CategoryMapper;
import com.example.book.Payload.Request.CategoryRequest;
import com.example.book.Payload.Response.CategoryResponse;
import com.example.book.Repository.CategoryRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategory {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @Override
    @Transactional
    public void saveCategory(CategoryRequest categoryRequest) {
        Category category = categoryMapper.toCategory(categoryRequest);
        categoryRepository.save(category);
    }
    @Override
    public List<CategoryResponse> getAllCategory() {
        return categoryRepository.findAll()
            .stream()
            .map(categoryMapper::toCategoryResponse)
            .collect(Collectors.toList());
        }
    @Override
    public CategoryResponse getCategoryById(CategoryRequest categoryRequest, String categoryId) {
        return categoryRepository.findById(UUID.fromString(categoryId))
            .map(categoryMapper::toCategoryResponse)
            .orElseThrow(()-> new CategoryNotFoundException("cannot create " +categoryId));
    }
    @Override
    @Transactional
    public void UpdateCategory(CategoryRequest categoryRequest, String categoryId) {
        Category category = categoryRepository.findById(UUID.fromString(categoryId))
        .orElseThrow(()-> new CategoryNotFoundException("cannot create " +categoryId));
        category.setName(categoryRequest.name());
        category.setDescription(categoryRequest.description()); 
        categoryRepository.save(category);
    }
    @Override
    @Transactional
    public void deleteCategoryById( String categoryId) {
         if(categoryRepository.existsById(UUID.fromString(categoryId)))
        {
            categoryRepository.deleteById(UUID.fromString(categoryId));
        }else{
            throw new CategoryNotFoundException("cannot find category " +categoryId);

        }
    }

    

    
}
