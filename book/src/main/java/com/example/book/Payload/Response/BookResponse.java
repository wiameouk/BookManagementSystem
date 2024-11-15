package com.example.book.Payload.Response;
import java.sql.Date;

public record BookResponse(
    String id,
    String title,
    String author,
    Date publicationDate,
    double price,
    String descreption

) {  
}
