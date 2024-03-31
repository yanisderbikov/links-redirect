package com.zhurzh.linksredirect.controller;
import com.zhurzh.linksredirect.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UrlController {
    @Autowired
    private UrlService urlService;

    @GetMapping("/{id}")
    public RedirectView redirect(@PathVariable("id") String id) {
        String url = urlService.getUrlAndCountClick(id);
        return new RedirectView(url);
    }
}

