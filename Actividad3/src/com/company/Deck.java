package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
    List<Card> deck = new ArrayList<>();

    public Deck() {
        InitializeDeck();
    }

    private void InitializeDeck() {
        for (SuitsEnum s : SuitsEnum.values()) {
            String color = s.name().equals("CLUBS") || s.name().equals("SPADES")
                    ? "BLACK"
                    : "RED";

            for (int i = 2; i<=10; i++) {
                Card card = new Card((String.valueOf(i)), color, s.name());
                deck.add(card);
            }

            for(int i = 0; i<=3; i++) {
                Card card = new Card(RankEnum.values()[i].name(), color, s.name());
                deck.add(card);
            }
        }
    }

    public void Shuffle() {
        Collections.shuffle(deck);
    }

    public String Head() {
        Card head = deck.get(0);
        deck.remove(0);
        return head.toString();
    }

    public String Pick() {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 52 + 1);
        Card pick = deck.get(randomNumber);
        deck.remove(randomNumber);
        return pick.toString();
    }

    public String Hand() {
        String hand = "";
        if(deck.size() >= 5) {
            for (int i = 0; i <= 4; i++) {
                hand += deck.get(0).toString() + "\n";
                deck.remove(0);
            }
        } else {
            return "No hay suficientes cartas en el deck para la mano";
        }
        return hand;
    }
}
