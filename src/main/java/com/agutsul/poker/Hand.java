package com.agutsul.poker;

import com.agutsul.poker.comparator.HandComparator;
import com.agutsul.poker.rule.Rule;

import java.util.Collection;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

public class Hand implements Comparable<Hand> {

    private static final HandComparator HAND_COMPARATOR = new HandComparator();

    private final Rule rule;
    private final Collection<Card> cards;
    private final Collection<Card> matchedCards;

    public Hand(Rule rule, Collection<Card> cards, Collection<Card> matchedCards) {
        this.rule = rule;
        this.cards = cards;
        this.matchedCards = matchedCards;
    }

    public Rule getRule() {
        return rule;
    }

    public Collection<Card> getMatchedCards() {
        return matchedCards;
    }

    public Collection<Card> getCards() {
        return cards;
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
        return HAND_COMPARATOR.compare(this, hand);
    }
}
