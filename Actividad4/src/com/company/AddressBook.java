package com.company;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.io.*;
import java.util.HashMap;

public class AddressBook {
    private String fileName = "src/com/company/contacts.txt";
    private HashMap<String, String> contacts;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public AddressBook() throws IOException {
        contacts = new HashMap<>();
        load();
    }

    public void load() throws IOException {
          bufferedReader = new BufferedReader(new FileReader(fileName));

          String line;
          while((line = bufferedReader.readLine()) != null) {
              if(!line.contains(","))
                continue;

              String[] values = line.split(",");
              contacts.put(values[0], values[1]);
          }

          bufferedReader.close();
    }

    public void save() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        contacts.forEach((k,v) -> {
            stringBuilder.append(k + "," + v);
            stringBuilder.append(System.getProperty("line.separator"));
        });

        bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
    }

    public void list() {
        System.out.println("Contactos: ");
        contacts.forEach((k,v) -> {
            System.out.println(k + ":" + v);
        });
    }

    public void create(String key, String value) {
        if(contacts.containsKey(key)) {
            System.out.println("Telefono ya existe...");
            return;
        }

        contacts.put(key, value);
    }

    public void delete(String key) {
        if(contacts.containsKey(key)) {
            contacts.remove(key);
            System.out.println("Contacto eliminado: "  + key);
        } else {
            System.out.println("El contacto no existe");
        }

    }
}
