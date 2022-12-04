package com.agutsul.poker.impl.function;

import com.agutsul.poker.Card;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public final class QuantityRankCardFunction extends AbstractRankCardFunction {

    public QuantityRankCardFunction(int expectedQuantity) {
        super(expectedQuantity);
    }

    @Override
    protected Collection<Card> applyMatched(List<Set<Card>> matchedFrequency) {
        return matchedFrequency.stream()
                .flatMap(Collection::stream)
                .collect(toList());
    }
}
