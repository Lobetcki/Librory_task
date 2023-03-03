package com.skypro.library.controller;

import com.skypro.library.entity.Books;
import com.skypro.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/library")
class RestController {

    private BookService bookService;

    public RestController() {
    }

    public RestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/web")                    //4. Получение всех книг
    public List<Books> getBooksController() {
        return bookService.getBooksService();
    }

    @GetMapping("/api/book/{isbn}")                //5. Получение одной книги по ISBN
    public Books getBookByIsbnController(@PathVariable Character isbn){
        return bookService.getBookByIsbnService(isbn);
    }

    @PostMapping("/api/book")                   //1. Создание книги с помощью запроса INSERT
    public Books addBookController(@RequestBody Books book) {
        bookService.addEBookService(book);
        return book;
    }

    @PutMapping("/api/book")                    //2. Изменение названия, автора или года издания книги с помощью одного запроса UPDATE который принимает все три параметра
    public Books updateBookController(@RequestBody Books book) {
        bookService.updateBookService(book);
        return book;
    }

    @DeleteMapping("/api/book?isbn=<isbn>")                  //3. Удаление книги по ISBN
    public String deleteBookController(@PathVariable Character isbn) {
        bookService.deleteBookService(isbn);
        return "Person with id = " + isbn + " was deleted";
    }


}
