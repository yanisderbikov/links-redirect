package com.zhurzh.linksredirect.excetions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.view.RedirectView;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public RedirectView handleNoSuchElementException(Exception e) {
        return new RedirectView("https://www.furaffinity.net/user/zhurzh/");
    }
}
