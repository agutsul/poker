package com.agutsul.poker.impl;

import com.agutsul.poker.Card;
import com.agutsul.poker.Hand;
import com.agutsul.poker.Rule;
import com.agutsul.poker.impl.function.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

public enum Rules implements Rule {
    ROYAL_FLUSH("Royal Flush",       new RoyalFlushCardFunction()) ,
    STRAIGHT_FLUSH("Straight Flush", new StraightFlushCardFunction()),
    FOUR_OF_KIND("Four Cards",       new QuantityRankCardFunction(4)),
    FULL_HOUSE("Full House",         new FullHouseCardFunction()),
    FLUSH("Flush",                   new SameSuitCardFunction()),
    STRAIGHT("Straight",             new StraightRankCardFunction()),
    THREE_OF_KIND("Three Cards",     new QuantityRankCardFunction(3)),
    TWO_PAIRS("Two Pairs",           new PairRankCardFunction(2)),
    ONE_PAIR( "One Pair",            new PairRankCardFunction(1)),
    HIGH_CARD("Highest Card",        new HighestCardFunction());

    private final String label;
    private final CardFunction function;

    Rules(String label, CardFunction function) {
        this.label = label;
        this.function = function;
    }

    @Override
    public Optional<Hand> evaluate(Collection<Card> cards) {
        Collection<Card> matchedCards = function.apply(cards);
        if (matchedCards.isEmpty()) {
            return Optional.empty();
        }

        List<Card> nonMatchedCards = cards.stream()
                .filter(card -> !matchedCards.contains(card))
                .sorted(reverseOrder())
                .collect(toList());

        return Optional.of(new HandImpl(this, matchedCards, nonMatchedCards));
    }

    @Override
    public String label() {
        return label;
    }

    @Override
    public int value() {
        return Rules.values().length - ordinal();
    }

    @Override
    public String toString() {
        return label();
    }
}
