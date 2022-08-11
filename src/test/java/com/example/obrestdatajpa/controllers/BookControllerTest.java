package com.example.obrestdatajpa.controllers;

import com.example.obrestdatajpa.models.Book;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp(){
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);

    }

    @Test
    void hello() {
        //TODO: Terminar prueba
        ResponseEntity<String> response = testRestTemplate.getForEntity("/hola", String.class);
        System.out.println(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    void findAll() {
        //TODO: Terminar prueba
        ResponseEntity<Book[]> response = testRestTemplate.getForEntity("/api/books", Book[].class);
        assertEquals(200, response.getStatusCodeValue());
        System.out.println(response.getBody());
        List<Book> books = Arrays.asList(response.getBody());
        System.out.println("Tamano:" + books.size());
        assertTrue(response.getStatusCodeValue()==200);
        //assertTrue(books.size()>1);
    }

    @Test
    void findById() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/api/books/1", String.class);
        System.out.println(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void create() {
    }
}