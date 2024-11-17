package com.example.book.Payload.Mapper;

import org.springframework.stereotype.Service;

import com.example.book.Entity.Book;
import com.example.book.Payload.Request.BookRequest;
import com.example.book.Payload.Response.BookResponse;

@Service
public class BookMapper {
    public  Book toBook(BookRequest bookRequest)
    {
        return Book.builder()
            .title(bookRequest.title())
            .author(bookRequest.author())
            .publicationDate(bookRequest.publicationDate())
            .price(bookRequest.price())
            .description(bookRequest.description())
            .build();

    }
    public BookResponse tBookResponse(Book book)
    {
        return new BookResponse(
            book.getId().toString(),
            book.getTitle(),
            book.getAuthor(),
            book.getPublicationDate(),
            book.getPrice(),
            book.getDescription(),
            book.getCategory().getId().toString()
        );
    }
    
}
