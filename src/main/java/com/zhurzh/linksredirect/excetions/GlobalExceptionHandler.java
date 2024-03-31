package com.zhurzh.linksredirect.excetions;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.NoSuchElementException;

@RestControllerAdvice
@Log4j
public class GlobalExceptionHandler {
    @Value("${domain.redirect}")
    private String urlNotFound;
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        var list = Arrays.stream(e.getStackTrace()).toList();
        log.error(e.getMessage());
        log.error(list);
        return new ResponseEntity<>(
                "An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public RedirectView handleNoSuchElementException(Exception e) {
        log.info(e.getMessage());
        return new RedirectView(urlNotFound);
    }
}
