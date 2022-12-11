package com.agutsul.poker;

import com.agutsul.poker.rule.Rules;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Player {
    private final String name;
    private final List<Card> cards;
    private final Hand hand;

    public Player(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
        this.hand = evaluate(cards);
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Hand getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return String.format("%s: %s - %s", name, cards, hand);
    }

    private static Hand evaluate(List<Card> cards) {
        return Stream.of(Rules.values())
                .map(rule -> rule.evaluate(cards))
                .filter(Objects::nonNull)
                .findFirst()
                .get();
    }
}
