package com.skypro.library.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.skypro.library.entity.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.*;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private final ComboPooledDataSource dataSource;

    public BookDAOImpl(ComboPooledDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override                               // 1. Создание книги с помощью запроса INSERT
    public void addEBookDAO(Book book) {

    }

    @Override                   //2. Изменение названия, автора или года издания книги с помощью одного запроса UPDATE который принимает все три параметра
    public void updateBookDAO(Book book) {

    }

    @Override                                //3. Удаление книги по ISBN
    public void deleteBookDAO(Character isbn) {

    }

    @Override                                   //4. Получение всех книг
    public List<Book> getBooksDAO() {
        return null;
    }

    @Override                                   //5. Получение одной книги по ISBN
    public Book getBookByIdDAO(Character isbn) {
        return null;
    }

//    @Override                               // 1. Создание книги с помощью запроса INSERT
//    public void addEBookDAO(Book book) {
//        dataSource.createQuery("");
//        Book newBook = dataSource.merge(book);
//        book.setIsbn(newBook.getIsbn());
//    }
//
//    @Override                               //2. Изменение названия, автора или года издания книги с помощью одного запроса UPDATE который принимает все три параметра
//    public void updateBookDAO(Book book) {
//        entityManager.merge(book);
//    }
//
//    @Override                                //3. Удаление книги по ISBN
//    public void deleteBookDAO(Character isbn) {
//        Query query = entityManager.createQuery("delete from Book where isbn=:isbn");
//        query.setParameter("isbn", isbn);
//        query.executeUpdate();
//    }
//
//    @Override                                   //4. Получение всех книг
//    public List<Book> getBooksDAO() {
//        return entityManager.createQuery("FROM Book").getResultList();
//    }
//
//    @Override                                   //5. Получение одной книги по ISBN
//    public Book getBookByIdDAO(Character id) {
//        return entityManager.find(Book.class, id);
//    }
//





}
