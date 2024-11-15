package com.example.book.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category,UUID>{
    
}
