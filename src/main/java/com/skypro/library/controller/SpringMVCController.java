package com.skypro.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("library")
public class SpringMVCController {

    // Создаем метод, который только возвращает название отображения,
    // которое мы создадим далее
    // А срабатывать этот метод будет, когда URL будет содержать "/skypro/1"
    @RequestMapping("/web")
    public String getAllBookS() {

        return "library.dashboard";
    }

}
