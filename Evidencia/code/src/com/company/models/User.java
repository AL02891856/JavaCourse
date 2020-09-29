package com.company.models;

import com.company.util.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class User extends AbstractPerson {
    String username;
    String password;
    private HashMap<String, String> users = new HashMap<>();
    private BufferedReader bufferedReader;


    public User(int id, String name, String username, String password) {
        super(id, name);
        this.username = username;
        this.password = password;
    }

    public User() { }

    public boolean userExits(String username, String password) {
        if(!users.containsKey(username))
            return false;
        else if (users.get(username).equals(password))
            return true;
        else
            return false;
    }

    public void load() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(Constants.DATABASE_PATH + "user.txt"));

        String line;
        while((line = bufferedReader.readLine()) != null) {
            if(!line.contains(","))
                continue;

            String[] values = line.split(",");
            users.put(values[0], values[1]);
        }

        bufferedReader.close();
    }
}
