package com.agutsul.poker.rule;

import com.agutsul.poker.Card;

import java.util.Collection;

import static java.util.Collections.singleton;
import static java.util.Comparator.naturalOrder;

final class HighestCardFunction implements CardFunction {

    HighestCardFunction() {}

    @Override
    public Collection<Card> apply(Collection<Card> cards) {
        return singleton(cards.stream().max(naturalOrder()).get());
    }
}
