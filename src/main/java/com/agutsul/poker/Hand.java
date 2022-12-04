package com.agutsul.poker;

import java.util.Collection;

public interface Hand extends Comparable<Hand> {
    Rule getRule();

    Collection<Card> getMatchedCards();

    Collection<Card> getNonMatchedCards();
}
