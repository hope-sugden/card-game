package org.example;

import java.util.Comparator;

public class SortIntoSuitsComparator implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        if(!card1.getSuit().equals(card2.getSuit())){
            return card1.getSuit().compareTo(card2.getSuit());
        }
        return card1.getValue() - card2.getValue();
    }
}

