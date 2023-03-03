package com.skypro.library.service;


import com.skypro.library.entity.Book;

import java.util.List;


public interface BookService {

    List<Book> getBooksService();

    Book getBookByIdService(Character isbn);

    void addBookService(Book book);

    void updateBookService(Book book);

    void deleteBookService(Character isbn);
}
