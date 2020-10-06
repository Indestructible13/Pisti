package package1;

public class Card {
    String name = "";
    int value = 0;
    int suit = 0;

    public Card() {}

    public Card(String name, int value, int suit) {
        this.name = name;
        this.value = value;
        this.suit = suit; }

    @Override
    public String toString() {
        return this.name; }}
