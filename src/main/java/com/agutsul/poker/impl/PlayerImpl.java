package com.agutsul.poker.impl;

import com.agutsul.poker.Card;
import com.agutsul.poker.Hand;
import com.agutsul.poker.Player;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.reverseOrder;

public final class PlayerImpl implements Player {

    private final String name;
    private final List<Card> cards;
    private Hand hand;

    public PlayerImpl(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards.stream().sorted(reverseOrder()).collect(toList());
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public Hand getHand() {
        if (hand != null) {
            return hand;
        }

        this.hand = evaluateCards();
        return hand;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, cards);
    }

    private Hand evaluateCards() {
        return Stream.of(Rules.values())
                .map(rule -> rule.evaluate(cards))
                .filter(Optional::isPresent)
                .findFirst()
                .get()
                .get();
    }
}
