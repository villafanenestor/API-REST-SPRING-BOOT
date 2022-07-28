package com.example.obrestdatajpa.controllers;

import com.example.obrestdatajpa.models.Book;
import com.example.obrestdatajpa.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private Logger log= LoggerFactory.getLogger(BookController.class);
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
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders httpHeaders){
        System.out.println(httpHeaders.get("User-Agent"));
        if(book.getId() !=null){
            log.warn("Se envio el ID, en en la funcion de crear.");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        //Book bookTemp = bookRepository.findBy(book.getId());
        if(book.getId() == null){
            log.warn("El id esta nulo.");
            return ResponseEntity.badRequest().build();
        }
        if(!bookRepository.existsById(book.getId()) ){
            log.warn("El id enviado no existe");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        if(!bookRepository.existsById(id)){
            log.warn("The id no existe");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){
        if(bookRepository.count()<=0){
            log.warn("Not exist Books");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteAll();
        log.info("Rest request for delete all Books");
        return ResponseEntity.ok().build();
    }
}
