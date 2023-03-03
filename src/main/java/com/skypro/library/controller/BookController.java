package com.skypro.library.controller;

import com.skypro.library.entity.Books;
import com.skypro.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {

    private BookService bookService;

    public BookController() {
    }

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")                    //4. Получение всех книг
    public List<Books> getBooksController() {
        return bookService.getBooksService();
    }

    @GetMapping("/book/{isbn}")                //5. Получение одной книги по ISBN
    public Books getBookByIsbnController(@PathVariable Character isbn){
        return bookService.getBookByIsbnService(isbn);
    }

    @PostMapping("/book")                   //1. Создание книги с помощью запроса INSERT
    public Books addBookController(@RequestBody Books book) {
        bookService.addEBookService(book);
        return book;
    }

    @PutMapping("/book")                    //2. Изменение названия, автора или года издания книги с помощью одного запроса UPDATE который принимает все три параметра
    public Books updateBookController(@RequestBody Books book) {
        bookService.updateBookService(book);
        return book;
    }

    @DeleteMapping("/book/{isbn}")                  //3. Удаление книги по ISBN
    public String deleteBookController(@PathVariable Character isbn) {
        bookService.deleteBookService(isbn);
        return "Person with id = " + isbn + " was deleted";
    }


}
