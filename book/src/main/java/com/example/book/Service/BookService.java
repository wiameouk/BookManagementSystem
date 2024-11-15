package com.example.book.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.book.Entity.Book;
import com.example.book.Entity.Category;
import com.example.book.Exception.BookNotFoundException;
import com.example.book.Exception.CategoryNotFoundException;
import com.example.book.IService.IBookService;
import com.example.book.Payload.Mapper.BookMapper;
import com.example.book.Payload.Request.BookRequest;
import com.example.book.Payload.Response.BookResponse;
import com.example.book.Repository.BookRepository;
import com.example.book.Repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void saveBook(BookRequest bookRequest, String categoryId) {
        Category category = categoryRepository.findById(UUID.fromString(categoryId))
            .orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        Book book = bookMapper.toBook(bookRequest);
        book.setCategory(category);
        bookRepository.save(book);
    }

    @Override
    public List<BookResponse> getAllBook() {
        return bookRepository.findAll()
            .stream()
            .map(bookMapper::tBookResponse)
            .collect(Collectors.toList());       
    }

    @Override
    public BookResponse getBookById(BookRequest bookRequest, String bookId) {
        return bookRepository.findById(UUID.fromString(bookId)) 
            .map(bookMapper::tBookResponse)
            .orElseThrow(() -> new BookNotFoundException("Book not found"));    
    }

    @Override
    @Transactional
    public void UpdateBook(BookRequest bookRequest, String bookId, String categoryId) {
        Book book = bookRepository.findById(UUID.fromString(bookId)) 
            .orElseThrow(()-> new BookNotFoundException("Book not existe"));
            Category category = categoryRepository.findById(UUID.fromString(categoryId))
                .orElseThrow(()-> new CategoryNotFoundException("category not found"));
                book.setTitle(bookRequest.title());
                book.setAuthor(bookRequest.author());
                book.setPublicationDate(bookRequest.publicationDate());
                book.setPrice(bookRequest.price());
                book.setDescreption(bookRequest.descreption());
                book.setCategory(category);
                bookRepository.save(book);
    }

    @Override
    @Transactional
    public void deleteBookById(String bookId) {
        if(bookRepository.existsById(UUID.fromString(bookId)))
        {
            bookRepository.deleteById(UUID.fromString(bookId));
        }else{
            throw new BookNotFoundException("cannot find Book " +bookId);

        }
    }



    
}
