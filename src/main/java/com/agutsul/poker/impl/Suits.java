package com.agutsul.poker.impl;

import com.agutsul.poker.Suit;

import static org.apache.commons.lang3.StringUtils.upperCase;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public enum Suits implements Suit {
    SPADES("S", '\u2660'),
    HEARTS("H", '\u2764'),
    CLUBS("C", '\u2663'),
    DIAMONDS("D", '\u2666');

    private static final Map<String, Suit> BY_LABELS =
            Stream.of(Suits.values()).collect(toMap(Suit::label, identity()));

    private final String label;
    private final char code;

    Suits(String label, char code) {
        this.label = label;
        this.code = code;
    }

    public static Suit suitOf(String label) {
        return BY_LABELS.get(upperCase(label));
    }

    @Override
    public String label() {
        return label;
    }

    @Override
    public String code() {
        return Character.toString(code);
    }

    @Override
    public String toString() {
        return code();
    }
}
