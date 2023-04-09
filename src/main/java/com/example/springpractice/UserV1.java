package com.example.springpractice;

import org.springframework.stereotype.Component;


public class UserV1 {
    private String firstName;

    public UserV1(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "UserV1{" +
                "firstName='" + firstName + '\'' +
                '}';
    }
}
