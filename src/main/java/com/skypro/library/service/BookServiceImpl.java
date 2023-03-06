package com.skypro.library.service;

import com.skypro.library.dao.BookDAO;
import com.skypro.library.entity.Books;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.skypro.library.exceptions.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

//    public BookServiceImpl() {
//    }

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
            throw new BookException("Person with id = " + isbn + " равен null");
        }
        if (!(validateIsbn(isbn))) {
            throw new BookException("Person with id = " + isbn + " нет Валидности");
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
        return book;
    }
                                                            // Валидация ISBN
    private boolean validateIsbn(String isbn) {
        Books book = getBookByIsbnService(isbn);
        if (book.getNameBook() == null || book.getAuthorBook() == null ||
        book.getIsbn() == null || book.getYearPublicationBook() < 0) {
            throw new BookException("Not all fields of the book are filled in");
        }

        String intIsbn = isbn.replaceAll("-", "");

        if (intIsbn.length() != 13 || !intIsbn.matches("[0-9]+")) {
            throw new BookException("ISBN введен неверно");
        }
        String[] arr = intIsbn.split("");
        int sum = 0;
        int num = 0;
        for (int i = 0; i < 12; i++) {

            if (!(i % 2 == 0)) {
                sum += Integer.parseInt(arr[i]) * 3;
            } else {
                sum += Integer.parseInt(arr[i]);
            }
        }
        if (sum % 10 == 0) {

        }
        num = 10 - sum % 10;
        return num == Integer.parseInt(arr[12]);
    }
}
