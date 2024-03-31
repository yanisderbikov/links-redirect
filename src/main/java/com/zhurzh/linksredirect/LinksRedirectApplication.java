package com.zhurzh.linksredirect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.zhurzh.linksredirect.repo")
public class LinksRedirectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinksRedirectApplication.class, args);
    }

}
