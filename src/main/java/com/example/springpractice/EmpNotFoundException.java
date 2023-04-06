package com.example.springpractice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmpNotFoundException extends RuntimeException {
    public EmpNotFoundException(String s) {
        super(s);
    }
}
