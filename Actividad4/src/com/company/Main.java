package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;
        try {
            AddressBook addressBook = new AddressBook();
            Scanner s = new Scanner(System.in);

            while(!exit){
                System.out.println("Bienvenidos, favor de seleccionar una opcion: \n" +
                        "1) Save\n" +
                        "2) List\n" +
                        "3) Create\n" +
                        "4) Delete\n" +
                        "5) Exit");
                String option = s.nextLine();

                switch (option) {
                    case "1":
                        addressBook.save();
                        System.out.println("Se guardo el archivo");
                        break;
                    case "2":
                        addressBook.list();
                        break;
                    case "3":
                        System.out.println("Inserte el numero telefonico:");
                        String key = s.nextLine();
                        System.out.println("Inserte el nombbre del contacto:");
                        String value = s.nextLine();
                        addressBook.create(key, value);
                        break;
                    case "4":
                        System.out.println("Inserte el numero telefonico:");
                        addressBook.delete(s.nextLine());
                        break;
                    case "5":
                        exit = true;
                        break;
                    default:
                        System.out.println("Opcion incorrecta, intente de nuevo...");
                        break;
                }
            }
        } catch(Exception ex) {

        }
    }
}
