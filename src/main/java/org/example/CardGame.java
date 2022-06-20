package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {

    private String name;
    private ArrayList<Card> deckOfCards = new ArrayList<>();

    public CardGame(String name) {
        this.name = name;
        generateDeckOfCards();
    }

    public String getName() {
        return name;
    }

    private void generateDeckOfCards() {
        String[] suits = new String[]{Card.SPADES, Card.CLUBS, Card.DIAMONDS, Card.HEARTS};
        String[] symbols = new String[] {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        int[] values = new int[] {2,3,4,5,6,7,8,9,10,11,12,13,14};
        int value = 0;

        for(String suit: suits){
            for (String symbol: symbols){
                if(symbol.equals("J")){
                    value = 11;
                }
                else if(symbol.equals("Q")){
                    value = 12;
                }
                else if(symbol.equals("K")){
                    value = 13;
                }
                else if(symbol.equals("A")){
                    value = 14;
                }
                else{
                    value = Integer.parseInt(symbol);
                }
                Card newCard = new Card(suit,symbol,value);
                deckOfCards.add(newCard);
            }
        }

    }

    @Override
    public String toString() {
        return deckOfCards.toString();
    }

    public Card dealCard() {
        if(deckOfCards.isEmpty()){
            return null;
        }
        Card firstCard = this.deckOfCards.remove(0);
        return firstCard;
    }

    public void shuffleDeck() {
        Collections.shuffle(this.deckOfCards);
    }

    public void sortDeckInNumberOrder(){
        Collections.sort(this.deckOfCards);
    }

    public void sortDeckIntoSuits(){
//        Comparator<Card> SortIntoSuitsComparator = new SortIntoSuitsComparator();
//        Write  a class to implements comparator to compare two card objects.
        Collections.sort(this.deckOfCards,new SortIntoSuitsComparator());
    }

    public static void main(String[] args) {
        CardGame cardGame = new CardGame("snap");
        System.out.println(cardGame);
        System.out.println(cardGame.dealCard());
        System.out.println(cardGame.deckOfCards.size());

        cardGame.shuffleDeck();
        System.out.println(cardGame);
        System.out.println(cardGame.deckOfCards.size());

        cardGame.sortDeckInNumberOrder();
        System.out.println(cardGame);
        System.out.println(cardGame.deckOfCards.size());

        cardGame.sortDeckIntoSuits();
        System.out.println(cardGame);
        System.out.println(cardGame.deckOfCards.size());

    }
}
