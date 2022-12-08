package com.agutsul.poker;

import com.agutsul.poker.rule.Rules;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

public class Player {
    private final String name;
    private final List<Card> cards;
    private Hand hand;

    Player(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards.stream().sorted(reverseOrder()).collect(toList());
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

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
