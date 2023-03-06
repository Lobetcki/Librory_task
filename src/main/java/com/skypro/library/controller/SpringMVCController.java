package com.skypro.library.controller;

import com.skypro.library.service.BookService;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("library")
//@EnableWebSecurity
public class SpringMVCController {

    private BookService bookService;

    public SpringMVCController(BookService bookService) {
        this.bookService = bookService;
    }

    // Создаем метод, который только возвращает название отображения,
    // которое мы создадим далее
    // А срабатывать этот метод будет, когда URL будет содержать "/web"
    @RequestMapping("/web")
    public String getAllBookS(Model model) {
        model.addAttribute("books", bookService.getBooksService());
        return "dashboard";

    }

}
