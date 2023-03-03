package com.skypro.library.service;

import com.skypro.library.entity.Book;
import com.skypro.library.dao.BookDAO;
import org.springframework.stereotype.Service;
import com.skypro.library.exceptions.BookException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public List<Book> getBooksService() {
        return bookDAO.getBooksDAO();
    }

    @Override
    @Transactional
    public Book getBookByIdService(Character isbn) {
        Book book = bookDAO.getBookByIdDAO(isbn);
        if (book == null) {
        throw new BookException("Person with id = " + isbn + " doesn't exist");
            }
        return book;
    }

    @Override
    @Transactional
    public void addBookService(Book book) {
        bookDAO.addEBookDAO(book);
    }

    @Override
    @Transactional
    public void updateBookService(Book book) {
        bookDAO.updateBookDAO(book);
    }

    @Override
    @Transactional
    public void deleteBookService(Character id) {
        Book book = bookDAO.getBookByIdDAO(id);
        if (book == null) {
            throw new BookException("Person with id = " + id + " doesn't exist");
        }

        bookDAO.deleteBookDAO(id);
    }
}
