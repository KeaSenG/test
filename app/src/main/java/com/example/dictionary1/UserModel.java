package com.example.dictionary1;

import java.io.Serializable;

public class UserModel implements Serializable {

    private String username;

    public UserModel(String username) {
        this.username=username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }
}
