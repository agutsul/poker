package com.agutsul.poker.rule;

import com.agutsul.poker.enums.Ranks;

import java.util.List;
import java.util.Set;

import static java.util.EnumSet.range;

final class RoyalFlushCardFunction extends StraightFlushCardFunction {

    private static final List<Set<Ranks>> STRAIGHTS = List.of(range(Ranks.TEN, Ranks.ACE));

    RoyalFlushCardFunction() {
        super(STRAIGHTS);
    }
}
