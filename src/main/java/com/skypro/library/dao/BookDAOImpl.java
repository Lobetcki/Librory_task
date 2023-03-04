package com.skypro.library.dao;

import com.skypro.library.entity.Books;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    };

    public BookDAOImpl(@Lazy JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override               // 1. Создание книги с помощью запроса INSERT
    public void addBookDAO(Books book) {
        jdbcTemplate.update("INSERT INTO library.public.books VALUES (?, ?, ?, ?)",
                book.getNameBook(), book.getAuthorBook(), book.getYearPublicationBook(), book.getIsbn());
    }

    @Override               //2. Изменение названия, автора или года издания книги с помощью одного запроса UPDATE который принимает все три параметра
    public void updateBookDAO(Books book) {
        jdbcTemplate.update("UPDATE library.public.books SET name_book=?, author_book=?, year_publication_book=? WHERE isbn=?",
                book.getNameBook(), book.getAuthorBook(), book.getYearPublicationBook());

    }

    @Override                               //3. Удаление книги по ISBN
    public void deleteBookDAO(String isbn) {
        jdbcTemplate.execute("delete from library.public.books where isbn=:isbn");
    }

    @Override                                   //4. Получение всех книг
    public List<Books> getBooksDAO() {
        return jdbcTemplate.query("SELECT * FROM library.public.books", new BeanPropertyRowMapper<>(Books.class));
    }

    @Override                                   //5. Получение одной книги по ISBN
    public Books getBookByIsbnDAO(String isbn) {
        return jdbcTemplate.query("SELECT * FROM library.public.books WHERE isbn=?",
                new Object[]{isbn},
                new BeanPropertyRowMapper<>(Books.class)).stream().findAny().orElse(null);
    }
}
