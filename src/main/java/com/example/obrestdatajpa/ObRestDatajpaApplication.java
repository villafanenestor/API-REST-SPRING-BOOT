package com.example.obrestdatajpa;

import com.example.obrestdatajpa.models.Book;
import com.example.obrestdatajpa.repositories.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);
		//Crear Libro
		Book book = new Book(null, "Home Deus", "Nestor Villafañe", 450, 29.99, LocalDate.of(2022, 07,23), true);
		Book book1 = new Book(null, "Homo Sampiens", "Andrea Scaldaferro", 40, 1.99, LocalDate.of(1990, 1,1), true);

		//Almacenar Libro

		bookRepository.save(book);
		bookRepository.save(book1);

		//Recuperar todos los libros

		System.out.println(bookRepository.count());
		System.out.println(bookRepository.findAll().toString());
		//Borrar un libro

		//bookRepository.deleteById(1L);



	}

}
