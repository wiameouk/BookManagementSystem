package com.example.book.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.Payload.Request.CategoryRequest;
import com.example.book.Payload.Response.CategoryResponse;
import com.example.book.Service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping
    public ResponseEntity<Void>save(@RequestBody CategoryRequest categoryRequest) {
        categoryService.saveCategory(categoryRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CategoryResponse>>getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());   
    }
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable String categoryId) {
        CategoryResponse categoryResponse = categoryService.getCategoryById(null, categoryId);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }
    @PutMapping("/{Id}")
    public ResponseEntity<Void> updateCategory(@RequestBody CategoryRequest categoryRequest,@PathVariable String categoryId) {
        categoryService.UpdateCategory(categoryRequest, categoryId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);   
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<Void>deleteCategory(@PathVariable("Id")String categoryId) {
        categoryService.deleteCategoryById(categoryId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
