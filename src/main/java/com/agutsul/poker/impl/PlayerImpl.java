package com.agutsul.poker.impl;

import com.agutsul.poker.Card;
import com.agutsul.poker.Hand;
import com.agutsul.poker.Player;
import com.agutsul.poker.Rule;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.reverseOrder;

public final class PlayerImpl implements Player {

    private static final HandComparator COMPARATOR = new HandComparator();

    private final String name;
    private final List<Card> cards;
    private Optional<Hand> hand = Optional.empty();

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
    public Optional<Hand> getHand() {
        return hand;
    }

    @Override
    public void play() {
        this.hand = Stream.of(Rules.values())
                .map(rule -> rule.evaluate(cards))
                .filter(Optional::isPresent)
                .findFirst()
                .get();
    }

    @Override
    public int compareTo(Player player) {
        return COMPARATOR.compare(hand.get(), player.getHand().get());
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, cards);
    }
}
