package com.agutsul.poker.impl;

import com.agutsul.poker.Card;
import com.agutsul.poker.Hand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

final class HandComparator implements Comparator<Hand> {

    private static final CardsComparator COMPARATOR = new CardsComparator();

    @Override
    public int compare(Hand hand1, Hand hand2) {
        int handComparison = hand1.compareTo(hand2);
        if (handComparison != 0) {
            return handComparison;
        }

        int comparison = COMPARATOR.compare(hand1.getMatchedCards(), hand2.getMatchedCards());
        if (comparison != 0) {
            return comparison;
        }

        return COMPARATOR.compare(hand1.getNonMatchedCards(), hand2.getNonMatchedCards());
    }

    private static class CardsComparator implements Comparator<Collection<Card>> {

        @Override
        public int compare(Collection<Card> col1, Collection<Card> col2) {
            List<Card> cards1 = new ArrayList<>(col1);
            List<Card> cards2 = new ArrayList<>(col2);

            for (int i = 0; i < cards1.size(); i++) {
                Card card1 = cards1.get(i);
                Card card2 = cards2.get(i);

                int comparison = card1.compareTo(card2);
                if (comparison != 0) {
                    return comparison;
                }
            }

            return 0;
        }
    }
}