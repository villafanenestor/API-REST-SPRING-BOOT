package com.example.obrestdatajpa.controllers;

import com.example.obrestdatajpa.models.Book;
import com.example.obrestdatajpa.repositories.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private String entityName = "boosks";
    BookRepository bookRepository;



    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping("/api/books")
    public List<Book> findAll(){
        return this.bookRepository.findAll();
    }

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable long id){
        Optional<Book> bookOptional = this.bookRepository.findById(id);
        if(bookOptional.isPresent()){
            return ResponseEntity.ok(bookOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }

        //return bookOptional.orElse(null);
    }

    @PostMapping("/api/books")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders httpHeaders){
        System.out.println(httpHeaders.get("User-Agent"));
        return bookRepository.save(book);
    }
}
