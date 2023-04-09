package com.example.springpractice;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
@RestController
public class Internationalization {

    public MessageSource messageSource;

    public Internationalization(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello/{name}")
    public String greet(@PathVariable String name) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.message",new Object[]{name},"hello",locale);
    }

}
