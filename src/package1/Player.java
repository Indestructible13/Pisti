package package1;

import java.util.ArrayList;

public class Player {

    public ArrayList<Card> hand = new ArrayList<>();
    private int score = 0;
    private int numberOfCardsWon = 0;
    private int turnx;
    private static boolean lastCaptured=true;

    public Player(int turn) {
        this.turnx=turn; }

    public int getTurn() {
        return turnx; }

    public void setTurn(int turn) {
        this.turnx = turn; }

    public Player(ArrayList<Card> hand) {
        this.hand = hand; }

    public void addCardToHand(int num) {
        hand.add(Deck.randomDeck.get(num)); }

    public void printHand() {
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(hand.get(i).toString()); }}

    public Card getCardFromId(String id){
        for (int i = 0; i < hand.size(); i++) {
            if(hand.get(i).name.equals(id))
                return hand.get(i); }
        return null; }

    public void playCard(String name, int turn) {
        try {

            if (Deck.returnCard(name).value == 11) {
                Pile.cardsOnPile.add(Deck.returnCard(name));
                addScore();
                Pile.cardsOnPile.clear();
                hand.remove(getCardFromId(name)); }

            else if (Pile.cardsOnPile.size() > 0 && (Deck.returnCard(name).value == Deck.returnCard(Pile.cardsOnPile.get(Pile.cardsOnPile.size() - 1).toString()).value)) {
                Pile.cardsOnPile.add(Deck.returnCard(name));
                addScore();
                Pile.cardsOnPile.clear();
                hand.remove(getCardFromId(name)); }

            else if (Pile.cardsOnPile.size() == 0 || (Deck.returnCard(name).value != Deck.returnCard(Pile.cardsOnPile.get(Pile.cardsOnPile.size() - 1).toString()).value)) {
                Pile.cardsOnPile.add(Deck.returnCard(name));
                hand.remove(getCardFromId(name)); } }

        catch (ArrayIndexOutOfBoundsException ex) {
            Pile.cardsOnPile.add(Deck.returnCard(name));
            hand.remove(getCardFromId(name)); }

        if(turn== 0){
            if (Pile.cardsOnPile.size() > 0)
                Main.pile.getChildren().add(Deck.returnImage(Pile.cardsOnPile.get(Pile.cardsOnPile.size() - 1).toString()));
            else {
                Main.pile.getChildren().add(Deck.returnImage(name));
                Main.pile.getChildren().clear(); }}

        else if (turn== 1){
            if (Pile.cardsOnPile.size() > 0)
                Main.pile.getChildren().add(Deck.returnImage(Pile.cardsOnPile.get(Pile.cardsOnPile.size() - 1).toString()));
            else
                Main.pile.getChildren().clear();

            Main.cpuCards.getChildren().remove(Main.cpuCards.getChildren().size()-1); }}


    public void addScore() {
        if(getTurn()==0)
            lastCaptured=true;
        else
            lastCaptured=false;

        for (int i = 0; i < Pile.cardsOnPile.size(); i++) {

            if (Pile.cardsOnPile.get(i).value == 1 || Pile.cardsOnPile.get(i).value == 10 ||
                    Pile.cardsOnPile.get(i).value == 11 || Pile.cardsOnPile.get(i).value == 12 ||
                    Pile.cardsOnPile.get(i).value == 13) {
                setScore(getScore() + 1); }
            if (Pile.cardsOnPile.get(i).name == "Two of Clubs")
                setScore(getScore() + 2);
            if (Pile.cardsOnPile.get(i).name == "Ten of Diamonds")
                setScore(getScore() + 3);  }

        if (Pile.cardsOnPile.size() == 2 && Pile.cardsOnPile.get(Pile.cardsOnPile.size()-1).value == 11 && Pile.cardsOnPile.get(Pile.cardsOnPile.size()-2).value == 11) {
            setScore(getScore() + 20); }

        else if (Pile.cardsOnPile.size() == 2) {
            setScore(getScore() + 10); }

        setNumberOfCardsWon(getNumberOfCardsWon() + 1); }

    public int getScore() {
        return score; }

    public void setScore(int score) {
        this.score = score; }

    public int getNumberOfCardsWon() {
        return numberOfCardsWon; }

    public void setNumberOfCardsWon(int numberOfCardsWon) {
        this.numberOfCardsWon = numberOfCardsWon; }

    public static boolean getLastCapture() {
        return lastCaptured; }

    public void setLastCapture(boolean lastCaptured){
        this.lastCaptured = lastCaptured; }}
