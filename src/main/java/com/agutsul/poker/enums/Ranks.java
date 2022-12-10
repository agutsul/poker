package com.agutsul.poker.enums;

import com.agutsul.poker.Rank;

import static org.apache.commons.lang3.StringUtils.upperCase;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public enum Ranks implements Rank {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN("T", 10),
    JACK("J", 11),
    QUEEN("Q", 12),
    KING("K", 13),
    ACE("A", 14);

    private static final Map<String, Rank> BY_LABELS =
            Stream.of(Ranks.values()).collect(toMap(Ranks::label, identity()));

    private final String label;
    private final int value;

    Ranks(int value) {
        this(String.valueOf(value), value);
    }

    Ranks(String label, int value) {
        this.label = label;
        this.value = value;
    }

    public static Rank rankOf(String label) {
        return BY_LABELS.get(upperCase(label));
    }

    @Override
    public int value() {
        return value;
    }

    @Override
    public String label() {
        return label;
    }

    @Override
    public String toString() {
        return label();
    }
}
