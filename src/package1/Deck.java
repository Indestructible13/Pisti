package package1;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Deck {
    private static ArrayList<Card> deck = new ArrayList<>();
    public static ArrayList<Card> randomDeck = new ArrayList<>();

    public Deck() {}

    static {
        deck.add(new Card("Ace of Clubs", 1, 0));
        deck.add(new Card("Two of Clubs", 2, 0));
        deck.add(new Card("Three of Clubs", 3, 0));
        deck.add(new Card("Four of Clubs", 4, 0));
        deck.add(new Card("Five of Clubs", 5, 0));
        deck.add(new Card("Six of Clubs", 6, 0));
        deck.add(new Card("Seven of Clubs", 7, 0));
        deck.add(new Card("Eight of Clubs", 8, 0));
        deck.add(new Card("Nine of Clubs", 9, 0));
        deck.add(new Card("Ten of Clubs", 10, 0));
        deck.add(new Card("Jack of Clubs", 11, 0));
        deck.add(new Card("Queen of Clubs", 12, 0));
        deck.add(new Card("King of Clubs", 13, 0));
        deck.add(new Card("Ace of Diamonds", 1, 1));
        deck.add(new Card("Two of Diamonds", 2, 1));
        deck.add(new Card("Three of Diamonds", 3, 1));
        deck.add(new Card("Four of Diamonds", 4, 1));
        deck.add(new Card("Five of Diamonds", 5, 1));
        deck.add(new Card("Six of Diamonds", 6, 1));
        deck.add(new Card("Seven of Diamonds", 7, 1));
        deck.add(new Card("Eight of Diamonds", 8, 1));
        deck.add(new Card("Nine of Diamonds", 9, 1));
        deck.add(new Card("Ten of Diamonds", 10, 1));
        deck.add(new Card("Jack of Diamonds", 11, 1));
        deck.add(new Card("Queen of Diamonds", 12, 1));
        deck.add(new Card("King of Diamonds", 13, 1));
        deck.add(new Card("Ace of Hearts", 1, 2));
        deck.add(new Card("Two of Hearts", 2, 2));
        deck.add(new Card("Three of Hearts", 3, 2));
        deck.add(new Card("Four of Hearts", 4, 2));
        deck.add(new Card("Five of Hearts", 5, 2));
        deck.add(new Card("Six of Hearts", 6, 2));
        deck.add(new Card("Seven of Hearts", 7, 2));
        deck.add(new Card("Eight of Hearts", 8, 2));
        deck.add(new Card("Nine of Hearts", 9, 2));
        deck.add(new Card("Ten of Hearts", 10, 2));
        deck.add(new Card("Jack of Hearts", 11, 2));
        deck.add(new Card("Queen of Hearts", 12, 2));
        deck.add(new Card("King of Hearts", 13, 2));
        deck.add(new Card("Ace of Spades", 1, 3));
        deck.add(new Card("Two of Spades", 2, 3));
        deck.add(new Card("Three of Spades", 3, 3));
        deck.add(new Card("Four of Spades", 4, 3));
        deck.add(new Card("Five of Spades", 5, 3));
        deck.add(new Card("Six of Spades", 6, 3));
        deck.add(new Card("Seven of Spades", 7, 3));
        deck.add(new Card("Eight of Spades", 8, 3));
        deck.add(new Card("Nine of Spades", 9, 3));
        deck.add(new Card("Ten of Spades", 10, 3));
        deck.add(new Card("Jack of Spades", 11, 3));
        deck.add(new Card("Queen of Spades", 12, 3));
        deck.add(new Card("King of Spades", 13, 3)); }

    public static void printDeck() {
        for (int i = 0; i < 52; i++) {
            System.out.println(deck.get(i).toString()); } }

    public static void printRandomDeck() {
        for (int i = 0; i < 52; i++) {
            System.out.println(randomDeck.get(i).toString()); } }

    public static void randomizeDeck() {
        randomDeck.clear();
        int num = randomNumber();
        while (randomDeck.size() < 52) {
            if (!randomDeck.contains(deck.get(num))) {
                randomDeck.add(deck.get(num));
                num = randomNumber(); }
            else num = randomNumber(); }}

    private static int randomNumber() {
        return (int) (Math.random() * 52); }

    public static Card returnCard(String name) {
        switch (name) {
            case "Ace of Clubs": return deck.get(0);
            case "Two of Clubs": return deck.get(1);
            case "Three of Clubs": return deck.get(2);
            case "Four of Clubs": return deck.get(3);
            case "Five of Clubs": return deck.get(4);
            case "Six of Clubs": return deck.get(5);
            case "Seven of Clubs": return deck.get(6);
            case "Eight of Clubs": return deck.get(7);
            case "Nine of Clubs": return deck.get(8);
            case "Ten of Clubs": return deck.get(9);
            case "Jack of Clubs": return deck.get(10);
            case "Queen of Clubs": return deck.get(11);
            case "King of Clubs": return deck.get(12);
            case "Ace of Diamonds": return deck.get(13);
            case "Two of Diamonds": return deck.get(14);
            case "Three of Diamonds": return deck.get(15);
            case "Four of Diamonds": return deck.get(16);
            case "Five of Diamonds": return deck.get(17);
            case "Six of Diamonds": return deck.get(18);
            case "Seven of Diamonds": return deck.get(19);
            case "Eight of Diamonds": return deck.get(20);
            case "Nine of Diamonds": return deck.get(21);
            case "Ten of Diamonds": return deck.get(22);
            case "Jack of Diamonds": return deck.get(23);
            case "Queen of Diamonds": return deck.get(24);
            case "King of Diamonds": return deck.get(25);
            case "Ace of Hearts": return deck.get(26);
            case "Two of Hearts": return deck.get(27);
            case "Three of Hearts": return deck.get(28);
            case "Four of Hearts": return deck.get(29);
            case "Five of Hearts": return deck.get(30);
            case "Six of Hearts": return deck.get(31);
            case "Seven of Hearts": return deck.get(32);
            case "Eight of Hearts": return deck.get(33);
            case "Nine of Hearts": return deck.get(34);
            case "Ten of Hearts": return deck.get(35);
            case "Jack of Hearts": return deck.get(36);
            case "Queen of Hearts": return deck.get(37);
            case "King of Hearts": return deck.get(38);
            case "Ace of Spades": return deck.get(39);
            case "Two of Spades": return deck.get(40);
            case "Three of Spades": return deck.get(41);
            case "Four of Spades": return deck.get(42);
            case "Five of Spades": return deck.get(43);
            case "Six of Spades": return deck.get(44);
            case "Seven of Spades": return deck.get(45);
            case "Eight of Spades": return deck.get(46);
            case "Nine of Spades": return deck.get(47);
            case "Ten of Spades": return deck.get(48);
            case "Jack of Spades": return deck.get(49);
            case "Queen of Spades": return deck.get(50);
            case "King of Spades": return deck.get(51);
            default: return deck.get(0); }}

    private static ImageView aceOfClubs = new ImageView(new Image("ace of clubs.png"));
    private static ImageView twoOfClubs = new ImageView(new Image("two of clubs.png"));
    private static ImageView threeOfClubs = new ImageView(new Image("three of clubs.png"));
    private static ImageView fourOfClubs = new ImageView(new Image("four of clubs.png"));
    private static ImageView fiveOfClubs = new ImageView(new Image("five of clubs.png"));
    private static ImageView sixOfClubs = new ImageView(new Image("six of clubs.png"));
    private static ImageView sevenOfClubs = new ImageView(new Image("seven of clubs.png"));
    private static ImageView eightOfClubs = new ImageView(new Image("eight of clubs.png"));
    private static ImageView nineOfClubs = new ImageView(new Image("nine of clubs.png"));
    private static ImageView tenOfClubs = new ImageView(new Image("ten of clubs.png"));
    private static ImageView jackOfClubs = new ImageView(new Image("jack of clubs.png"));
    private static ImageView queenOfClubs = new ImageView(new Image("queen of clubs.png"));
    private static ImageView kingOfClubs = new ImageView(new Image("king of clubs.png"));
    private static ImageView aceOfDiamonds = new ImageView(new Image("ace of diamonds.png"));
    private static ImageView twoOfDiamonds = new ImageView(new Image("two of diamonds.png"));
    private static ImageView threeOfDiamonds = new ImageView(new Image("three of diamonds.png"));
    private static ImageView fourOfDiamonds = new ImageView(new Image("four of diamonds.png"));
    private static ImageView fiveOfDiamonds = new ImageView(new Image("five of diamonds.png"));
    private static ImageView sixOfDiamonds = new ImageView(new Image("six of diamonds.png"));
    private static ImageView sevenOfDiamonds = new ImageView(new Image("seven of diamonds.png"));
    private static ImageView eightOfDiamonds = new ImageView(new Image("eight of diamonds.png"));
    private static ImageView nineOfDiamonds = new ImageView(new Image("nine of diamonds.png"));
    private static ImageView tenOfDiamonds = new ImageView(new Image("ten of diamonds.png"));
    private static ImageView jackOfDiamonds = new ImageView(new Image("jack of diamonds.png"));
    private static ImageView queenOfDiamonds = new ImageView(new Image("queen of diamonds.png"));
    private static ImageView kingOfDiamonds = new ImageView(new Image("king of diamonds.png"));
    private static ImageView aceOfHearts = new ImageView(new Image("ace of hearts.png"));
    private static ImageView twoOfHearts = new ImageView(new Image("two of hearts.png"));
    private static ImageView threeOfHearts = new ImageView(new Image("three of hearts.png"));
    private static ImageView fourOfHearts = new ImageView(new Image("four of hearts.png"));
    private static ImageView fiveOfHearts = new ImageView(new Image("five of hearts.png"));
    private static ImageView sixOfHearts = new ImageView(new Image("six of hearts.png"));
    private static ImageView sevenOfHearts = new ImageView(new Image("seven of hearts.png"));
    private static ImageView eightOfHearts = new ImageView(new Image("eight of hearts.png"));
    private static ImageView nineOfHearts = new ImageView(new Image("nine of hearts.png"));
    private static ImageView tenOfHearts = new ImageView(new Image("ten of hearts.png"));
    private static ImageView jackOfHearts = new ImageView(new Image("jack of hearts.png"));
    private static ImageView queenOfHearts = new ImageView(new Image("queen of hearts.png"));
    private static ImageView kingOfHearts = new ImageView(new Image("king of hearts.png"));
    private static ImageView aceOfSpades = new ImageView(new Image("ace of spades.png"));
    private static ImageView twoOfSpades = new ImageView(new Image("two of spades.png"));
    private static ImageView threeOfSpades = new ImageView(new Image("three of spades.png"));
    private static ImageView fourOfSpades = new ImageView(new Image("four of spades.png"));
    private static ImageView fiveOfSpades = new ImageView(new Image("five of spades.png"));
    private static ImageView sixOfSpades = new ImageView(new Image("six of spades.png"));
    private static ImageView sevenOfSpades = new ImageView(new Image("seven of spades.png"));
    private static ImageView eightOfSpades = new ImageView(new Image("eight of spades.png"));
    private static ImageView nineOfSpades = new ImageView(new Image("nine of spades.png"));
    private static ImageView tenOfSpades = new ImageView(new Image("ten of spades.png"));
    private static ImageView jackOfSpades = new ImageView(new Image("jack of spades.png"));
    private static ImageView queenOfSpades = new ImageView(new Image("queen of spades.png"));
    private static ImageView kingOfSpades = new ImageView(new Image("king of spades.png"));
    public static ImageView backOfCard = new ImageView("back of card.png");

    static {
        aceOfClubs.setId("Ace of Clubs");
        twoOfClubs.setId("Two of Clubs");
        threeOfClubs.setId("Three of Clubs");
        fourOfClubs.setId("Four of Clubs");
        fiveOfClubs.setId("Five of Clubs");
        sixOfClubs.setId("Six of Clubs");
        sevenOfClubs.setId("Seven of Clubs");
        eightOfClubs.setId("Eight of Clubs");
        nineOfClubs.setId("Nine of Clubs");
        tenOfClubs.setId("Ten of Clubs");
        jackOfClubs.setId("Jack of Clubs");
        queenOfClubs.setId("Queen of Clubs");
        kingOfClubs.setId("King of Clubs");
        aceOfDiamonds.setId("Ace of Diamonds");
        twoOfDiamonds.setId("Two of Diamonds");
        threeOfDiamonds.setId("Three of Diamonds");
        fourOfDiamonds.setId("Four of Diamonds");
        fiveOfDiamonds.setId("Five of Diamonds");
        sixOfDiamonds.setId("Six of Diamonds");
        sevenOfDiamonds.setId("Seven of Diamonds");
        eightOfDiamonds.setId("Eight of Diamonds");
        nineOfDiamonds.setId("Nine of Diamonds");
        tenOfDiamonds.setId("Ten of Diamonds");
        jackOfDiamonds.setId("Jack of Diamonds");
        queenOfDiamonds.setId("Queen of Diamonds");
        kingOfDiamonds.setId("King of Diamonds");
        aceOfHearts.setId("Ace of Hearts");
        twoOfHearts.setId("Two of Hearts");
        threeOfHearts.setId("Three of Hearts");
        fourOfHearts.setId("Four of Hearts");
        fiveOfHearts.setId("Five of Hearts");
        sixOfHearts.setId("Six of Hearts");
        sevenOfHearts.setId("Seven of Hearts");
        eightOfHearts.setId("Eight of Hearts");
        nineOfHearts.setId("Nine of Hearts");
        tenOfHearts.setId("Ten of Hearts");
        jackOfHearts.setId("Jack of Hearts");
        queenOfHearts.setId("Queen of Hearts");
        kingOfHearts.setId("King of Hearts");
        aceOfSpades.setId("Ace of Spades");
        twoOfSpades.setId("Two of Spades");
        threeOfSpades.setId("Three of Spades");
        fourOfSpades.setId("Four of Spades");
        fiveOfSpades.setId("Five of Spades");
        sixOfSpades.setId("Six of Spades");
        sevenOfSpades.setId("Seven of Spades");
        eightOfSpades.setId("Eight of Spades");
        nineOfSpades.setId("Nine of Spades");
        tenOfSpades.setId("Ten of Spades");
        jackOfSpades.setId("Jack of Spades");
        queenOfSpades.setId("Queen of Spades");
        kingOfSpades.setId("King of Spades"); }

    public static ImageView returnImage(String name) {

        switch (name) {
            case "Ace of Clubs": return aceOfClubs;
            case "Two of Clubs": return twoOfClubs;
            case "Three of Clubs": return threeOfClubs;
            case "Four of Clubs": return fourOfClubs;
            case "Five of Clubs": return fiveOfClubs;
            case "Six of Clubs": return sixOfClubs;
            case "Seven of Clubs": return sevenOfClubs;
            case "Eight of Clubs": return eightOfClubs;
            case "Nine of Clubs": return nineOfClubs;
            case "Ten of Clubs": return tenOfClubs;
            case "Jack of Clubs": return jackOfClubs;
            case "Queen of Clubs": return queenOfClubs;
            case "King of Clubs": return kingOfClubs;
            case "Ace of Diamonds": return aceOfDiamonds;
            case "Two of Diamonds": return twoOfDiamonds;
            case "Three of Diamonds": return threeOfDiamonds;
            case "Four of Diamonds": return fourOfDiamonds;
            case "Five of Diamonds": return fiveOfDiamonds;
            case "Six of Diamonds": return sixOfDiamonds;
            case "Seven of Diamonds": return sevenOfDiamonds;
            case "Eight of Diamonds": return eightOfDiamonds;
            case "Nine of Diamonds": return nineOfDiamonds;
            case "Ten of Diamonds": return tenOfDiamonds;
            case "Jack of Diamonds": return jackOfDiamonds;
            case "Queen of Diamonds": return queenOfDiamonds;
            case "King of Diamonds": return kingOfDiamonds;
            case "Ace of Hearts": return aceOfHearts;
            case "Two of Hearts": return twoOfHearts;
            case "Three of Hearts": return threeOfHearts;
            case "Four of Hearts": return fourOfHearts;
            case "Five of Hearts": return fiveOfHearts;
            case "Six of Hearts": return sixOfHearts;
            case "Seven of Hearts": return sevenOfHearts;
            case "Eight of Hearts": return eightOfHearts;
            case "Nine of Hearts": return nineOfHearts;
            case "Ten of Hearts": return tenOfHearts;
            case "Jack of Hearts": return jackOfHearts;
            case "Queen of Hearts": return queenOfHearts;
            case "King of Hearts": return kingOfHearts;
            case "Ace of Spades": return aceOfSpades;
            case "Two of Spades": return twoOfSpades;
            case "Three of Spades": return threeOfSpades;
            case "Four of Spades": return fourOfSpades;
            case "Five of Spades": return fiveOfSpades;
            case "Six of Spades": return sixOfSpades;
            case "Seven of Spades": return sevenOfSpades;
            case "Eight of Spades": return eightOfSpades;
            case "Nine of Spades": return nineOfSpades;
            case "Ten of Spades": return tenOfSpades;
            case "Jack of Spades": return jackOfSpades;
            case "Queen of Spades": return queenOfSpades;
            case "King of Spades": return kingOfSpades;
            default: return backOfCard; }}}
