package com.agutsul.poker.impl.function;

import com.agutsul.poker.impl.Ranks;

import java.util.List;
import java.util.Set;

import static java.util.EnumSet.range;

public final class RoyalFlushCardFunction extends StraightFlushCardFunction {

    private static final List<Set<Ranks>> STRAIGHTS = List.of(range(Ranks.TEN, Ranks.ACE));

    public RoyalFlushCardFunction() {
        super(STRAIGHTS);
    }
}
