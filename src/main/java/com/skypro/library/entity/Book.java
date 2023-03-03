package com.skypro.library.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")

public class Book {

    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "isbn")
    private Character isbn;

    @Column(name = "name_book")
    private String nameBook;

    @Column(name = "author_book")
    private String authorBbook;

    @Column(name = "year_publication_booksalary")
    private int yearPublicationBook;


    public Book() {
    }

    public Book(Character isbn, String nameBook, String authorBbook, int yearPublicationBook) {
        this.isbn = isbn;
        this.nameBook = nameBook;
        this.authorBbook = authorBbook;
        this.yearPublicationBook = yearPublicationBook;
    }

    public Character getIsbn() {
        return isbn;
    }

    public void setIsbn(Character isbn) {
        this.isbn = isbn;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthorBbook() {
        return authorBbook;
    }

    public void setAuthorBbook(String authorBbook) {
        this.authorBbook = authorBbook;
    }

    public int getYearPublicationBook() {
        return yearPublicationBook;
    }

    public void setYearPublicationBook(int yearPublicationBook) {
        this.yearPublicationBook = yearPublicationBook;
    }
}
