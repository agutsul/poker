package com.agutsul.poker.comparator;

import com.agutsul.poker.Rank;

import java.util.Comparator;

public class RankComparator implements Comparator<Rank> {
    @Override
    public int compare(Rank rank1, Rank rank2) {
        return Integer.compare(rank1.value(), rank2.value());
    }
}