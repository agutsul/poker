package com.agutsul.poker.comparator;

import com.agutsul.poker.Suit;

import java.util.Comparator;

public class SuitComparator implements Comparator<Suit> {

    @Override
    public int compare(Suit suit1, Suit suit2) {
        return Integer.compare(suit1.value(), suit2.value());
    }
}