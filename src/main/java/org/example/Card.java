package org.example;

public class Card implements Comparable<Card> {

//    final means constant. Static means it belongs to class rather than instance. Uppercase, convention in the way classes are Upper case
    public static final String SPADES = "\u2660";
    public static final String HEARTS = "\u2661";
    public static final String DIAMONDS = "\u2662";
    public static final String CLUBS = "\u2663";

//    Instance variables, so belong to instance rather than class.
    private String suit;
    private String symbol;
    private int value;

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Card otherCard) {
        if(this.value != otherCard.value) {
            return this.value - otherCard.value;
        }
        return this.suit.compareTo(otherCard.suit);
    }

    @Override
    public String toString() {
        return this.symbol + " of " + this.suit;
    }

    public static void main(String[] args) {
        Card aceOfSpades = new Card(SPADES,"A",14);
//        aceOfSpades.setSuit(SPADES);
//        aceOfSpades.setSymbol("A");
        System.out.println(aceOfSpades);

        Card fourOfHearts = new Card(HEARTS, "4",4);
        System.out.println(fourOfHearts);

    }
}
