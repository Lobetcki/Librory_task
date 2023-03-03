package com.skypro.library.service;

import com.skypro.library.dao.BookDAO;
import com.skypro.library.entity.Books;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    public BookServiceImpl() {
    }

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override                   //1. Создание книги с помощью запроса INSERT
    public void addEBookService(Books book) {
        book.setIsbn(null);
        bookDAO.addEBookDAO(book);

    }

    @Override               //2. Изменение названия, автора или года издания книги с помощью одного запроса UPDATE который принимает все три параметра
    public void updateBookService(Books book) {
        bookDAO.updateBookDAO(book);
    }

    @Override                           //3. Удаление книги по ISBN
    public void deleteBookService(Character isbn) {
        Books book = bookDAO.getBookByIsbnDAO(isbn);
//        if (book == null) {
//            throw new BookException("Person with id = " + id + " doesn't exist");
//        }

        bookDAO.deleteBookDAO(isbn);
    }

    @Override                       //4. Получение всех книг
    public List<Books> getBooksService() {
        return bookDAO.getBooksDAO();
    }

    @Override                          //5. Получение одной книги по ISBN
    public Books getBookByIsbnService(Character isbn) {
        Books book = bookDAO.getBookByIsbnDAO(isbn);
//        if (book == null) {
//            throw new BookException("Person with id = " + id + " doesn't exist");
//        }
        return book;
    }
}
