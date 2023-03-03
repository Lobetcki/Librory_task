package com.skypro.library.service;

import com.skypro.library.entity.Books;

import java.awt.print.Book;
import java.util.List;

public interface BookService {

    //1. Создание книги с помощью запроса INSERT
    void addEBookService(Books book);

    //2. Изменение названия, автора или года издания книги с помощью одного запроса UPDATE который принимает все три параметра
    void updateBookService(Books book);

    //3. Удаление книги по ISBN
    void deleteBookService(Character isbn);

    //4. Получение всех книг
    List<Books> getBooksService();

    //5. Получение одной книги по ISBN
    Books getBookByIsbnService(Character isbn);

}
