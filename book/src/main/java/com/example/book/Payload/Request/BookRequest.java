package com.example.book.Payload.Request;

import java.sql.Date;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;

public record BookRequest(
    @NonNull
    @NotBlank
    String title,

    @NonNull
    @NotBlank
    String author,

    @NonNull
    Date publicationDate,

    @NonNull
    double price,
    
    @NonNull
    @NotBlank
    String description,
    
    @NonNull
    @NotBlank
    String categoryId
    
) {   
    
}
