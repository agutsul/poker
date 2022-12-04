package com.agutsul.poker.impl;

import com.agutsul.poker.Card;
import com.agutsul.poker.Hand;
import com.agutsul.poker.Rule;

import java.util.Collection;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

public final class HandImpl implements Hand {
    private final Rule rule;
    private final Collection<Card> matchedCards;
    private final Collection<Card> nonMatchedCards;
    public HandImpl(Rule rule,
                Collection<Card> matchedCards,
                Collection<Card> nonMatchedCards) {
        this.rule = rule;
        this.matchedCards = matchedCards;
        this.nonMatchedCards = nonMatchedCards;
    }

    @Override
    public Rule getRule() {
        return rule;
    }
    @Override
    public Collection<Card> getMatchedCards() {
        return matchedCards;
    }
    @Override
    public Collection<Card> getNonMatchedCards() {
        return nonMatchedCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Hand hand = (Hand) o;
        return Objects.equals(rule, hand.getRule())
                && Objects.equals(matchedCards, hand.getMatchedCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(rule, matchedCards);
    }

    @Override
    public String toString() {
        return String.format("%s: [%s]", rule,
                matchedCards.stream().map(Card::toString).collect(joining(" ")));
    }

    @Override
    public int compareTo(Hand hand) {
        return Integer.compare(rule.value(), hand.getRule().value());
    }
}
