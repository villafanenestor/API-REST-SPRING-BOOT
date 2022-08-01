package com.example.obrestdatajpa.models;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "libros")
@Schema(name = "CLase BOok", description = "Clase Book", title = "Libro")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Integer pages;
    private Double price;
    private LocalDate releaseDate;
    private boolean online;

    public Book() {
    }

    public Book(Long id, String title, String author, Integer pages, Double price, LocalDate releaseDate, boolean online) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.releaseDate = releaseDate;
        this.online = online;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }


    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", online=" + online +
                '}';
    }
}
