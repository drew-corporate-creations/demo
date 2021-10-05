package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class BookController {

    //Does not work
    @Post("/doesNotWork1")
    public Map<String, String> doesNotWork(@Body String body) {
        System.out.println("Received request");

        System.out.println("Request body: " + body);

        return new HashMap<>();
    }

    //Does not work
    @Post("/doesNotWork2")
    public Map<String, String> doesNotWork(HttpRequest<String> request) {

        System.out.println("Received request");

        String body = request.getBody().get();

        System.out.println("Request body: " + body);

        return new HashMap<>();
    }

    @Post
    public BookSaved save(@Valid @Body Book book) {
        BookSaved bookSaved = new BookSaved();
        bookSaved.setName(book.getName());
        bookSaved.setIsbn(UUID.randomUUID().toString());
        return bookSaved;
    }
}
