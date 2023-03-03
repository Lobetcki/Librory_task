package com.skypro.library.entity;

import java.util.Objects;

public class Books {

    private String isbn;

    private String nameBook;

    private String authorBook;

    private Integer yearPublicationBook;

    public Books() {
    }

    public Books(String isbn, String nameBook, String authorBook, int yearPublicationBook) {
        this.isbn = isbn;
        this.nameBook = nameBook;
        this.authorBook = authorBook;
        this.yearPublicationBook = yearPublicationBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
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
        return yearPublicationBook == book.yearPublicationBook && Objects.equals(isbn, book.isbn) && Objects.equals(nameBook, book.nameBook) && Objects.equals(authorBook, book.authorBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, nameBook, authorBook, yearPublicationBook);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", nameBook='" + nameBook + '\'' +
                ", authorBbook='" + authorBook + '\'' +
                ", yearPublicationBook=" + yearPublicationBook +
                '}';
    }
}
