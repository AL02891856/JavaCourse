package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;
        Deck deck = new Deck();
        Scanner s = new Scanner(System.in);

        while(!exit){
            System.out.println("Bienvenidos, favor de seleccionar una opcion: \n" +
                    "1) Shuffle\n" +
                    "2) Head\n" +
                    "3) Pick\n" +
                    "4) Hand\n" +
                    "5) Exit");
            String option = s.nextLine();

            switch (option) {
                case "1":
                    deck.Shuffle();
                    System.out.println("Se mezclo el deck...");
                    break;
                case "2":
                    System.out.println(deck.Head());
                    System.out.println("Quedan " + deck.deck.size());
                    break;
                case "3":
                    System.out.println(deck.Pick());
                    System.out.println("Quedan " + deck.deck.size());
                    break;
                case "4":
                    System.out.println(deck.Hand());
                    System.out.println("Quedan " + deck.deck.size());
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion incorrecta, intente de nuevo...");
                    break;
            }
        }

    }
}
