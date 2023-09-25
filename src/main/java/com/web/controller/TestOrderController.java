package com.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
@Slf4j
//5. Реалізувати контролер Ping для перевірки того, що програма працює. Цей контролер має лише один спосіб і повертає повідомлення “ОК”.
//5.1 Контролер доступний за URL: http://localhost:8080/ping
public class TestOrderController {
    private static final String CALL_ENDPOINT = "call endpoint : %s ";
    @GetMapping("/ping")
    public String ping() {
        log.info(String.format(CALL_ENDPOINT, "ping"));
        return "OK";
    }
}
