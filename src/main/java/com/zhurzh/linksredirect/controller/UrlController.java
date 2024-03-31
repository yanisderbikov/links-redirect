package com.zhurzh.linksredirect.controller;
import com.zhurzh.linksredirect.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UrlController {
    @Autowired
    private UrlService urlService;

    @GetMapping("/{id}")
    public String redirect(@PathVariable("id") String id) {
        String url = urlService.getUrlAndCountClick(id);
        return "redirect:"+url;
    }

    @GetMapping
    public String redirect() {
        return "redirect:" + "https://www.furaffinity.net/user/zhurzh/";
    }
}

