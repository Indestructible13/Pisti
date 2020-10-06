package package1;

import java.util.ArrayList;

public class Pile {
    public static ArrayList<Card> cardsOnPile = new ArrayList<>();

    public Pile() {
    }

    public static void addCardToPile(int num) {
        cardsOnPile.add(Deck.randomDeck.get(num)); }

    public static void printPile() {
        for (int i = 0; i < cardsOnPile.size(); i++) {
            System.out.println(cardsOnPile.get(i).toString()); }}}
