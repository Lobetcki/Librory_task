package com.skypro.library.entity;

import javax.persistence.*;
import java.util.Objects;

public class Books {

    private Character isbn;

    private String nameBook;

    private String authorBbook;

    private int yearPublicationBook;

    public Books() {
    }

    public Books(Character isbn, String nameBook, String authorBbook, int yearPublicationBook) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books book = (Books) o;
        return yearPublicationBook == book.yearPublicationBook && Objects.equals(isbn, book.isbn) && Objects.equals(nameBook, book.nameBook) && Objects.equals(authorBbook, book.authorBbook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, nameBook, authorBbook, yearPublicationBook);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", nameBook='" + nameBook + '\'' +
                ", authorBbook='" + authorBbook + '\'' +
                ", yearPublicationBook=" + yearPublicationBook +
                '}';
    }
}
