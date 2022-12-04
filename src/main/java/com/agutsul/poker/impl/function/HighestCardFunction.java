package com.agutsul.poker.impl.function;

import com.agutsul.poker.Card;

import java.util.Collection;

import static java.util.Collections.singleton;
import static java.util.Comparator.naturalOrder;

public final class HighestCardFunction implements CardFunction {

    @Override
    public Collection<Card> apply(Collection<Card> cards) {
        return singleton(cards.stream().max(naturalOrder()).get());
    }
}
