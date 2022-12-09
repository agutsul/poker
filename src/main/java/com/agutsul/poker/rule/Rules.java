package com.agutsul.poker.rule;

import com.agutsul.poker.Card;
import com.agutsul.poker.Hand;

import java.util.Collection;
import java.util.Optional;

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
    public Hand evaluate(Collection<Card> cards) {
        Collection<Card> matchedCards = function.apply(cards);
        if (matchedCards.isEmpty()) {
            return null;
        }

        return new Hand(this, cards, matchedCards);
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
