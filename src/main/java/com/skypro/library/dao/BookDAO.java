package com.skypro.library.dao;

import com.skypro.library.entity.Book;

import java.util.List;

public interface BookDAO {

                        //1. Создание книги с помощью запроса INSERT
    void addEBookDAO(Book book);

                        //2. Изменение названия, автора или года издания книги с помощью одного запроса UPDATE который принимает все три параметра
    void updateBookDAO(Book book);

                                    //3. Удаление книги по ISBN
        void deleteBookDAO(Character isbn);

                                //4. Получение всех книг
        List<Book> getBooksDAO();

                            //5. Получение одной книги по ISBN
    Book getBookByIdDAO(Character isbn);




}
