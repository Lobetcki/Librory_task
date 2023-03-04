package com.skypro.library.service;

import com.skypro.library.dao.BookDAO;
import com.skypro.library.entity.Books;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.skypro.library.exceptions.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    public BookServiceImpl() {
    }

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional                                  //1. Создание книги с помощью запроса INSERT
    public void addBookService(Books book) {
        bookDAO.addBookDAO(book);

    }

    @Override
    @Transactional                                              //2. Изменение названия, автора или года издания книги с помощью одного запроса UPDATE который принимает все три параметра
    public void updateBookService(Books book) {
        bookDAO.updateBookDAO(book);
    }

    @Override
    @Transactional                                                    //3. Удаление книги по ISBN
    public void deleteBookService(String isbn) {
        Books book = bookDAO.getBookByIsbnDAO(isbn);
        if (book == null) {
            throw new BookException("Person with id = " + isbn + " doesn't exist");
        }

        bookDAO.deleteBookDAO(isbn);
    }

    @Override
    @Transactional                                //4. Получение всех книг
    public List<Books> getBooksService() {
        return bookDAO.getBooksDAO();
    }

    @Override
    @Transactional                              //5. Получение одной книги по ISBN
    public Books getBookByIsbnService(String isbn) {
        Books book = bookDAO.getBookByIsbnDAO(isbn);
        if (book == null) {
            throw new BookException("Person with isbn = " + isbn + " doesn't exist");
        }
        return book;
    }
}
