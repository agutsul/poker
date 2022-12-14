package com.agutsul.poker.comparator;

import com.agutsul.poker.Card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

final class CardsComparator implements Comparator<Collection<Card>> {

    CardsComparator() {}

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