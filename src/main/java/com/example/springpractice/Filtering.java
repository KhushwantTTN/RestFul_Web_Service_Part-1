package com.example.springpractice;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonFilter("userFilter")
public class Filtering {

    private String userName;
    @JsonIgnore
    private String password;

    public Filtering(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "StaticFiltering{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}


