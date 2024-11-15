package com.example.book.Payload.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
    @NotBlank
    @NotNull
    String name,
    
    @NotBlank
    @NotNull
    String description
) {
    
}
