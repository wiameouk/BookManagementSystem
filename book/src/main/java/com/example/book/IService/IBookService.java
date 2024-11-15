package com.example.book.IService;

import java.util.List;


import com.example.book.Payload.Request.BookRequest;
import com.example.book.Payload.Response.BookResponse;

public interface IBookService {
    void saveBook(BookRequest bookRequest,String categoryId);
    List<BookResponse> getAllBook();
    BookResponse getBookById(BookRequest bookRequest,String bookId);  
    void UpdateBook(BookRequest bookRequest,String bookId,String CategoryId);
    void deleteBookById(String bookId);
}
