package com.agutsul.poker.rule;

import com.agutsul.poker.Card;
import com.agutsul.poker.Suit;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.emptyList;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.*;

final class SameSuitCardFunction implements CardFunction {

    SameSuitCardFunction() {}

    @Override
    public Collection<Card> apply(Collection<Card> cards) {
        Map<Suit, Set<Card>> cardsBySuit = cards.stream()
                .collect(groupingBy(Card::getSuit, toSet()));

        if (cardsBySuit.size() != 1) {
            return emptyList();
        }

        return cardsBySuit.values().stream()
                .flatMap(Collection::stream)
                .sorted(reverseOrder())
                .collect(toList());
    }
}
