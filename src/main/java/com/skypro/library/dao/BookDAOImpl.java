package com.skypro.library.dao;

import com.skypro.library.entity.Books;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private final JdbcTemplate jdbcTemplate;

    public BookDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override               // 1. Создание книги с помощью запроса INSERT
    public void addEBookDAO(Books book) {
        jdbcTemplate.update("INSERT INTO books VALUES (?, ?, ?, ?)",
                book.getIsbn(), book.getNameBook(), book.getAuthorBbook(), book.getYearPublicationBook());
    }

    @Override               //2. Изменение названия, автора или года издания книги с помощью одного запроса UPDATE который принимает все три параметра
    public void updateBookDAO(Books book) {
        jdbcTemplate.update("UPDATE books SET name_book=?, author_book=?, year_publication_book=? WHERE isbn=?",
                book.getNameBook(), book.getAuthorBbook(), book.getYearPublicationBook());

    }

    @Override                               //3. Удаление книги по ISBN
    public void deleteBookDAO(Character isbn) {
        jdbcTemplate.execute("delete from books where isbn=:isbn");
    }

    @Override                                   //4. Получение всех книг
    public List<Books> getBooksDAO() {
        return jdbcTemplate.query("SELECT * FROM books", new BeanPropertyRowMapper<>(Books.class));
    }

    @Override                                   //5. Получение одной книги по ISBN
    public Books getBookByIsbnDAO(Character isbn) {
        return jdbcTemplate.query("SELECT * FROM books WHERE isbn=?",
                new Object[]{isbn},
                new BeanPropertyRowMapper<>(Books.class)).stream().findAny().orElse(null);
    }
}
