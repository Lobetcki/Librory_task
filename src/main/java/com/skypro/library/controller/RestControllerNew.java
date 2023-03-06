package com.skypro.library.controller;

import com.skypro.library.entity.Books;
import com.skypro.library.service.BookService;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library")
//@EnableWebSecurity
class RestControllerNew {

    private BookService bookService;

//    public RestControllerNew() {
//    }

    public RestControllerNew(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/book")                    //4. Получение всех книг
    public List<Books> getBooks() {
        return bookService.getBooksService();
    }

    @GetMapping("/api/book/{isbn}")                //5. Получение одной книги по ISBN
    public Books getBookByIsbnController(@PathVariable String isbn){
        return bookService.getBookByIsbnService(isbn);
    }

    @PostMapping("/api/book")                   //1. Создание книги с помощью запроса INSERT
    public Books addBookController(@RequestBody Books book) {
        bookService.addBookService(book);
        return book;
    }

    @PutMapping("/api/book")                    //2. Изменение названия, автора или года издания книги с помощью одного запроса UPDATE который принимает все три параметра
    public Books updateBookController(@RequestBody Books book) {
        bookService.updateBookService(book);
        return book;
    }

    @DeleteMapping("/api/book")                  //3. Удаление книги по ISBN
    public String deleteBookController(@RequestParam String isbn) {
        bookService.deleteBookService(isbn);
        return "Person with id = " + isbn + " was deleted";
    }


}
