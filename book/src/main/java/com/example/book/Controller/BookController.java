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

import com.example.book.Payload.Request.BookRequest;
import com.example.book.Payload.Response.BookResponse;
import com.example.book.Service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/{categoryId}")
    public ResponseEntity<Void>save(@RequestBody BookRequest bookRequest, @PathVariable String categoryId) {
        bookService.saveBook(bookRequest, categoryId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBook());
    }
    @GetMapping("/{bookId}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable String bookId) {
        BookResponse bookResponse = bookService.getBookById(null, bookId);
        return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }
    @PutMapping("/{bookId}/{categoryId}")
    public ResponseEntity<Void> updateBook(@RequestBody BookRequest bookRequest,@PathVariable String categoryId,@PathVariable String bookId) {
        bookService.UpdateBook(bookRequest, bookId, categoryId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);   
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable ("bookId")String bookId) {
        bookService.deleteBookById(bookId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
