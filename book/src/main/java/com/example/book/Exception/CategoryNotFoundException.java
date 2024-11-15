package com.example.book.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String message)
    {
        super(message);
    }
    
}
