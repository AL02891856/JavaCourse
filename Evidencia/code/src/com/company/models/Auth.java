package com.company.models;

import java.io.IOException;

public class Auth {
    String username;
    String password;

    public Auth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean userExists() throws IOException {
        User users = new User();
        users.load();
        return users.userExits(username, password);
    }
}
