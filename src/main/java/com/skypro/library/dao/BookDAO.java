package com.skypro.library.dao;

import com.skypro.library.entity.Books;

import java.util.List;


public interface BookDAO {

    //1. Создание книги с помощью запроса INSERT
    void addBookDAO(Books book);

    //2. Изменение названия, автора или года издания книги с помощью одного запроса UPDATE который принимает все три параметра
    void updateBookDAO(Books book);

    //3. Удаление книги по ISBN
    void deleteBookDAO(String isbn);

    //4. Получение всех книг
    List<Books> getBooksDAO();

    //5. Получение одной книги по ISBN
    Books getBookByIsbnDAO(String isbn);


}
