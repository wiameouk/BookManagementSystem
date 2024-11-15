package com.example.book.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message){
        super(message);
    }    
}