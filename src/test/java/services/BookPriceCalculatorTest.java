package services;

import com.example.obrestdatajpa.models.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Book Price TEST")
class BookPriceCalculatorTest {

    @Test
    void calculatePriveTest() {
        Book book = new Book();
        book.setId(1L);
        book.setPages(600);
        book.setPrice(5.0);
        BookPriceCalculator bookPriceCalculator = new BookPriceCalculator();
        //Comportamiento
        double price = bookPriceCalculator.calculatePrive(book);
        //Comprobacion de la prueba
        //System.out.println("Precio: "+price);
        //assertTrue(price>0);
        assertTrue(price==12.99);

    }
}