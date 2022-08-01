package services;

import com.example.obrestdatajpa.models.Book;

public class BookPriceCalculator {

    private final Integer  MAXPAGINAS = 300;
    private final Double PRECIOENVIO = 2.99;
    public double calculatePrive(Book book){
        double price = book.getPrice();
        return (book.getPages() > MAXPAGINAS) ? price+=5+PRECIOENVIO : price+PRECIOENVIO;
    }
}
