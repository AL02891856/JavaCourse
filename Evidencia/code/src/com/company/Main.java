package com.company;

import com.company.models.Auth;
import com.company.models.User;
import com.company.util.Constants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            Auth auth;
            String username;
            String password;

            init();
            do {
                System.out.println("Ingresar usuario: " );
                username = s.nextLine();
                System.out.println("Ingresar password: ");
                password = s.nextLine();
                auth = new Auth(username, password);
            } while(!auth.userExists());

        } catch (IOException ex) {
            System.out.println("Error: Hubo un problema al crear la base de datos." +
                    " Favor de contactar a su administrador");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    private static void createUser() throws IOException {
        BufferedWriter bufferedWriter;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("admin,root123");
        stringBuilder.append(System.getProperty("line.separator"));

        bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\db\\user.txt"));
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
    }

    private static void init() throws Exception {
        String[] tables = new String[] {"user.txt","patient.txt","doctor.txt", "appointment.txt"};

        for (String table:tables) {
            File file = new File(Constants.DATABASE_PATH + table);

            if(!file.exists()) {
                file.createNewFile();
            }
        }
        createUser();
    }
}
