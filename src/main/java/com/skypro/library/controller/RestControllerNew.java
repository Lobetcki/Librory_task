package com.skypro.library.controller;

import com.skypro.library.entity.Book;
import org.springframework.web.bind.annotation.*;
import com.skypro.library.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/library")
public class RestControllerNew {

    private BookService bookService;

    public RestControllerNew(BookService bookService) {
        this.bookService = bookService;
    }

//    GET /web - Показываем страницу со списком книг любому пользователю

    @GetMapping("/api/book")         //    GET /api/book - получаем все книги в виде JSON массива
    public List<Book> getBooksController() {
        return bookService.getBooksService();
    }

    @GetMapping("/Book/{isbn}")
    public Book getBookByIdController(@PathVariable Character isbn){
        return bookService.getBookByIdService(isbn);
    }

    @PostMapping("/api/book")               //    POST /api/book - создаем книгу передавай JSON в теле запроса
    public Book addBookController(@RequestBody Book Book) {
        bookService.addBookService(Book);
        return Book;
    }

    @PutMapping("/api/book")                //    PUT /api/book - редактируем книгу передавай JSON в теле запроса
    public Book updateBookController(@RequestBody Book Book) {
        bookService.updateBookService(Book);
        return Book;
    }

    @DeleteMapping("/api/book?isbn=<isbn>")        //    DELETE /api/book?isbn=<isbn> - удаляем книгу по isbn
    public String deleteBookController(@PathVariable Character isbn) {
        bookService.deleteBookService(isbn);
        return "Person with id = " + isbn + " was deleted";
    }

}
