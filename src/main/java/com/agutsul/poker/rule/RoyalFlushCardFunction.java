package com.agutsul.poker.rule;

import com.agutsul.poker.Rank;

import java.util.List;
import java.util.Set;

import static com.agutsul.poker.enums.Ranks.ACE;
import static com.agutsul.poker.enums.Ranks.TEN;
import static java.util.EnumSet.range;

final class RoyalFlushCardFunction extends StraightFlushCardFunction {

    private static final Set<? extends Rank> STRAIGHTS = range(TEN, ACE);

    RoyalFlushCardFunction() {
        super(List.of(STRAIGHTS));
    }
}
