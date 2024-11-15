package com.example.book.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.Entity.Book;

public interface BookRepository extends JpaRepository<Book,UUID>{

    
}
